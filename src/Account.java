public class Account {
    private double balance;
    private Customer owner;
    public Account(Customer customer) {
        balance=0;
        owner = customer;
    }
    public void addMoney(double money) {
        balance+=money;
    }
    public void removeMoney(double money) {
        balance-=money;
    }
    public double getBalance() {
        return balance;
    }
}
