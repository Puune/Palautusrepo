package adapter;

import java.util.Arrays;

public class CharRandomizer implements Randomizer {

	@Override
	public char[] randomize(char[] chars) {
		char[] newArray = new char[chars.length];
		double[] values = new double[chars.length];
		
		for(int i=0; i<chars.length; i++) {
			values[i] = Math.random();
		}
		
		double[] sortedValues = Arrays.copyOf(values, values.length);
		Arrays.parallelSort(values);
		
		for(int i=0; i<values.length; i++) {
			for(int j=0; j<sortedValues.length; j++) {
				if(values[i]==sortedValues[j]) {
					newArray[j] = chars[i];
				}
			}
		}
		
		return newArray;
	}

}
