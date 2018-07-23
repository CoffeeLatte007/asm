/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.util;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: ASMUtil.java, v 0.1 2018-05-07 下午6:29 @lizhao $$
 */
public class ASMUtil {
    /**
     * L +className+ ;
     * @param c
     * @return
     */
    public static String getASMDescByClass(Class c){
        return "L"+ c.getName().replaceAll("\\.","/")+";";
    }

    /**
     * 包名. 转换 /
     */
    public static String getASMOwnerByClass(Class c){
        return c.getName().replaceAll("\\.","/");
    }
    public static Class getClassByASMDesc(String desc) throws ClassNotFoundException {
        String className = desc.substring(1, desc.length()-1).replace("/", ".");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.loadClass(className);
    }
}