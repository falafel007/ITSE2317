import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample1 
{
	public static void main(String[] args)
	{
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		System.out.println("\nUsing forEach");
		values.forEach(i -> doubleIt(i));
		
		System.out.println("\nUsing Method Reference");
	    values.forEach(MethodReferenceExample1::doubleIt);
	}
	
	public static void doubleIt(int i)
	{
		System.out.println(i * 2);
	}
}
