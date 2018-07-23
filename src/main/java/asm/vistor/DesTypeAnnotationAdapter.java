/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.vistor;

import asm.util.ASMUtil;
import asm.filter.DesFilterMap;
import asm.FiledInfo;
import asm.filter.BaseDesFilter;
import org.objectweb.asm.AnnotationVisitor;

import java.util.Objects;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: DesTypeAnnotationAdapter.java, v 0.1 2018-05-07 下午6:24 @lizhao $$
 */
public class DesTypeAnnotationAdapter extends AnnotationVisitor {
    private static final String VALUE = "value";
    private FiledInfo filedInfo;
    public DesTypeAnnotationAdapter(int api) {
        super(api);
    }

    public DesTypeAnnotationAdapter(int api, AnnotationVisitor av) {
        super(api, av);
    }

    public DesTypeAnnotationAdapter(int api, AnnotationVisitor av, FiledInfo filedInfo) {
        super(api, av);
        this.filedInfo = filedInfo;
    }

    @Override
    public void visit(String name, Object value) {
        super.visit(name, value);
        if (VALUE.equals(name)){
            try {
                Class fliterClass = ASMUtil.getClassByASMDesc(value.toString());
                BaseDesFilter desFilter = DesFilterMap.get(fliterClass);
                //如果为空就新生成一个到map里面
                if (Objects.isNull(desFilter)){
                    DesFilterMap.put(fliterClass, (BaseDesFilter) fliterClass.newInstance());
                }
                filedInfo.setFilterClass(fliterClass);
            } catch (ClassNotFoundException e) {
//                LOGGER.error("找不到类:tpee:{}",value, e);
                e.printStackTrace();
            } catch (Exception e) {
//                LOGGER.error("解析注解出现错误: name:{},tpee:{}", name,value, e);
                e.printStackTrace();
            }
        }
    }

}