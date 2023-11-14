// Discuss after Chapter 23

public class MethodReferenceThreadExample
{
	public static void main(String[] args)
	{
		Thread thread = new Thread(MethodReferenceThreadExample::printMessage);
		thread.start();
	}
	
	public static void printMessage()
	{
		System.out.println("Hello");
	}
}
