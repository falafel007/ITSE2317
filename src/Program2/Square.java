package Program2;

public class Square extends TwoDimensionalShape {

    private double length;

    public Square(double length) {
        this.length = length;
    } //end constructor

    @Override
    public double getArea() {return this.length *this.length;} // end getArea

    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%n%s%,.2f square units%n",
                this.getClass().getName(), super.toString(),  "Area: ", this.getArea());
    } // end toString

}
