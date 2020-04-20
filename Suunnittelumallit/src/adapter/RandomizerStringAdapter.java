package adapter;

public class RandomizerStringAdapter extends CharRandomizer implements Randomizer {

	public String randomize(String string) {
		
		char[] chars = new char[string.length()];
		for(int i=0; i<string.length(); i++) {
			chars[i] = string.charAt(i);
		}
		
		chars = super.randomize(chars);
		String res = chars.toString();
		return res;
	}
}
