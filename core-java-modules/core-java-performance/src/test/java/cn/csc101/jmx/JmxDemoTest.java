package cn.csc101.jmx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JmxDemoTest {

    JmxDemo jmxDemo;

    @BeforeEach
    void setUp() {
        jmxDemo = new JmxDemo();
    }

    @Test
    void testOSMxBean() {
        jmxDemo.testOSMxBean();
    }

    @Test
    void testCompilationMxBean() {
        jmxDemo.testCompilationMxBean();
    }

    @Test
    void testMemMxBean() {
        jmxDemo.testMemMxBean();
    }

    @Test
    void testGarbageMxBean() {
        jmxDemo.testGarbageMxBean();
    }
}