package strategy;

import java.util.ArrayList;
import java.util.Collection;

public class GetStrategy implements IListStrategy{

	@Override
	public String listToString(Collection<String> list) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> arrl = new ArrayList<>(list);
		for(int i=0; i<arrl.size(); i++) {
			sb.append(arrl.get(i));
			if( (i+1) % 3==0) {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}

}
