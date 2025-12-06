package solid_principles;

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class BasicPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("I am a Basic printer and I can Print");
    }
}

class AllInOnePrinter implements Printer, Scanner {

    @Override
    public void print() {
        System.out.println("I can print");
    }

    @Override
    public void scan() {
        System.out.println("I can scan");
    }
}

public class ISP {
    static void main() {
        Printer printer = new BasicPrinter();
        printer.print();

        AllInOnePrinter allInOnePrinter = new AllInOnePrinter();
        allInOnePrinter.print();
        allInOnePrinter.scan();
    }
}
