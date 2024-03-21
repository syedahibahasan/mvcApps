package Life;
import CALab.*;
import java.util.Set;
import java.util.HashSet;

/*
 * Christopher Vu 3/18/24: Started Society.java, added static initialization of rebirth and death (from lecture notes)
 * 
 */

public class Society extends Grid {
	public static int percentAlive = 50;
	public static Set<Integer> rebirth = new HashSet<Integer>();
	public static Set<Integer> death = new HashSet<Integer>();
	
	public Cell makeCell(boolean uniform) {
		return new Agent(this);
	}
	
	// initially assigning the ambiences to rebirth or death
	static {
	     death.add(0);
	     death.add(1);
	     // no change of state for ambience 2
	     rebirth.add(3);
	     death.add(4);
	     death.add(5);
	     death.add(6);
	     death.add(7);
	     death.add(8);
	}
}
