package mvc;
import java.util.List;
import java.util.ArrayList;

/*
 * Edits:
 * 	Hiba 3/5/24: created file
 * 	
 * 	Christopher 3/8/24: implemented Publisher (finished)
 * */

public class Publisher {
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public void subscribe(Subscriber ob) {
		subscribers.add(ob);
	}
	
	public void unsubscribe(Subscriber ob) {
		subscribers.remove(ob);
	}
	
	public void notifySubs() {
		for (int i = 0; i < subscribers.size(); i++) {
			subscribers.get(i).update();
		}
	}
}
