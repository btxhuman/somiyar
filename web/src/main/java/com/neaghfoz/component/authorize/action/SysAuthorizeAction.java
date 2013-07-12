package com.neaghfoz.component.authorize.action;

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
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("menu.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);
        Element root = document.getRootElement();
        iteratorAll(root);
        System.out.println(document.asXML());
    }

    private static void iteratorAll(Element element) {
        Collection<String> aus = new ArrayList<String>();
        aus.add("2");
        aus.add("5");
        List<Element> list = element.elements();
        if (null != list && list.size() != 0) {
            for (Iterator<Element> it = element.elementIterator(); it.hasNext(); ) {
                Element temp = it.next();
                Attribute attribute = temp.attribute("permission");
                if (attribute != null) {
                    String permissionCode = attribute.getText();
                    if (StringUtils.isNotBlank(permissionCode)) {
                        System.out.println(temp.attribute("name").getText() + ":" + aus.contains(permissionCode));
                        if (!aus.contains(permissionCode)) {
                            temp.getParent().remove(temp);
                            continue;
                        }else{
                            iteratorAll(temp);
                        }
                    }
                } else {
                    iteratorAll(temp);
                }

            }
        }
    }
}
