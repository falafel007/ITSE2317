package Program2;

public class Circle extends TwoDimensionalShape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return super.PI * this.radius * this.radius;
    } //end getArea

    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%n%s%,.2f square units%n",
                this.getClass().getName(), super.toString(), "Area: ", this.getArea());
    } // end toString

}
