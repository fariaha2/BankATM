public class Customer {
    private String name;
    private int pin;
    public Customer(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }
    public void updatePin(int newPin) {
        pin = newPin;

    }
    public int getPin() {
        return pin;
    }
}
