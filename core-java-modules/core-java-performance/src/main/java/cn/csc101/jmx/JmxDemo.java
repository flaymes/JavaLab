package cn.csc101.jmx;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.stream.Collectors;

public class JmxDemo {
    public void testOSMxBean(){
        var osMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("osMXBean.getName() = " + osMXBean.getName());
        System.out.println("osMXBean.getArch() = " + osMXBean.getArch());
        System.out.println("osMXBean.getVersion() = " + osMXBean.getVersion());
        System.out.println("osMXBean.getAvailableProcessors() = " + osMXBean.getAvailableProcessors());
        System.out.println("osMXBean.getSystemLoadAverage() = " + osMXBean.getSystemLoadAverage());
    }

    public void testCompilationMxBean(){
        var compilationBean = ManagementFactory.getCompilationMXBean();
        System.out.println("compilationBean = " + compilationBean.getName());
        System.out.println("compilationBean.getTotalCompilationTime() = " + compilationBean.getTotalCompilationTime());
    }

    public void testMemMxBean(){
        var memBean = ManagementFactory.getMemoryMXBean();
        System.out.println("memBean = " + memBean.getHeapMemoryUsage());
        System.out.println("memBean.getNonHeapMemoryUsage() = " + memBean.getNonHeapMemoryUsage());
        System.out.println("memBean = " + memBean.getObjectPendingFinalizationCount());
    }
    public void testGarbageMxBean(){
        var gcBean = ManagementFactory.getGarbageCollectorMXBeans();
        String gcList = gcBean.stream().map(MemoryManagerMXBean::getName).collect(Collectors.joining(","));
        System.out.println("gcList = " + gcList);
    }
}
