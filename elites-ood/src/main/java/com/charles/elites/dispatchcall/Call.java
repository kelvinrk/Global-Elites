package com.charles.elites.dispatchcall;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public class Call {
    private Rank rank;

    private Caller caller;

    private Employee handler;

    public Call(Caller caller) {
        this.caller = caller;
        rank = Rank.Responder;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setHandler(Employee e) {
        handler = e;
    }

    public void reply(String msg) {

    }

    public Rank incrementRank() {
        //Do something
        return rank;
    }

    public void disconnect() {

    }
}
