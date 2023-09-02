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
    }

    @Override
    public double getArea() {
        return sqrt(3) * pow(this.edge, 2);
    }

}
