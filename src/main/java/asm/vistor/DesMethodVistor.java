/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package asm.vistor;

import asm.util.ASMUtil;
import asm.filter.DesFilterMap;
import asm.FiledInfo;
import asm.filter.BaseDesFilter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: TestMethodVistor.java, v 0.1 2018-05-06 上午12:41 @lizhao $$
 */
public class DesMethodVistor extends MethodVisitor implements Opcodes{
    Map<String, FiledInfo> filedMap;
    public DesMethodVistor(int i) {
        super(i);
    }

    public DesMethodVistor(int i, MethodVisitor methodVisitor) {
        super(i, methodVisitor);
    }

    public DesMethodVistor(MethodVisitor mv, Map<String, FiledInfo> filedMap) {
        super(ASM5, mv);
        this.filedMap = filedMap;
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        if (!(opcode == Opcodes.ALOAD && var == 0)){
            super.visitVarInsn(opcode, var);
        }
    }

    /**
     * 添加过滤逻辑
     * @param opcode
     * @param owner
     * @param name
     * @param desc
     */
    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        FiledInfo filedInfo = filedMap.get(name);
        if (filedInfo.isNotDes()){
            super.visitVarInsn(ALOAD, 0);
            super.visitFieldInsn(opcode, owner, name, desc);
            return;
        }
        mv.visitLdcInsn(filedInfo.getFilterClass().getName());
        mv.visitMethodInsn(INVOKESTATIC, ASMUtil.getASMOwnerByClass(DesFilterMap.class), "getByClassName", "(Ljava/lang/String;)Lasm/filter/BaseDesFilter;", false);
        super.visitVarInsn(ALOAD, 0);
        super.visitFieldInsn(opcode, owner, name, desc);
        mv.visitMethodInsn(INVOKEINTERFACE, ASMUtil.getASMOwnerByClass(BaseDesFilter.class), "desc", "(Ljava/lang/Object;)Ljava/lang/Object;", true);
        mv.visitMethodInsn(INVOKESTATIC, ASMUtil.getASMOwnerByClass(String.class), "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;", true);
    }
}