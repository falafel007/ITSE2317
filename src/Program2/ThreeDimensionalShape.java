package Program2;

public abstract class ThreeDimensionalShape extends Shape {

    public abstract double getVolume();

    @Override
    public String toString() {
        return String.format("Class: %s%nType: %s%nSurface Area: %,.2f square units%nVolume: %,.2f cubic units%n",
            this.getClass().getName(), "Three Dimensional Shape", this.getArea(), this.getVolume());
    }// end toString

}
