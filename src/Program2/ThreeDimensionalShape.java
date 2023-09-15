package Program2;

public abstract class ThreeDimensionalShape extends Shape {

    public abstract double getVolume();

    @Override
    public String toString() {
        return String.format("%s", "Three-Dimensional");
    }// end toString

}
