package Program2;

public class Sphere extends ThreeDimensionalShape {

    private double radius;
    private Circle base;

    public Sphere(double radius) {
        this.radius = radius;
        this.base = new Circle(radius);
    } // end constructor

    /**
     *
     * @return surface area of Sphere
     */
    @Override
    public double getArea() {
        return 4 * this.base.getArea();
    } // end getArea

    /**
     *
     * @return volume of Sphere
     */
    @Override
    public double getVolume() {
        return 4.0/3 * this.base.getArea() * this.radius;
    } // end getVolume

    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%nSurface Area: %,.2f square units%nVolume: %,.2f cubic units%n",
                this.getClass().getName(), super.toString(),  this.getArea(), this.getVolume());
    } //end toString

}
