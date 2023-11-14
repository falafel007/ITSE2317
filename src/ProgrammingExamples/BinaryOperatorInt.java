package ProgrammingExamples; //BinaryOperator.java
@FunctionalInterface
public interface BinaryOperatorInt<T> extends BiFunction<T,T,T>
{
	
}


//BiFunction.java
@FunctionalInterface
interface BiFunction<T, U, R>
{
      R apply(T t, U u);
}
