public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
        System.out.println("Hello " + ConsoleUtility.CYAN + " i am cyan! " + ConsoleUtility.RED + " i am red " + ConsoleUtility.RESET + " the end");
    }
}