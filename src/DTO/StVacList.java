/**
 *
 * @author HAITRAN
 */
package DTO;
import CHECK.Menu;
import CHECK.CheckDate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
public class StVacList extends ArrayList<StudentVac> {
    VaccineList vacList = new VaccineList();
    StudentList stList = new StudentList(); 
    Menu mnu = new Menu();
    public StVacList(StudentList stList, VaccineList vacList) {
       this.stList = stList; 
       this.vacList = vacList;
    }
    
    public boolean loadFromFile(String fName) {
        try {
            File f = new File(fName);
            if(!f.exists()) return false;
            FileReader rf = new FileReader(f);
            BufferedReader bf = new BufferedReader(rf);
            String details;
            while ((details = bf.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(details, ", ");
                int injectID = Integer.parseInt(stk.nextToken());
                String sID = stk.nextToken().toUpperCase();
                if (stList.search(sID) != null ) {                    
                String vID = stk.nextToken().toUpperCase();
                String p1 = stk.nextToken(",").toUpperCase();
                String p2 = stk.nextToken(",").toUpperCase(); 
                String d1 = stk.nextToken().toUpperCase();
                String d2 = stk.nextToken().toUpperCase();
                String sName = stList.search(sID).getsName();
                String vName = vacList.search(vID).getvName();
                StudentVac stVac = new StudentVac(injectID, sID, sName, vID, vName, p1, p2, d1, d2);
                this.add(stVac);
                }              
            }
            bf.close();rf.close(); 
        } catch (IOException | NumberFormatException e) {
            System.out.println("The file is empty!");
        }    
        return true;
    }
    
    public boolean writeToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
            return false;
        }
        try {
            File f = new File(fName);
            FileWriter wf = new FileWriter(f);
            PrintWriter pw = new PrintWriter(wf);
            for (StudentVac stuVac : this) {
                pw.println(stuVac.toString());
            }
            pw.close();wf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return true;
    }
    
