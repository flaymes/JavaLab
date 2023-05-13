package cn.csc101.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MyMemoryManagement {
    public static void main(String[] args) throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        MyMemory myMemory = new MyMemory();
        myMemory.setTotal(100L);
        myMemory.setUsed(20L);

        ObjectName objectName = new ObjectName("cn.csc101.jmx:type=myMemory");
        beanServer.registerMBean(myMemory,objectName);
        while (true){
            Thread.sleep(3000L);
            System.out.println("myMemory.getMemoryInfo() = " + myMemory.getMemoryInfo());
        }

    }
}
