package Program2;

public class Cube extends ThreeDimensionalShape {

    private double edge;
    private Square base;

    public Cube(double edge) {
        this.edge = edge;
        this.base = new Square(edge);
    }
    @Override
    public double getVolume() {
        return this.base.getArea() * this.edge;
    }

    @Override
    public double getArea() {
        return this.base.getArea() * 6;
    }
}
