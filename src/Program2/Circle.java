package Program2;

public class Circle extends TwoDimensionalShape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return super.PI * this.radius * this.radius;
    }

}
