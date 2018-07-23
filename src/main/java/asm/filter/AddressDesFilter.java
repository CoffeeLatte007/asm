/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.filter;



import asm.util.DesensitizeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: AddressDesFilter.java, v 0.1 2018-05-07 下午11:57 @lizhao $$
 */
public class AddressDesFilter implements BaseDesFilter {
    @Override
    public Object desc(Object needDesc) {
        if (needDesc instanceof Iterable){
            List<Object> result = new ArrayList();
            Iterator it = ((Iterable) needDesc).iterator();
            while (it.hasNext()){
                Object next = it.next();
                if (next instanceof String){
                    result.add(DesensitizeUtil.address((String) next,5));
                    continue;
                }
                result.add(next);
            }
            return result;
        }
        return needDesc;
    }
}