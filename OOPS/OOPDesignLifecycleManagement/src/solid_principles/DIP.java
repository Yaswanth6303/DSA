package solid_principles;

interface PaymentProcessor {
    void paymentProcess();
}

class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void paymentProcess() {
        System.out.println("Processing Credit Card Payment");
    }
}

class UPIPaymentProcessor implements PaymentProcessor {

    @Override
    public void paymentProcess() {
        System.out.println("Processing UPI Payment");
    }
}

class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment() {
        paymentProcessor.paymentProcess();
    }
}

public class DIP {
    static void main() {
        PaymentProcessor creditCard = new CreditCardProcessor();
        PaymentService paymentService = new PaymentService(creditCard);

        paymentService.processPayment();
    }
}
