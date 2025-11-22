import java.util.Scanner;

class ATM{
    
    private float savings;

    ATM(float savings){
        this.savings = savings;
    }

}

class MenuDisplay{
    Scanner read = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("Welcome to the ATM");
        System.out.println("-------------------");
        System.out.println("Enter your choice:");
        System.out.println("-------------------");
        System.out.println("1) View Balance \n2) Deposit Amount \n3) Withdraw Amount");
    }

    public int choiceMaker(){
        int choice = read.nextInt();
        return choice;
    }
}

public class Main{
    public static void main(String[] args){
        
        MenuDisplay obj = new MenuDisplay();
        
        int choice;
        boolean choiceValid = true;
        obj.displayMenu();

        while(choiceValid){
            
            choice = obj.choiceMaker();
            
            if(choice == 1){
                System.out.println("Displaying Balance....");
            }

            else if(choice == 2){
                System.out.println("Enter the amount to be deposited: ");
            }

            else if(choice == 3){
               System.out.println("Enter the amount to be withdrawn"); 
            }

            else{
                System.out.println("Invalid Choice entered");
                choiceValid = false;
            }
        }
    }  
}
