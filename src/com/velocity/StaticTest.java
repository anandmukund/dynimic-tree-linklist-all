package com.velocity;

public class StaticTest extends parent {
    static {
        System.out.println("inside satic block");
    }

    StaticTest() {
        System.out.println("inside constructor of child");
    }

    {
        System.out.println("inside initialization block");
    }

    public static void main(String[] args) {
        new StaticTest();
        new StaticTest();
        System.out.println("inside main");
    }
}

class parent {
    static {
        System.out.println("inside parent Static block");
    }
    {
        System.out.println("inside parent initialisation block");
    }

    parent() {
        System.out.println("inside parent constructor");
    }
}