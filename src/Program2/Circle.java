package Program2;

public class Circle extends TwoDimensionalShape {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     *
     * @return area of circle
     */
    @Override
    public double getArea() {
        return super.PI * this.radius * this.radius;
    } //end getArea

    /**
     *
     * @return toString representation
     */
    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%n%s%,.2f square units%n",
                this.getClass().getName(), super.toString(), "Area: ", this.getArea());
    } // end toString

}
