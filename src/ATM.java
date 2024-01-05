import java.util.Scanner;
public class ATM {
    public ATM() {
    }
    public void start() {
        Scanner scan = new Scanner(System.in);
        String choice = "y";
        int option;
        System.out.println("Welcome to the ATM!");
        System.out.println("What is your name?");
        String name = scan.nextLine();
        Customer customer = new Customer(name,(int) (Math.random()*50)+1);
        Account savingsAccount = new Account();
        Account checkingAccount = new Account();
        System.out.println("Hello, " + name + "! The pin to your account is " + customer.getPin() + ".");
        System.out.println("Enter your pin");
        int pin = scan.nextInt();
        while(pin!=customer.getPin()) {
            System.out.println("That pin is incorrect! Try again.");
            System.out.println("Enter your pin");
            pin = scan.nextInt();
        }
        while(choice.equals("y")) {
            System.out.println("What would you like to do?\n1. Withdraw money\n2. Deposit money\n3. Transfer money between accounts \n4. Get account balances\n 5. Get transaction history\n6. Change PIN\n7. Exit");
            option = scan.nextInt();
            if(option==1) {
                System.out.println("From which account would you like to withdraw money?");

                System.out.println("How much money would you like to withdraw?");

            } else if(option==2) {
                System.out.println("In which account would you like to deposit money? Enter S for savings, and C for checkings");
                String account = scan.nextLine();
                System.out.println("How much money would you like to deposit?");
                double amt = scan.nextDouble();
                if(account.equals("s")) {
                    savingsAccount.addMoney(amt);
                } else {
                    checkingAccount.addMoney(amt);
                }
            } else if(option==3) {
                System.out.println("Savings to checkings (option 1) or checkings to savings? (enter 1/2");
                int acc = scan.nextInt();
                if(acc==1) {

                } else if(acc==2) {

                }

            } else if(option==4) {
                System.out.println("Your account balances:\nSavings account: " + savingsAccount.getBalance() + "\nChecking account: " + checkingAccount.getBalance());
            } else if(option==5) {

            } else if(option==6) {
                System.out.println("What do you want your new pin to be?");
                int pin = scan.nextInt();
                customer.updatePin(pin);

            } else if(option==7) {
                choice = "n";
            }
            }
        System.out.println("Have a nice day!");
        }
    }
