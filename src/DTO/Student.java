/**
 *
 * @author HAITRAN
 */
package DTO;
public class Student {
    private String sID,sName;
    
    //Constructor
    public Student() {
        sID = "";
        sName = "";
    }
    public Student(String sID, String sName) {
        this.sID = sID;
        this.sName = sName;
    }
    //Getters, Setters
    public String getsID() {
        return sID;
    }
    public void setsID(String sID) {
        this.sID = sID;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }  

    public void output() {
        System.out.println(sID +" "+ sName);
    }
    
}
