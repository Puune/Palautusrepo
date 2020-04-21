package adapter;

public class Main {
	
	public static void main(String[] args) {
		
		//Legacy Randomizer
		CharRandomizer r = new CharRandomizer();
		char[] chars = {'a', 'b', 'c', 'd', 'e'};
		chars = r.randomize(chars);
		for(char c : chars) {
			System.out.println(c);
		}
		
		System.out.println("\n");
		
		//Sexy new String randomizer
		RandomizerStringAdapter rsa = new RandomizerStringAdapter();
		String asdf = "abcde";
		asdf = rsa.randomize(asdf);
				
		for(char c : asdf.toCharArray()) {
			System.out.println(c);
		}
	}
}
