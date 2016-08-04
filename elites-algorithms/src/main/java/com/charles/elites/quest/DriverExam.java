package com.charles.elites.quest;

/**
 * Created by Kelvin.R.K on 6/26/2016.
 */
public class DriverExam {
    public static void executeExercise(IExercise exercise) {
        try{
            exercise.start();
        } catch(Exception ex) {
            exercise.markNegativePoints();
        } finally {
            exercise.end();
        }

        try {
            exercise.execute();
        } catch(Exception ex) {
            exercise.markNegativePoints();
        } finally {
            exercise.end();
        }
    }

    public static void main(String[] args) {
        DriverExam.executeExercise(new Exercise());
    }
}

class Exercise implements IExercise {
    public void start() { System.out.println("Start"); }
    public void execute() { System.out.println("Execute"); }
    public void markNegativePoints() { System.out.println("MarkNegativePoints"); }
    public void end() { System.out.println("End"); }
}

interface IExercise {
    void start() throws Exception;
    void execute();
    void markNegativePoints();
    void end();
}