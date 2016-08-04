package com.charles.elites.quest;

import java.util.concurrent.Callable;

interface IBird {
    Egg Lay();
}

class Chicken implements IBird{
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof IBird);
    }

    @Override
    public Egg Lay() {
        return new Egg(() -> new Chicken());
    }
}

class Egg {
    IBird bird;
    public Egg(Callable<IBird> createBird) {
        try {
            this.bird = createBird.call();
        } catch (Exception e) {
            bird = null;
        }
    }

    public IBird Hatch() throws Exception {
        if(bird == null) {
            throw new IllegalStateException();
        }
        try {
            return bird;
        } finally {
            bird = null;
        }
    }
}