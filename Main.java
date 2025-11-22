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
        System.out.println("Amount Deposited Successfully!!!");
        this.balance += deposited;
    }

    public void withdrawAmount(float withdrawn) {
        if (withdrawn > balance) {
            System.out.println("Not enough balance!!!");
        } else {
            System.out.println("Amount Withdrawn Successfully");
            this.balance -= withdrawn;
        }
    }
}

class MenuDisplay {
    Scanner read;
    ATM a;

    public MenuDisplay() {
        read = new Scanner(System.in);
        a = new ATM();
        System.out.println("Welcome to the ATM");
        System.out.println("-------------------");
    }

    public void displayMenu() {
        System.out.println("Enter your choice:");
        System.out.println("1) View Balance \n2) Deposit Amount \n3) Withdraw Amount \n4) Exit");
        choiceMade();
    }

    public void runner() {
        System.out.println("Do you wish to continue?");
        System.out.println("Press (y) to continue or (n) to exit");

        char ch = read.next().charAt(0);

        switch (ch) {
            case 'y':
                displayMenu();
                break;
            case 'n':
                System.out.println("Exiting...");
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
                System.out.println("Your Current Balance is: Rs." + a.getBalance());
                runner();
                break;
            }

            else if (choice == 2) {
                System.out.println("Enter the amount to be deposited: ");
                float depositAmount = read.nextFloat();

                if (depositAmount > 0) {
                    a.depositAmount(depositAmount);
                } else {
                    System.out.println("Please enter a valid amount...");
                }
                runner();
                break;
            }

            else if (choice == 3) {
                System.out.println("Enter the amount to be withdrawn");
                float withdrawAmount = read.nextFloat();
                if (withdrawAmount > 0) {
                    a.withdrawAmount(withdrawAmount);
                } else {
                    System.out.println("Please enter a valid amount...");
                }
                runner();
                break;
            }

            else if (choice == 4) {
                System.out.println("Exiting....");
                choiceValid = false;
                break;
            }

            else {
                System.out.println("Invalid Choice entered");
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
