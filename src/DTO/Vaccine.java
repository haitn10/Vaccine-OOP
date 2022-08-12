/**
 *
 * @author HAITRAN
 */
package DTO;
public class Vaccine {
    String vID, vName;
    
    //Constructor
    public Vaccine() {
        vID = "";
        vName = "";
    }
    public Vaccine(String vID, String vName) {
        this.vID = vID;
        this.vName = vName;
    }
    //Getters, Setters
    public String getvID() {
        return vID;
    }
    public void setvID(String vID) {
        this.vID = vID;
    }
    public String getvName() {
        return vName;
    }
    public void setvName(String vName) {
        this.vName = vName;
    }
    
    public void out_Vac() {
        System.out.println(vID + " " + vName);
    }
     
}
