package com.neaghfoz.framework.jdbc;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-19
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */
public final class ConvertFiledColumn {

    /**
     * 将符合命名规范的Java类字段（Field）名称转换成数据库表单的字段(column)名称
     * 命名规范如下：在Java类是 permissionId，那么对应的数据库字段名称就应该是 permission_id
     *
     * @param field Java类的字段名称
     */
    public static String convertFiled2Column(String field) {
        char[] chars = field.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0 && i != chars.length - 1 && !Character.isUpperCase(chars[i])
                    && Character.isUpperCase(chars[i+1])) {
                System.out.println(chars[i]);
                chars = ArrayUtils.add(chars,i+1,'_');
                i++;
            }
        }
        return new String(chars);
    }

    /**
     * 将符合命名规范的数据库表单的字段(column)名称转换成Java类字段（Field）名称
     * 命名规范如下：在Java类是 permissionId，那么对应的数据库字段名称就应该是 permission_id
     *
     * @param column 数据库表单的字段名称
     */
    public static String convertColumn2Filed(String column) {
        String[] strings = column.split("_");
        if(strings.length > 1){
            for(int i=1;i<strings.length;i++){
                char[] chars = strings[i].toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                strings[i] = new String(chars);

            }
            return StringUtils.join(strings,"");
        }else{
            return strings[0];
        }
    }

/*    public static void main(String[] args) {
        System.out.println(convertFiled2Column("message1TeachNumber"));
        System.out.println(convertColumn2Filed("message_teach_number"));
        System.out.println(StringUtils.capitalize("messageTeachNumber"));
        System.out.println(Character.isUpperCase('1'));
    }*/
}
