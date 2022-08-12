/**
 *
 * @author HAITRAN
 */
package DTO;
public class StudentVac {
    int injnectionID;
    String sID,vID, place1, place2, day1, day2;
    String stuName, vacName;
    public StudentVac() {
        injnectionID = 0;
        sID = "";
        vID = "";
        place1 = "";
        place2 = "";
        day1 = null;
        day2 =null;
    }
    public StudentVac(String sID, String sName) {
         
    }
      
    public StudentVac(int injnectionID, String sID, String stuName, String vID, String vacName, String p1, String p2, String d1, String d2)  {
        this.injnectionID = injnectionID;
        this.sID = sID;
        this.stuName = stuName;
        this.vID = vID;
        this.vacName = vacName;
        this.place1 = p1;
        this.place2 = p2;
        this.day1 = d1;
        this.day2 = d2;
    }
    
    public StudentVac(Student st) {
        this.sID = st.getsID();
        StudentVac sv = new StudentVac(st.getsID(), st.getsName()); 
    } 

    public int getInjnectionID() {
        return injnectionID;
    }
    public void setInjnectionID(int injnectionID) {
        this.injnectionID = injnectionID;
    }  
    public String getsID() {
        return sID;
    }
    public void setsID(String sID) {
        this.sID = sID;
    }  
    public String getvID() {
        return vID;
    }
    public void setvID(String vID) {
        this.vID = vID;
    }   
    public String getPlace1() {
        return place1;
    }
    public void setPlace1(String place1) {
        this.place1 = place1;
    }
    public String getPlace2() {
        return place2;
    }
    public void setPlace2(String place2) {
        this.place2 = place2;
    }
    public String getDay1() {
        return day1;
    }
    public void setDay1(String day1) {
        this.day1 = day1;
    }
    public String getDay2() {
        return day2;
    }
    public void setDay2(String day2) {
        this.day2 = day2;
    }  
   
    public void output() {
        System.out.printf("|%-8s|%-10s|%-20s|%-12s|%-15s|%-12s|%-12s|%-12s|%-12s|\n", injnectionID,sID, stuName, vID, vacName, place1, place2, day1, day2);
    } 

    @Override
    public String toString() {
        return injnectionID + ", " + sID + ", " + vID + ", " + place1 + ", " + place2 + ", " + day1 + ", " + day2;
    }
    
    
}
