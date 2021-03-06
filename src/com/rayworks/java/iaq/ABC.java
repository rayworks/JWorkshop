package com.rayworks.java.iaq;

/**
 * Created by Shirley on 6/26/16.
 *
 * Super init > child init
 * Static import > field init > ctor
 */

class A {
    String a1 = ABC.echo(" 1: a1");
    String a2 = ABC.echo(" 2: a2");
    public A() {ABC.echo(" 3: A()");}
}

class B extends A {
    String b1 = ABC.echo(" 4: b1");
    String b2;
    public B() {
        ABC.echo(" 5: B()");
        b1 = ABC.echo(" 6: b1 reset");
        a2 = ABC.echo(" 7: a2 reset");
    }
}

class C extends B {
    String c1;
    { c1 = ABC.echo(" 8: c1"); }
    String c2;
    String c3 = ABC.echo(" 9: c3");

    public C() {
        ABC.echo("10: C()");
        c2 = ABC.echo("11: c2");
        b2 = ABC.echo("12: b2");
    }
}

public class ABC {
    static String echo(String arg) {
        System.out.println(arg);
        return arg;
    }

    public static void main(String[] args) {
        new C();
    }


}
