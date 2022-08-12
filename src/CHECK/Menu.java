/**
 *
 * @author HAITRAN
 */
package CHECK;
import java.util.Scanner;
public class Menu {
    int choice = 0;
    boolean check;
    Scanner sc = new Scanner(System.in);
    public int _Menu() {      
        do {
            check = false;
            try {
                for (int i = 0; i < 55; i++) {
                System.out.print("=");
                }
                System.out.println();
                System.out.println("************Vaccination Management System**************");
                System.out.println("1. Show information all students have been injected");
                System.out.println("2. Add student's vaccine injection information");
                System.out.println("3. Updating information of student's vaccine injection");
                System.out.println("4. Delete student vaccine injection information");
                System.out.println("5. Search for injection information by studentID");
                System.out.println("6. Save data to file");
                System.out.println("7. Quit");
                for (int i = 0; i < 55; i++) {
                System.out.print("=");
                }
                System.out.println();
                sc = new Scanner(System.in);
                System.out.println("Select option:");
                choice = sc.nextInt();
                if (choice < 1 || choice > 7) System.out.println("The option is not available!");
            } catch (Exception e) {
                System.out.println("Enter again! Choose incorrectly.");
                check = true;
            }    
        } while (check);
        return choice;
    }
    public boolean inputNext() {
        String choose;
        System.out.println("Do you want to continue(Y/N)?");
        sc = new Scanner(System.in);
        choose = sc.nextLine();
        if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("YES")) return true;
        return false;
    }

}
