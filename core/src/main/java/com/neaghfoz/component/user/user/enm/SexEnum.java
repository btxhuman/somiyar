package com.neaghfoz.component.user.user.enm;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public enum SexEnum {
    Man(0,"男"),Women(1,"女")
    ;
    private Integer value;
    private String desc;

    private SexEnum(Integer value,String desc){
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
