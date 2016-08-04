package com.charles.elites.dispatchcall;

import java.util.List;

/**
 * Created by Kelvin.R.K on 8/1/2016.
 */
public class CallHandler {
    private static CallHandler instance;
    private final int LEVELS = 3;

    private final int NUM_REPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    private CallHandler() {}

    public static CallHandler getInstance() {
        if(instance == null) {
            synchronized(CallHandler.class) {
                if(instance == null)
                    instance = new CallHandler();
            }
        }
        return instance;
    }

    public Employee getHandlerForCall(Call call) {
        return new Respondent();
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);
        if(emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reply("Please wait");
            callQueues.get(call.getRank().getLevel()).add(call);
        }
    }


}
