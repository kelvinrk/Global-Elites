package com.charles.elites.epic;

public class ClockAngle {
	public static void main(String[] args) {
		String time = "4:00";
		String[] splitTime = time.split(":");
		double angle = calculateAngle(Integer.parseInt(splitTime[0]),
				Integer.parseInt(splitTime[1]));
		System.out.println("Angle when time is " + time + " : " + angle);
	}
	public static double  calculateAngle(int hh,int mm)
		{
			double angle=Math.abs(mm*6-(hh*30+mm*0.5));
			if(angle >= 180)
				return 360-angle;
			return angle;
			
		}
}
