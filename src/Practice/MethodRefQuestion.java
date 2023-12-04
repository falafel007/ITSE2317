package Practice;

import java.util.Arrays;
import java.util.List;

public class MethodRefQuestion
{
    public static void main(String[] args)
    {
        MethodRefQuestion obj = new MethodRefQuestion();

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        values.forEach(obj::cubeIt);
    }

    public void cubeIt(int i)
    {
        System.out.println(i * i * i);
    }
}
