/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package instrument;

import asm.vistor.DesClassVistor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: PerfMonXformer.java, v 0.1 2018-05-05 下午1:49 @lizhao $$
 */
public class PerfMonXformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] transformed = null;
        System.out.println("Transforming " + className);
        ClassReader reader = new ClassReader(classfileBuffer);
        //自动计算栈帧
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        //选择支持Java8的asm5
        ClassVisitor classVisitor = new DesClassVistor(Opcodes.ASM5,classWriter);
        reader.accept(classVisitor,ClassReader.SKIP_DEBUG);
        return classWriter.toByteArray();
    }
}
