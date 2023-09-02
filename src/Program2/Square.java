package Program2;

public class Square extends TwoDimensionalShape {

    private double length;

    public Square(double length) {
        this.length = length;
    } //end constructor

    @Override
    public double getArea() {return this.length *this.length;} // end getArea

}
