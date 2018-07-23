/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm;


import asm.filter.BaseDesFilter;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: FiledInfo.java, v 0.1 2018-05-06 下午10:07 @lizhao $$
 */
public class FiledInfo {
    private int acc;
    private String name;
    private String type;
    private String generic;
    private Object defaultValue;
    private boolean isDes;
    private Class<? extends BaseDesFilter> filterClass;
    public FiledInfo(int acc, String name, String type, String generic, Object defaultValue) {
        this.acc = acc;
        this.name = name;
        this.type = type;
        this.generic = generic;
        this.defaultValue = defaultValue;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isDes() {
        return isDes;
    }

    public void setDes(boolean des) {
        isDes = des;
    }

    public Class<? extends BaseDesFilter> getFilterClass() {
        return filterClass;
    }
    public void setFilterClass(Class<? extends BaseDesFilter> filterClass) {
        this.filterClass = filterClass;
    }

    public boolean isNotDes() {
        return !isDes();
    }

}