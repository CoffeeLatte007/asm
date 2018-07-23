/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.filter;



/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: MobileDesFilter.java, v 0.1 2018-05-07 下午7:49 @lizhao $$
 */
public class MobileDesFilter implements BaseDesFilter {
    //不同类型转换
    @Override
    public Object desc(Object needDesc) {
        if(needDesc instanceof Long ){
            needDesc = String.valueOf(needDesc);
        }
        if (needDesc instanceof String){
            return DesensitizationUtil.mobileDesensitiza((String) needDesc);
        }
        //如果这个时候是枚举类，todo
        return needDesc;
    }
}