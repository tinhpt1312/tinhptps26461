/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package buoi2;

/**
 *
 * @author Tinh
 */
public interface DBAction {
    public void insert();
    public void update();
    public void findByID(String ID);
    public void findALL();
    public void Delete();
}
