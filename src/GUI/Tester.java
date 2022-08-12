/**
 *
 * @author HAITRAN
 */
package GUI;
import CHECK.Menu;
import DTO.VaccineList;
import DTO.StudentList;
import DTO.StVacList;
public class Tester {
    public static void main(String[] args) {
        int choice;   
        String StudentFile = "student.txt";
        String VaccineFile = "vaccine.txt";
        String StuVacFile = "injections.txt";
        Menu menu = new Menu();
        StudentList dsStu = new StudentList();
        dsStu.loadFromFile(StudentFile);
        VaccineList dsVac = new VaccineList();
        dsVac.loadFromFile(VaccineFile);
        StVacList ds = new StVacList(dsStu,dsVac);
        ds.loadFromFile(StuVacFile);            
        do {                
            choice = menu._Menu();
            switch(choice) {
                case 1:ds.showStuVac(); break;
                case 2:ds.inputVaccination(); break;
                case 3:ds.updateVaccination(); break;
                case 4:ds.deleteVaccination(); break;
                case 5:ds.searchByID(); break;
                case 6:ds.writeToFile(StuVacFile); break;
                case 7:
                ds.writeToFile(StuVacFile);
                System.out.println("Covid-19 Vaccination Management System has closed!");
                break;
            }
        } while (choice <=6);                   
    }
}
