/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: DesValueType.java, v 0.1 2018-05-07 下午5:26 @lizhao Exp $$
 */
public enum DesValueType {
    /**
     * 默认不加密
     */
    NONE("", "", ""),
    /**
     * 电话号码，手机号码一类
     */
    MOBILE("mobile", "mobilePhone", "(Ljava/lang/String;)Ljava/lang/String;"),
    /**
     * 地址
     */
    ADDRESS("address", "address", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;"),
    /**
     * 身份证
     */
    IDCARD("idcard","identificationNum", "(Ljava/lang/String;)Ljava/lang/String;"),
    /**
     * 姓名
     */
    NAME("name","chineseName", "(Ljava/lang/String;)Ljava/lang/String;");

    private String value;
    private String methodName;
    //参数字段和返回值
    private String methodDesc;
    private static Map<String, DesValueType> desValueTypeMap = Maps.newHashMap();
    static {
        for (DesValueType desValueType : DesValueType.values()){
            desValueTypeMap.put(desValueType.getValue(), desValueType);
        }
    }
    DesValueType(String value, String methodName, String methodDesc) {
        this.value = value;
        this.methodName = methodName;
        this.methodDesc = methodDesc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }
}