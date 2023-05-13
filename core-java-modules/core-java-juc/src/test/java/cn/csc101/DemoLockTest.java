package cn.csc101;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoLockTest {
    DemoLock demoLock;
    @BeforeEach
    void setUp() {
         demoLock = new DemoLock();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testLockDemo() {

        demoLock.sayLock();
    }
}