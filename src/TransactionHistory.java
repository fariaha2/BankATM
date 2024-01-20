public class TransactionHistory {
    private String[] history;
    private Boolean[] successFail;
    public TransactionHistory() {
        history = new String[0];
        successFail = new Boolean[0];
    }
    // creates new array each time an action occurs, sets this array to the history array
    // one array is for whether action was successful or not, same process as the history array occurs
    public void addToHistory(String h, Boolean successFail) {
        String[] temp = new String[history.length+1];
        Boolean[] temp2 = new Boolean[this.successFail.length+1];
        for(int i=0; i<history.length; i++) {
            temp[i] = history[i];
            temp2[i] = this.successFail[i];
        }
        temp[temp.length-1] = h;
        temp2[temp2.length-1] = successFail;
        history = temp;
        this.successFail = temp2;
    }
    // compiles both the history array and the successFail array into one string, returns it
    public String printHistory() {
        String history = "";
        for(int i=0; i<this.history.length; i++) {
            history = history + this.history[i] + ": " + successFail[i] + "\n";
        }
        return history;
    }
}
