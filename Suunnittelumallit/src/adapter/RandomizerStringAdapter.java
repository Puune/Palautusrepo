package adapter;

public class RandomizerStringAdapter extends CharRandomizer implements Randomizer {

	public String randomize(String string) {
		
		char[] chars = new char[string.length()];
		for(int i=0; i<string.length(); i++) {
			chars[i] = string.charAt(i);
		}
		
		chars = super.randomize(chars);
		
		String result = "";
		for(char c : chars) {
			result += c;
		}
		
		return result;
	}
}
