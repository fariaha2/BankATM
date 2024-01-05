public class Account {
    private double balance;
    public Account() {
        balance=0;
    }
    public void addMoney(double money) {
        balance+=money;
    }
    public void removeMoney(int money) {
        balance-=money;
    }
    public double getBalance() {
        return balance;
    }
}
