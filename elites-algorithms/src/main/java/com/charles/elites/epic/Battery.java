package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Battery {

	public static void main(String[] args) {
		int[] battery = new int[]{6, 9, 20};
		List<List<Integer>> res = combinationSum(battery, 11);
		if(res.size() == 0) {
			System.out.println("No combinations!");
			return;
		}
		for(List<Integer> each : res)
			System.out.println(each);
	}

	
	public static List<List<Integer>> combinationSum(int[] battery, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(battery == null || battery.length == 0)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(battery);
        helper(res, cur, battery, 0, target);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(target < candidates[i])
                return;
            cur.add(candidates[i]);
            helper(res, cur, candidates, i, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
