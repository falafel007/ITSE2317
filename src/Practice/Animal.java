package Practice;

public class Animal {

    double mass;

    Animal(double mass) {
        this.mass = mass;
    }

    public static void main(String[] args) {
        Animal animal; // assigns animal variable for type animal (or any subclass thereof)
        // animal = new... instatiates animal variable as specifc object
    }
}

class Bird extends Animal {

    double wingspan;

}

class Frog extends Animal {

}
