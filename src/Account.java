public class Account {
    private double balance;
    public Account() {
        balance=0;
    }
    public void AddMoney(int money) {
        balance+=money;
    }
    public void RemoveMoney(int money) {
        balance-=money;
    }
    public double getBalance() {
        return balance;
    }
}
