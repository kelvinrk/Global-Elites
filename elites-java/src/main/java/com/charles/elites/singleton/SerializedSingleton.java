package com.charles.elites.singleton;

import java.io.Serializable;

/**
 * Created by Kelvin.R.K on 7/29/2016.
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    protected Object readResolve() {
        return getInstance();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
