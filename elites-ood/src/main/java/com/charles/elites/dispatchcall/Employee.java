package com.charles.elites.dispatchcall;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public abstract class Employee {
    private Call currentCall = null;
    protected Rank rank;

    public Employee() {}

    public void receiveCall(Call call) {
        currentCall = call;
    }

    public void finishCall() {
        currentCall.disconnect();
    }

    public void escalateCall() {

    }

    public boolean assignNewCall() {
        return true;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}

class Director extends Employee {
    public Director() {
        rank = Rank.Director;
    }
}

class Manager extends Employee {
    public Manager() {
        rank = Rank.Manager;
    }
}

class Respondent extends Employee {
    public Respondent() {
        rank = Rank.Responder;
    }
}
