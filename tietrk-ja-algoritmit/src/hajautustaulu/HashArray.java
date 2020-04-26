package hajautustaulu;

public class HashArray {
	private Item[] array;
	private int scale;
	private int values;
	
	public HashArray(int scale) {
		array = new Item[scale];
		this.scale = scale;
	}
	
	
	public void insert(int data) {
		if(values==scale) {
			System.out.println("Jono täynnä");
			return;
		}
		
		int index = data % scale;
		
		while(array[index]!=null) {
			index = ++index % scale;
		}
		array[index] = new Item(data);
		values++;
//			Item item = table[index];
//			while(item.getNext()!=null) {
//				item = item.getNext();
//			}
//			
//			item.setNext(new Item(data));
//		}
	}
	
	
	public Item get(int data) {
		int index = data % scale;
		
		while(array[index]!=null) {
			
			System.out.println("Tutkitaan index: " + index);
			
			if(array[index].getData() != data) {
				index = ++index % scale;
			} else {
				return array[index];
			}
		}
			
		System.out.println("No data");
		return null;
		
//		Item item = table[index];
//		while(item!=null) {
//					
//			if(item.getData()==data) {
//				return item;
//			} 
//			
//			if(item.getNext()==null) {
//				break;
//			} 
//			
//			System.out.println("Found " + item.getData() + ", next..");
//			item = item.getNext();
//		}
//		
//		System.out.println("No data");
//		return null;
	}
}
