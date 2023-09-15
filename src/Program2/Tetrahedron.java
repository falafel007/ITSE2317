package Program2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getVolume() {
        return pow(this.edge, 3)/(6* sqrt(2));
    } //end getVolume

    @Override
    public double getArea() {
        return sqrt(3) * pow(this.edge, 2);
    } //end getArea

    @Override
    public String toString() {
        return String.format("Shape: %s%nDimension: %s%nSurface Area: %,.2f square units%nVolume: %,.2f cubic units%n",
                this.getClass().getName(), super.toString(), this.getArea(), this.getVolume());
    } //end toString

}
