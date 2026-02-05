package com.anthropos.demo;

import com.google.inject.Inject;

public class TestA {
    private TestB testB;

    @Inject
    public TestA(TestB testB){
        this.testB = testB;
    }

    public void test(){
        testB.Gauz();
    }
}
