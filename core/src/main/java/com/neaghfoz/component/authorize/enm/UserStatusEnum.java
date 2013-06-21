package com.neaghfoz.component.authorize.enm;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public enum UserStatusEnum {

    Normal(0,"正常"),Disable(1,"禁用")
    ;

    private Integer value;
    private String desc;

    private UserStatusEnum(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
