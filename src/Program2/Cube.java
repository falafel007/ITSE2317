package Program2;

public class Cube extends ThreeDimensionalShape {

    private double edge;
    private Square base;

    // Constructor
    public Cube(double edge) {
        this.edge = edge;
        this.base = new Square(edge);
    } // end constructor

    /**
     *
     * @return volume of cube
     */
    @Override
    public double getVolume() {
        return this.base.getArea() * this.edge;
    } //end getVolume

    /**
     *
     * @return surface area of cube
     */
    @Override
    public double getArea() {
        return this.base.getArea() * 6;
    } // end getArea

    /**
     *
     * @return toString representation
     */
    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%nSurface Area: %,.2f square units%nVolume: %,.2f cubic units%n",
                this.getClass().getName(), super.toString(), this.getArea(), this.getVolume());
    } //end toString

}
