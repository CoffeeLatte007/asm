/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.vistor;


import asm.DesFiled;
import asm.FiledInfo;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: TestFieldVisitor.java, v 0.1 2018-05-06 下午10:10 @lizhao $$
 */
public class DesFieldVisitor extends FieldVisitor {

    private static final String desFieldAnnotationType = "L"+ DesFiled.class.getName().replaceAll("\\.","/")+";";
    private FiledInfo info;
    public DesFieldVisitor(int i) {
        super(i);
    }

    public DesFieldVisitor(int i, FieldVisitor fieldVisitor) {
        super(i, fieldVisitor);
    }

    public DesFieldVisitor(FiledInfo filedInfo, org.objectweb.asm.FieldVisitor fv) {
        super(Opcodes.ASM5, fv);
        info = filedInfo;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {
        AnnotationVisitor av = super.visitAnnotation(s, b);
        if (!desFieldAnnotationType.equals(s)){
            return av;
        }
        info.setDes(true);
        AnnotationVisitor avAdapter = new DesTypeAnnotationAdapter(Opcodes.ASM5, av, this.info);
        return avAdapter;
    }
}