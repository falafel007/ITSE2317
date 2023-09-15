package Program2;

public class Triangle extends TwoDimensionalShape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    } // end constructor

    public double getArea(){
        return 0.5 * this.base * this.height;
    } // end getArea

    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%n%s%,.2f square units%n",
                this.getClass().getName(), super.toString(),  "Area: ", this.getArea());
    } // end toString

}
