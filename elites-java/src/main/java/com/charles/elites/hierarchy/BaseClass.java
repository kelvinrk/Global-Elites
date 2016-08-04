package com.charles.elites.hierarchy;

/**
 * Created by Kelvin.R.K on 7/31/2016.
 */
public class BaseClass {
    int var1;

    public BaseClass() {
        var1 = -99;
        System.out.println(this.getClass().getName() + " " + var1);
    }

    public BaseClass(int var1) {
        this.var1 = var1;
        System.out.println(this.getClass().getName() + " " + var1);
    }

    protected void speak() {

    }
}
