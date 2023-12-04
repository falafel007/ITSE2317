package Practice;

public class  Question2Class <F, S> {
    //Your class should include two private elements, a two-argument constructor to initialize these elements and get and set methods for them as well.

    private F one;
    private S two;

    Question2Class(F one, S two) {
        this.one = one;
        this.two = two;
    }

    public F getOne() {
        return this.one;
    }

    public S getTwo() {
        return this.two;
    }

    public void setOne(F one) {
        this.one = one;
    }

    public void setTwo(S two) {
        this.two = two;
    }
}
