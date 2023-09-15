package Program2;

public class Triangle extends TwoDimensionalShape {

    // dimensions as attributes
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    } // end constructor

    /**
     *
     * @return area of triangle
     */
    public double getArea(){
        return 0.5 * this.base * this.height;
    } // end getArea

    /**
     *
     * @return toString representation of triangle
     */
    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%n%s%,.2f square units%n",
                this.getClass().getName(), super.toString(),  "Area: ", this.getArea());
    } // end toString

}
