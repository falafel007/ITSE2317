package Program2;

public class Triangle extends TwoDimensionalShape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double getArea(){
        return 0.5 * this.base * this.height;
    }
}
