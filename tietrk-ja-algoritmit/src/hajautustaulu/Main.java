package hajautustaulu;

public class Main {

	public static void main(String[] args) {
		
		HashArray ht;
		System.out.println("Anna taulun vertikaalinen koko (kluku)");
		ht = new HashArray(Lue.kluku());
		
		int select = 0;
		while(select!=9) {
			System.out.println("******************");
			System.out.println("1. lisää uusi");
			System.out.println("2. etsi");
			System.out.println("9. Lopeta");
			select = Lue.kluku();
			int data;
			
			switch(select) {
			case 1:
				System.out.println("Anna arvo. (kluku)");
				data = Lue.kluku();
				ht.insert(data);
				break;
				
			case 2:
				System.out.println("Anna hakuarvo. (kluku)");
				data = Lue.kluku();
				Item item = ht.get(data);
				if(item!=null) {
					System.out.println("Löytyi: " + item.getData());
				}
			}
			
		}
		
	}
	
}
