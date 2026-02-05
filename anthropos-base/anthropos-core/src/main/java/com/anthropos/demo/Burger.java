package com.anthropos.demo;

public class Burger implements Food{
    @Override
    public void smell() {
        System.out.println( "Burger smells like cheese");
    }
}
