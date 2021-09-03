
public class Debugging {

	public static int findMaximum(int[] anArray) {
		int result = anArray[0];

		for (int i = 0; i < anArray.length; i++) {
			int value = anArray[i];
			if (value > result) {
				result = value;
			}
		}
		return result;
	}

}
