/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

/**
 *
 * @author Tinh
 */
public class Staff {

    private String ID, fullName, counTry, genDer, staTus;

    public Staff() {
    }

    public Staff(String ID, String fullName, String counTry, String genDer, String staTus) {
        this.ID = ID;
        this.fullName = fullName;
        this.counTry = counTry;
        this.genDer = genDer;
        this.staTus = staTus;
    }

    public String getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCounTry() {
        return counTry;
    }

    public String getGenDer() {
        return genDer;
    }

    public String getStaTus() {
        return staTus;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCounTry(String counTry) {
        this.counTry = counTry;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    public void setStaTus(String staTus) {
        this.staTus = staTus;
    }
    
}
