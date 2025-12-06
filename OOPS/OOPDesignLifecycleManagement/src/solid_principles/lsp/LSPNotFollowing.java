package solid_principles.lsp;

class Bird {
    public void fly() {
        System.out.println("I am flying");
    }
}

class Sparrow extends Bird {
    // Sparrow can fly
}

class Penguin extends Bird {
    // Penguin cannot fly, but it is a bird
    // So specifically I should override the behavior for penguin
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly.");
    }
}

public class LSPNotFollowing {
    static void main() {
        Bird sparrow = new Sparrow();
        sparrow.fly();

        Bird penguin = new Penguin();
        penguin.fly(); // Here substitution of base class works, but it is affecting the correctness of the
        // program
    }
}
