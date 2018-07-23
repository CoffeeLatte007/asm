/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.filter;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: BaseDesFilter.java, v 0.1 2018-05-07 下午7:46 @lizhao $$
 */
public interface BaseDesFilter <T>{
    default T desc(T needDesc){
        return needDesc;
    };
}