/**
 * www.lz.pw Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * <p></p>
 *
 * @author 563868273@qq.com
 * @version $Id: PerfMonAgent.java, v 0.1 2018-05-05 下午1:46 @lizhao $$
 */
public class PerfMonAgent {
    static private Instrumentation inst = null;
    public static void premain(String agentArgs, Instrumentation _inst) {
        System.out.println("PerfMonAgent.premain() was called.");
        // Initialize the static variables we use to track information.
        inst = _inst;
        // Set up the class-file transformer.
        ClassFileTransformer trans = new PerfMonXformer();
        System.out.println("Adding a PerfMonXformer instance to the JVM.");
        inst.addTransformer(trans);
    }
}