package com.charles.elites.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Kelvin.R.K on 7/29/2016.
 */
public class SingletonTest {

    public static final String FILE = "SingletonTest.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(FILE));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(FILE));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

    }
}

