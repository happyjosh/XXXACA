package com.jph.xxxaca.data.entity;

import java.io.Serializable;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDetail implements Serializable{
    private static final long serialVersionUID = -6212599757409510180L;
    private String name;

    public UserDetail(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
