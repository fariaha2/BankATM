public class TransactionHistory {
    private String history;
    public TransactionHistory() {}
    public void addToHistory(String history) {
        this.history = this.history + history;
    }
    public String printHistory() {
        return "history";
    }
}
