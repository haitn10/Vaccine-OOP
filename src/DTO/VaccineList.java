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
public class VaccineList extends ArrayList<Vaccine> {
            
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
                Vaccine fmp = new Vaccine(ID, name);
                this.add(fmp);  
            }
            bf.close();rf.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error!");
        }
    }
    public Vaccine search (String vID) {
        if (this.isEmpty()) System.out.println("The student list is empty!");
        for (Vaccine vac : this) {
            if (vac.getvID().compareToIgnoreCase(vID) == 0) return vac;
        }
        return null;
    }
    public void outVac() {
        for (Vaccine vac : this) {
            vac.out_Vac();
        }
    }
}
