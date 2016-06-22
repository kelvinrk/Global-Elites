package com.charles.elites.epic;

public class EdgeDetection {
	public static void main(String[] args) {

	}
	public static int[] processEdges(int[] image, int width, int threshold){
	    //throw out invalid input
	    if(image == null){
	        return null;
	    }
	    if(width < 1){
	    	 return null;
	    }
	    if(image.length < width || image.length % width > 0){
	    	 return null;
	    }
	    //create output array and preprocess
	    final int[] output = new int[image.length];
	    final int numRows = image.length / width;
	    int xMin, xMax, yMin, yMax, maxDiff, index, pos;
	    //do the interior of the image
	    for(int row = 0; row < numRows; row++){
	        int rowCount = row * width;
	        for(int col = 0; col < width; col++){
	            index = rowCount+col;
	            pos = image[index];
	            xMin = (col == 0) ? 0 : col -1;
	            xMax = (col == width -1) ? col : col + 1;
	            yMin = (row == 0) ? 0 : row - width;
	            yMax = (row == numRows -1) ? row : row + 1;
	            if(meetsThreshold(xMin, xMax, yMin, yMax, width, image, pos, threshold)){
	                output[index] = pos;
	            }
	        }
	    }
	    return output;
	}
	private static boolean meetsThreshold(int xMin, int xMax, int yMin, int yMax, int width, int[] image, int value, int threshold){
	    int temp;
	    for(int row = yMin; row <= yMax; row+=width){
	        for(int col = xMin; col < xMax; col++){
	            temp = Math.abs(value - image[yMin + xMin]);
	            if(temp >= threshold){
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
