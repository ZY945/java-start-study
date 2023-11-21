package JavaAgent;

import java.lang.instrument.Instrumentation;

/**
 * @author 伍六七
 * @date 2023/8/28 16:28
 */
public class Demo {

    public static void premain(String args, Instrumentation inst){
        System.out.println("=== premain  ===");
    }

    public static void main(String[] args) {
        System.out.println("=== main  ===");
    }

    public static void agentmain(String args, Instrumentation inst){
        System.out.println("=== agentmain  ===");
    }
}
