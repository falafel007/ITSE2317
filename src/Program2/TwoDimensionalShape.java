package Program2;

public abstract class TwoDimensionalShape extends Shape {

    @Override
    public String toString() {
        return String.format("Class: %s%nType: %s%nArea: %,.2f square units%n",
                this.getClass().getName(), "Two Dimensional Shape", this.getArea());
    }// end toString

}
