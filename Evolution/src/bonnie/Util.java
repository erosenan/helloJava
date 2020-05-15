package bonnie;

import java.util.Random;

public class Util {
	public static float fit(float toFit, float limit) {
		if(toFit > limit)
			return limit;
		return toFit;
	}
	
	public static float bonnie(float a) {
		if(a > 1)
			return 1;
		if(a < 0)
			return 0;
		return a;
	}
	
	public static <T> void clearArray(T a[]) {
		for(int i = 0; i < a.length; i ++)
			a[i] = null;
	}
	
	public static float evolve(float toEvolve, float distance) {
		if(distance == 0)
			return toEvolve;
		Random r = new Random();
		float result = toEvolve + r.nextFloat() % (2 *distance) - distance;
		if(result  < 0)
			return 0;
		return result;
	}
	
	public static boolean chanceOf(float x) {
		Random r = new Random();
		float a = r.nextFloat() % 1;
		return a <= x;
		//return 0 == r.nextInt(x);
	}
}
