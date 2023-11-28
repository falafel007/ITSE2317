import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.ceil;
import static java.lang.Math.round;


public class Main {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();

        System.out.printf("This computer has %d processors.", coreCount);
    }
}
