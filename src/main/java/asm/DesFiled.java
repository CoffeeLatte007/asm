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
 * @version $Id: TestFiledAnnotation.java, v 0.1 2018-05-06 下午9:28 @lizhao $$
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Inherited
public @interface DesFiled {
    /**
     * 加密类型
     * @return
     */
    public Class<? extends BaseDesFilter> value() default BaseDesFilter.class;

}