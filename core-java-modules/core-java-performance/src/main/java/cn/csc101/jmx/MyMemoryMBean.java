package cn.csc101.jmx;

public interface MyMemoryMBean {
    long getTotal();

    void setTotal(long total);

    long getUsed();

    void setUsed(long used);

    String getMemoryInfo();
}
