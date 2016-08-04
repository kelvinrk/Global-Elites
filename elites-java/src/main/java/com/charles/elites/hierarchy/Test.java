package com.charles.elites.hierarchy;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public class Test {
    public static void main(String[] args) {
//        BaseClass baseClass = new BaseClass(12);

        SubClass1 subClass1 = new SubClass1();
        System.out.println(subClass1.var1);
        System.out.println(((BaseClass)subClass1).var1);


        BaseClass subClass2 = new SubClass1();
        System.out.println(subClass2.var1);

    }
}
