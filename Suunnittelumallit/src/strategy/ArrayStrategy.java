package strategy;

import java.util.Collection;

public class ArrayStrategy implements IListStrategy{

	@Override
	public String listToString(Collection<String> list) {
		StringBuilder sb = new StringBuilder();
		Object[] arr = list.toArray();
			
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
			if( (i+1) % 2==0) {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}

}
