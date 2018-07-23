/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.vistor;

import asm.Desensitized;
import asm.FiledInfo;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;


/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: TestClassVistor.java, v 0.1 2018-05-06 上午10:07 @lizhao $$
 */
public class DesClassVistor extends ClassVisitor implements Opcodes{

    private static final String classAnnotationType = "L"+ Desensitized.class.getName().replaceAll("\\.","/")+";";
    /**
     * 用来标志是否进行脱敏
     */
    private boolean des;
    private String className;
    private Map<String, FiledInfo> filedMap = new HashMap<>();
    public DesClassVistor(int i) {
        super(i);
    }

    public DesClassVistor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public void visit(int jdkVersion, int acc, String className, String generic, String superClass, String[] superInterface) {
        this.className = className;
        super.visit(jdkVersion, acc, className, generic, superClass, superInterface);
    }

    /**
     *
     * @param type 注解类型
     * @param seeing 可见性
     * @return
     */
    @Override
    public AnnotationVisitor visitAnnotation(String type, boolean seeing) {
        if (classAnnotationType.equals(type)){
            this.des = true;
        }
        return super.visitAnnotation(type, seeing);
    }

    /**
     *
     * @param acc 访问权限
     * @param name 字段名字
     * @param type 类型
     * @param generic 泛型
     * @param defaultValue 默认值
     * @return
     */
    @Override
    public FieldVisitor visitField(int acc, String name, String type, String generic, Object defaultValue) {
        FieldVisitor fv = super.visitField(acc, name, type, generic, defaultValue);
        if (des == false || acc >= ACC_STATIC){
            return fv;
        }
        FiledInfo filedInfo = new FiledInfo(acc, name, type, generic, defaultValue);
        filedMap.put(name, filedInfo);
        FieldVisitor testFieldVisitor = new DesFieldVisitor(filedInfo,fv);
        return testFieldVisitor;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (this.des == false || !"toString".equals(name)){
            return mv;
        }
        MethodVisitor testMethodVistor = new DesMethodVistor(mv, filedMap);
        return testMethodVistor;
    }

}