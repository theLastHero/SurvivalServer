package Utils;

import java.util.Random;

public class Maths {
	
	public static int getRandom(int from, int to) {
	    if (from < to)
	        return from + new Random().nextInt(Math.abs(to - from));
	    return from - new Random().nextInt(Math.abs(to - from));
	}

}
