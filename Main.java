import java.util.Scanner;

class ATM {

    private float balance;

    ATM() {
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    public void depositAmount(float deposited) {
        Waiter.waitFor(1000);
        System.out.println("Amount Deposited Successfully!!!");
        this.balance += deposited;
    }

    public void withdrawAmount(float withdrawn) {
        if (withdrawn > balance) {
            System.out.println("Not enough balance!!!");
        } else {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println();
            }
            System.out.println("Amount Withdrawn Successfully");
            this.balance -= withdrawn;
        }
    }
}

class Waiter {
    public static void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            System.out.println();
        }
    }
}

class InputValidator {

    public static boolean isValidAmount(float amount) {
        return amount > 0;
    }
}

class MenuDisplay {
    private Scanner read;
    private ATM a = new ATM();;
    private Waiter waitFor = new Waiter();

    public MenuDisplay() {
        read = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.println("-------------------");
    }

    public void displayMenu() {
        System.out.println("Enter your choice:");
        System.out.println("1) View Balance \n2) Deposit Amount \n3) Withdraw Amount \n4) Exit");
        choiceMade();
    }

    public void runner() {
        Waiter.waitFor(1000);
        System.out.println("Do you wish to continue?");
        System.out.println("Press (y) to continue or (n) to exit");

        char ch = read.next().charAt(0);

        switch (ch) {
            case 'y':
                displayMenu();
                break;
            case 'n':
                System.out.println("Exiting...");
                Waiter.waitFor(1000);
                break;
            default:
                System.out.println("Invalid choice made");
                runner();
        }
    }

    public void choiceMade() {

        int choice = read.nextInt();
        boolean choiceValid = true;

        while (choiceValid) {

            if (choice == 1) {
                System.out.println("Displaying Balance....");
                Waiter.waitFor(1000);
                System.out.println("Your Current Balance is: Rs." + a.getBalance());
                runner();
                break;
            }

            else if (choice == 2) {
                System.out.println("Enter the amount to be deposited: ");
                float depositAmount = read.nextFloat();

                if (InputValidator.isValidAmount(depositAmount)) {
                    a.withdrawAmount(depositAmount);
                } else {
                    System.out.println("Please enter a valid amount...");
                }

                runner();
                break;
            }

            else if (choice == 3) {
                System.out.println("Enter the amount to be withdrawn");
                float withdrawAmount = read.nextFloat();
                if (InputValidator.isValidAmount(withdrawAmount)) {
                    a.depositAmount(withdrawAmount);
                } else {
                    System.out.println("Please enter a valid amount...");
                }

                runner();
                break;
            }

            else if (choice == 4) {
                System.out.println("Exiting....");
                Waiter.waitFor(1000);
                choiceValid = false;
                break;
            }

            else {
                System.out.println("Invalid Choice entered");
                Waiter.waitFor(1000);
                choiceValid = false;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MenuDisplay obj = new MenuDisplay();
        obj.displayMenu();
    }
}
