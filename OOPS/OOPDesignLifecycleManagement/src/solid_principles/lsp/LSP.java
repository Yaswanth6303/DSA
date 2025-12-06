package solid_principles.lsp;

interface Flyable {
    void fly();
}

class Birds {
    public void eat() {
        System.out.println("I can eat food");
    }
}

class Pigeon extends Birds implements Flyable {
    @Override
    public void fly() {
        System.out.println("Pigeon can fly");
    }
}

class Ostrich extends Birds {
    // No fly() Method
}

public class LSP {
    static void main() {
        Birds pigeon = new Pigeon();
        ((Flyable) pigeon).fly();

        Birds ostrich = new Ostrich();
        ostrich.eat();
    }
}
