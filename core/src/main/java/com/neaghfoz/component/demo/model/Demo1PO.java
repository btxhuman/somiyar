package com.neaghfoz.component.demo.model;

import java.io.Serializable;

public class Demo1PO implements Serializable{
    public String demo1Id;

	public String name;

    public String getDemo1Id() {
        return demo1Id;
    }

    public void setDemo1Id(String demo1Id) {
        this.demo1Id = demo1Id;
    }

    public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
