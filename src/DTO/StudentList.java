/**
 *
 * @author HAITRAN
 */
package DTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class StudentList extends ArrayList<Student> {
    
    public void loadFromFile(String fName) {
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            FileReader rf = new FileReader(f);
            BufferedReader bf = new BufferedReader(rf);
            String details;
            while ((details = bf.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(details, ", ");  
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken(",").toUpperCase();
                Student fmp = new Student(ID, name);
                this.add(fmp);
            }
            bf.close();rf.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error!");
        }
    }
    
    public Student search (String ID) {
        if (this.isEmpty()) System.out.println("The student list is empty!");
        for (Student list : this) {
            if(list.getsID().compareToIgnoreCase(ID) == 0) return list;
        }
        return null;
    }
    public void outStu() {
        for (Student stu : this) {
            stu.output();
        }
    }
}
