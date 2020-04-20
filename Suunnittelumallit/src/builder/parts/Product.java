package builder.parts;

import java.util.ArrayList;
import java.util.Iterator;

public class Product implements Iterable<Content>{
	ArrayList<Content> contents = new ArrayList<>();
	
	public void addContent(Content content) {
		contents.add(content);
	}

	@Override
	public Iterator<Content> iterator() {
		return contents.iterator();
	}
}
