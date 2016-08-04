package com.charles.elites.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kelvin.R.K on 7/27/2016.
 */
public class Stack {
    List<Object> stack;
    int top;
    int mid;
    //constructor
    public Stack(){
        stack = new LinkedList<>();
        top = -1;
        mid = -1;
        }
    //public interface methods --- To be Implemented ---
    public void push(Object o){
        stack.add(o);
        top++;
        mid = (top + 1) / 2;
    }

//public interface methods --- To be Implemented --- 
    public Object pop() {
        if(stack.isEmpty())
            return null;
        Object o = stack.remove(top);
        top--;
        mid = (top + 1) / 2;     //(3+1)/2 = 2 (2+1)/2 = 2
        return o;
        }
    //public interface methods --- To be Implemented ---
    public Object getMiddle() {
        if(stack.isEmpty())
        return null;
        return stack.get(mid);
    }

    public static void main(String[] args) throws Exception{
        Stack s = new Stack();
        s.push(new Integer(1));
        System.out.println((Integer)s.getMiddle());
        s.push(new Integer(2));
        System.out.println((Integer)s.getMiddle());
        s.push(new Integer(3));
        System.out.println((Integer)s.getMiddle());
        s.push(new Integer(4));
        System.out.println((Integer)s.getMiddle());
        s.push(new Integer(5));
        System.out.println((Integer)s.getMiddle());
        s.pop();
        System.out.println((Integer)s.getMiddle());
        s.pop();
        System.out.println((Integer)s.getMiddle());
        s.pop();
        System.out.println((Integer)s.getMiddle());
        s.pop();
        System.out.println((Integer)s.getMiddle());
        s.pop();
        System.out.println((Integer)s.getMiddle());
    }
}