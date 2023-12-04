package Practice;

public class LargestDataInSubArrayTest {
    public static void main(String[] args) {
        LargestDataInSubArrayTest obj = new LargestDataInSubArrayTest();

        // create arrays of Integer, Double and Character
        Integer[] integerArray = {99, 2, 31, 4, 45, 7, 15, 24, 20};
        Double[] doubleArray = {21.1, 12.2, 3.3, 44.4, 15.5, 6.6, 17.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        Integer test1 = obj.largestDataInSubArray(integerArray, 0, 5);
        System.out.printf("Largest in integerArray is %s%n", test1);

        Double test2 = obj.largestDataInSubArray(doubleArray, 1, 5);
        System.out.printf("Largest in doubleArray is %s%n", test2);

        Character test3 = obj.largestDataInSubArray(characterArray, 1, 3);
        System.out.printf("Largest in characterArray is %s%n", test3);
    }

    public <T> T largestDataInSubArray(T[] inputArray, int lowSubscript, int highSubscript) {
        T max = inputArray[lowSubscript];

//        int index;
//        for (index = lowSubscript, lowSubscript <= highSubscript, index++) {
//            if (inputArray[index] > max) {
//                max = inputArray[index];
//            }
//        }
        return max;
    }


}