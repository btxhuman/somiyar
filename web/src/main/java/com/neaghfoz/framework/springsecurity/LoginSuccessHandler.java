package com.neaghfoz.framework.springsecurity;

import com.neaghfoz.common.WebAttributes;
import com.neaghfoz.common.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-13
 * Time: 下午11:05
 * To change this template use File | Settings | File Templates.
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    protected static final Log logger = LogFactory.getLog(LoginSuccessHandler.class);

    private static Document document = null;

    static {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("menu.xml");
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(is);
        } catch (DocumentException e) {
            logger.error("读取menu.xml失败");
        }
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);
        Element rootElement = (Element) document.getRootElement().clone();
        SimpleUserDetails userDetails = WebContext.getUserDetails();
        Collection<GrantedAuthority> authorities = userDetails.getAuthorities();
        createMenu(authorities, rootElement);
        String xml = rootElement.asXML();
        if(StringUtils.hasText(xml)){
            xml = xml.replaceAll("\\s+"," ");
        }
        request.getSession().setAttribute(WebAttributes.SYSADMIN_USER_MENU,xml);
    }

    private static void createMenu(Collection<GrantedAuthority> authorities, Element element) {

        List<Element> list = element.elements();
        if (null != list && list.size() != 0) {
            for (Iterator<Element> it = element.elementIterator(); it.hasNext(); ) {
                Element temp = it.next();
                Attribute attribute = temp.attribute("permission");
                if (attribute != null) {
                    String permissionCode = attribute.getText();

//                    System.out.println(temp.attribute("name").getText() + ":" + aus.contains(permissionCode));
                    if (StringUtils.hasText(permissionCode) && !authorities.contains(new SimpleGrantedAuthority(permissionCode))) {
                        temp.getParent().remove(temp);
                    } else {
                        createMenu(authorities, temp);
                    }
                    temp.remove(attribute);
                } else {
                    createMenu(authorities, temp);
                }
            }
        }
    }
}
