/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.filter;

import asm.filter.BaseDesFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *  保存Filter的地方
 * @author 563868273@qq.com
 * @version $Id: DesFilterMap.java, v 0.1 2018-05-07 下午8:25 @lizhao $$
 */
public class DesFilterMap {
    private static Map<String, BaseDesFilter> desFilterMap = new HashMap<>();
    public static void put(Class<? extends BaseDesFilter> c, BaseDesFilter baseDesFilter){
        desFilterMap.put(c.getName(), baseDesFilter);
    }
    public static BaseDesFilter get(Class<? extends BaseDesFilter> c){
        return desFilterMap.get(c.getName());
    }
    public static BaseDesFilter getByClassName(String className){
        return desFilterMap.get(className);
    }
}