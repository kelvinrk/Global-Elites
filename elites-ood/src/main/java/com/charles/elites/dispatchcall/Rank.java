package com.charles.elites.dispatchcall;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public enum Rank {
    Director(2),
    Manager(1),
    Responder(0);

    int level;

    Rank(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
