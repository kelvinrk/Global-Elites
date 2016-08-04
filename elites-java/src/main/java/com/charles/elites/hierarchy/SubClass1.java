package com.charles.elites.hierarchy;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public class SubClass1 extends BaseClass {
    int var1;

    public SubClass1() {
        super();
        var1 = 100;
        System.out.println(this.getClass().getName() + " " + var1);
    }

    @Override
    public void speak() {

    }
}
