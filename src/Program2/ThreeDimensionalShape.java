package Program2;

public abstract class ThreeDimensionalShape extends Shape {

    /**
     *
     * @return volume of 3-d object
     */
    public abstract double getVolume();

    /**
     *
     * @return toString representation of 3-d object
     */
    @Override
    public String toString() {
        return String.format("%s", "Three-Dimensional");
    }// end toString

}