    public void showStuVac() {
        for (int i = 0; i < 123; i++) {
                System.out.print("-");
            }
            System.out.println();
        System.out.printf("|%-8s|%-10s|%-20s|%-12s|%-15s|%-12s|%-12s|%-12s|%-12s|\n", "ID", "STUDENT_ID",
                    "STUDENT_NAME", "VACCINE_ID", "VACCINE_NAME", "1ST_PLACE", "2ND_PLACE", "1ST_DATE", "2ND_DATE");
        if (this.isEmpty()) System.out.println("The list is empty!");
            for (StudentVac injection : this) {
                    injection.output();
            }
        for (int i = 0; i < 123; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public StudentVac search(String ID) {
        if (this.isEmpty()) System.out.println("The list injection is empty!");
        for (StudentVac stuVac : this) {
            if (stuVac.getsID().equalsIgnoreCase(ID)) return stuVac;
        }
        return null;
    }
     
    public void searchByID() {
        boolean check;
        do {
            for (int i = 0; i < 55; i++) System.out.print("=");
            System.out.println();
            Scanner sc = new Scanner(System.in);            
            System.out.println("Enter ID student: ");
            String ID = sc.nextLine();
            StudentVac stVac = search(ID);
            if (stVac != null) {
                for (int i = 0; i < 123; i++) System.out.print("-");
                System.out.println();
                System.out.printf("|%-8s|%-10s|%-20s|%-12s|%-15s|%-12s|%-12s|%-12s|%-12s|\n", "ID", "STUDENT_ID",
                        "STUDENT_NAME", "VACCINE_ID", "VACCINE_NAME", "1ST_PLACE", "2ND_PLACE", "1ST_DATE", "2ND_DATE");
                    stVac.output();
                for (int i = 0; i < 123; i++) System.out.print("-");
                System.out.println();
            }
            else System.out.println("Students have not been vaccinated!");
            check = mnu.inputNext();
        } while (check);
    }
      
    public void inputVaccination() {
        
        boolean check;
        int injectID;
        String sID, sName, vacID, vName, place, day;
        Scanner sc;
        for (int i = 0; i < 55; i++) System.out.print("=");
        System.out.println();
        do{
            sc = new Scanner(System.in);
            System.out.println("Enter student ID: ");
            sID = sc.nextLine().toUpperCase();
            try {
                if (search(sID) != null) throw new Exception("Fail! Students have been injected."); // kiểm tra sinh viên tiêm vaccine      
                if (stList.search(sID) == null) throw new Exception("Students are not in the original student list."); //kiểm tra sinh viên trong danh sách ban đầu
                try {     
                    vacList.outVac(); // in danh sách vaccine
                    System.out.println("Enter vaccine ID: ");
                    sc = new Scanner(System.in);
                    vacID = sc.nextLine().toUpperCase();
                    if (vacList.search(vacID) == null) throw new Exception("Vaccine does not existed!");
                    System.out.println("Enter place injected: ");
                    sc = new Scanner(System.in);
                    place = sc.nextLine().toUpperCase();
                    System.out.println("Enter date injected: ");
                    sc = new Scanner(System.in);
                    day = sc.nextLine();
                    Random random = new Random();
                    injectID = random.nextInt(100000); // cho mã injection ngẫu nhiên
                    if(CheckDate.toDate(day) != -1) { // check ngày tháng hợp lệ
                        sName = stList.search(sID).getsName();
                        vName = vacList.search(vacID).getvName();
                        StudentVac newInj = new StudentVac(injectID, sID, sName, vacID, vName, place, null, day, null);
                        if(this.add(newInj)) System.out.println("Successfully!"); 
                    } else throw new Exception("Fail! Day invalid.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                         
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        check = mnu.inputNext();
        } while (check);
        for (int i = 0; i < 55; i++) System.out.print("=");
        System.out.println();
    } // Kết thúc nhập data
    
    public void updateVaccination() {
        boolean check;
        String sID, vID, place, day;
        Scanner sc;
        for (int i = 0; i < 55; i++) System.out.print("=");
        System.out.println();
        do{
            sc = new Scanner(System.in);
            System.out.println("Enter student ID: ");
            sID = sc.nextLine().toUpperCase();
            try {
                // kiểm tra sinh viên tiêm vaccine
                if (search(sID) == null)
                    throw new Exception("Student does not existed!"); 
                else if (search(sID) != null && (search(sID).getPlace2() != null )) 
                    throw new Exception("Students have completed 2 injections.");      
                
                try {     
                    vacList.outVac(); // in danh sách vaccine
                    System.out.println("Enter vaccine ID: ");
                    sc = new Scanner(System.in);
                    vID = sc.nextLine().toUpperCase();
                    if (search(sID).getvID().compareToIgnoreCase(vID) != 0)
                        throw new Exception("Update fail! Two vaccines must be of the same type!");
                    System.out.println("Enter place injected: ");
                    sc = new Scanner(System.in);
                    place = sc.nextLine().toUpperCase();
                    System.out.println("Enter date injected: ");
                    sc = new Scanner(System.in);
                    day = sc.nextLine();
                    // check ngày tháng hợp lệ và khoảng cách giữa 2 ngày
                    if(CheckDate.toDate(day) != -1 && CheckDate.daysBetween(search(sID).day1, day) > 28) { 
                        search(sID).setPlace2(place);
                        search(sID).setDay2(day);
                        System.out.println("Update successful!");                     
                    } else throw new Exception("Update fail! Day invalid.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }      
        check = mnu.inputNext();
        } while (check);
        for (int i = 0; i < 55; i++) System.out.print("=");
        System.out.println();
    }
    
    public void deleteVaccination() {
        boolean check;
        do {
            for (int i = 0; i < 55; i++) System.out.print("=");
            System.out.println();
            Scanner sc = new Scanner(System.in);            
            System.out.println("Enter ID student: ");
            String ID = sc.nextLine();
            StudentVac stVac = search(ID);
            if (stVac != null) {
                for (int i = 0; i < 123; i++) System.out.print("-");
                System.out.println();
                System.out.printf("|%-8s|%-10s|%-20s|%-12s|%-15s|%-12s|%-12s|%-12s|%-12s|\n", "ID", "STUDENT_ID",
                        "STUDENT_NAME", "VACCINE_ID", "VACCINE_NAME", "1ST_PLACE", "2ND_PLACE", "1ST_DATE", "2ND_DATE");
                    stVac.output();
                for (int i = 0; i < 123; i++) System.out.print("-");
                System.out.println();
                System.out.println("Are you sure you want to delete this student's vaccination information(Y/N)?");
                String sure = sc.nextLine();
                if (sure.equalsIgnoreCase("Y") || sure.equalsIgnoreCase("YES")) {
                    this.remove(stVac);
                    System.out.println("Deleted!");
                } else 
                    System.out.println("Delete fail!");
            }
            else System.out.println("Students do not exist in the vaccination list!");
            check = mnu.inputNext();
        } while (check);
    }            
}
