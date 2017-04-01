package com.platform.dbtest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DbTest.class })
public class AllTests {
	//通过这种方式可以让多个测试用例一次运行
}
