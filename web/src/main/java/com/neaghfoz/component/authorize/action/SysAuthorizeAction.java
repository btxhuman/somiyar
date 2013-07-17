package com.neaghfoz.component.authorize.action;

import com.neaghfoz.common.WebContext;
import com.neaghfoz.component.authorize.dao.impl.PermissionDAOImpl;
import com.neaghfoz.framework.base.PermissionAnnotation;
import com.neaghfoz.framework.struts.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 后台登录（具体实现是由spring-security来实现）
 *
 * @author btxhuman
 *         *
 */
public class SysAuthorizeAction extends BaseAction {

    public String toLogin() {
        return "toLogin";
    }

    public String logout() {
        return "logout";
    }

    public String index() {
        return "index";
    }

    @PermissionAnnotation(value = {"ROLE_USER", "test2"}, matchAll = false)
    public String test() {
        return "test";
    }

    public static void main(String[] args) throws DocumentException {
        Collection<String> aus_1 = new ArrayList<String>();
        aus_1.add("2");
        aus_1.add("5");
        Collection<String> aus_2 = new ArrayList<String>();
        aus_2.add("1");
        aus_2.add("2");
        aus_2.add("5");
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("menu.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);
        Element root1 = (Element) document.getRootElement().clone();
        iteratorAll(aus_1,root1);
        Element root2 = (Element) document.getRootElement().clone();
        iteratorAll(aus_2,root2);
        System.out.println(root1.asXML());
        System.out.println(root2.asXML());
    }

    private static void iteratorAll(Collection<String> aus,Element element) {

        List<Element> list = element.elements();
        if (null != list && list.size() != 0) {
            for (Iterator<Element> it = element.elementIterator(); it.hasNext(); ) {
                Element temp = it.next();
                Attribute attribute = temp.attribute("permission");
                if (attribute != null) {
                    String permissionCode = attribute.getText();
//                    System.out.println(temp.attribute("name").getText() + ":" + aus.contains(permissionCode));
                    if (StringUtils.isNotBlank(permissionCode) && !aus.contains(permissionCode)) {
                        temp.getParent().remove(temp);
                    }else{
                        iteratorAll(aus,temp);
                    }
                } else {
                    iteratorAll(aus,temp);
                }

            }
        }
    }
}
