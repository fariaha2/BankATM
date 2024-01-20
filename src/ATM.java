import java.io.Console;
import java.util.Scanner;
public class ATM {
    public ATM() {}
    public void start() {
        Scanner scan = new Scanner(System.in);
        String choice = "y";
        int option;
        System.out.println("Welcome to the ATM! \uD83C\uDFE7");
        System.out.println("What is your name?");
        String name = scan.nextLine();
        Customer customer = new Customer(name,(int) (Math.random()*50)+1);
        Account savingsAccount = new Account(customer);
        Account checkingAccount = new Account(customer);
        TransactionHistory history = new TransactionHistory();
        System.out.println("Hello, " + name + "! The pin to your account is " + customer.getPin() + ".");
        System.out.println("Enter your pin \uD83D\uDD22");
        int pin = scan.nextInt();
        while(pin!=customer.getPin()) {
            System.out.println("That pin is incorrect! Try again.");
            System.out.println("Enter your pin \uD83D\uDD22");
            pin = scan.nextInt();
        }
        while(choice.equals("y")) {
            System.out.println("What would you like to do? \uD83D\uDD20\n1. Withdraw money\n2. Deposit money\n3. Transfer money between accounts \n4. Get account balances\n5. Get transaction history\n6. Change PIN\n7. Exit");
            option = scan.nextInt();
            if(option==1) {
                System.out.println("From which account would you like to withdraw " + ConsoleUtility.GREEN + "money" + ConsoleUtility.RESET + "? (Enter S/C) \uD83D\uDCB3");
                scan.nextLine();
                String account = scan.nextLine().toLowerCase();
                System.out.println("How much " + ConsoleUtility.GREEN + "money" + ConsoleUtility.RESET + " would you like to withdraw? \uD83D\uDCB2");
                int amt = scan.nextInt();
                while(amt % 5 != 0) {
                    System.out.println("You must enter a number that ends in 5 or 0." + ConsoleUtility.WHITE + "Enter a new amount." + ConsoleUtility.RESET +  "\uD83D\uDD22");
                    amt = scan.nextInt();
                }
                int twenties = 0;
                int fives = 0;
                if(amt%20==0) {
                    if(amt%20==0) {
                        twenties = amt/20;
                    } else {
                        twenties = (amt-(amt%20))/20;
                    }
                    if(amt%5==0) {
                        fives = amt/5;
                    } else {
                        fives = (amt-(amt%5))/5;
                    }
                }
                if(account.equals("s")) {
                    if(amt>savingsAccount.getBalance()) {
                        System.out.println(ConsoleUtility.WHITE + "Insufficent funds!" + ConsoleUtility.RESET);
                        history.addToHistory("Withdraw money from savings account", false);
                    } else {
                        if(amt%20==0) {
                            System.out.println("Would you like to receive " + twenties + " twenties or" + fives + " fives or " + (twenties/2) + " twenties and " + (twenties-(twenties/2))*4 + " fives?");
                            System.out.println(ConsoleUtility.WHITE + "Enter T for only twenties, F for only fives, and B for both \uD83D\uDD20");
                            scan.nextLine();
                            String choice2 = scan.nextLine();
                            history.addToHistory("Withdraw money from savings account", true);
                        } else {
                            twenties = (amt-(amt%20))/20;
                            fives = (amt-(twenties*20))/5;
                            System.out.println("Here are your " + twenties + " twenties and your " + fives + " fives!");
                            history.addToHistory("Withdraw money from savings account", true);
                        }
                        System.out.println("Thank you for using this ATM machine! Here's your $" + amt + "! \uD83D\uDCB0");
                    }
                } else {
                    if (amt>checkingAccount.getBalance()) {
                        System.out.println(ConsoleUtility.WHITE + "Insufficent funds!");
                        history.addToHistory("Withdraw money from checkings account", false);
                    } else {
                        if(amt%20==0) {
                                System.out.println("Would you like to receive " + twenties + " twenties or " + fives + " fives or " + (twenties/2) + " twenties and " + (twenties-(twenties/2))*4 + " fives?");
                                System.out.println(ConsoleUtility.WHITE + "Enter T for only twenties, F for only fives, and B for both \uD83D\uDD20");
                                scan.nextLine();
                                String choice2 = scan.nextLine();
                                history.addToHistory("Withdraw money from savings account", true);
                        } else {
                            twenties = (amt-(amt%20))/20;
                            fives = (amt-(twenties*20))/5;
                            System.out.println("Here are your " + twenties + " twenties and your " + fives + " fives!");
                            history.addToHistory("Withdraw money from savings account", true);
                        }
                        System.out.println("Thank you for using this ATM machine! Here's your $" + amt + "! \uD83D\uDCB0");
                    }
                }

            } else if(option==2) {
                System.out.println("In which account would you like to deposit money? " + ConsoleUtility.WHITE + "Enter S for savings, and C for checkings \uD83D\uDCB3" + ConsoleUtility.RESET);
                scan.nextLine();
                String account = scan.nextLine().toLowerCase();
                System.out.println("How much " + ConsoleUtility.GREEN + "money" + ConsoleUtility.RESET + " would you like to deposit? \uD83D\uDCB2");
                double amt = scan.nextDouble();
                if(account.equals("s")) {
                    savingsAccount.addMoney(amt);
                    history.addToHistory("Money deposited into savings account", true);
                } else {
                    checkingAccount.addMoney(amt);
                    history.addToHistory("Money deposited into checkings account", true);
                }
                System.out.println("Deposit occurred!");
            } else if(option==3) {
                System.out.println("Savings to checkings " + ConsoleUtility.WHITE + "(option 1) " + ConsoleUtility.RESET + "or checkings to savings " + ConsoleUtility.WHITE + "(option 2)" + ConsoleUtility.RESET + "? (enter 1/2) \uD83D\uDCB3");
                int acc = scan.nextInt();
                System.out.println("How much" + ConsoleUtility.GREEN + " money" + ConsoleUtility.RESET + "? \uD83D\uDCB2");
                double amt = scan.nextDouble();
                if(acc==1) {
                    if(amt>savingsAccount.getBalance()) {
                        System.out.println("You do not have enough money in your account.");
                        history.addToHistory("Money transferred from savings account", false);
                    } else {
                        savingsAccount.removeMoney(amt);
                        checkingAccount.addMoney(amt);
                        history.addToHistory("Money transferred from savings account", true);
                        System.out.println("Done!");
                    }
                } else {
                    if(amt>checkingAccount.getBalance()) {
                        System.out.println("You do not have enough money in your account.");
                        history.addToHistory("Money transferred from checkings account", false);
                    } else {
                        checkingAccount.removeMoney(amt);
                        savingsAccount.addMoney(amt);
                        history.addToHistory("Money transferred from checkings account", true);
                        System.out.println("Done!");
                    }
                }
            } else if(option==4) {
                System.out.println("Your account balances:\nSavings account: " + savingsAccount.getBalance() + "\nChecking account: " + checkingAccount.getBalance());
                history.addToHistory("Checked account balances", true);
            } else if(option==5) {
                System.out.println(history.printHistory());
                history.addToHistory("Checked transaction history", true);
            } else if(option==6) {
                System.out.println("What do you want your new" + ConsoleUtility.WHITE + " pin " + ConsoleUtility.RESET +  "to be? \uD83D\uDD22");
                pin = scan.nextInt();
                customer.updatePin(pin);
                System.out.println( ConsoleUtility.WHITE + "PIN " + ConsoleUtility.RESET + "changed");
                history.addToHistory("Changed pin", true);
            } else if(option==7) {
                choice = "n";
            }
        }
        System.out.println("Have a nice day!");
    }
}
