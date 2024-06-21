package Utils;

public class Utils {
	public static void delay(long Millis) {
		try {
			Thread.sleep(Millis);
		}
		catch (InterruptedException ex)
        {
            Thread.interrupted();
        }
	}
}
