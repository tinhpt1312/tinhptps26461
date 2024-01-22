/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab8;

import java.io.Serializable;

/**
 *
 * @author Tinh
 */
public class ProductDAO extends DAO<Product> {

    @Override
    public void update(Product entity) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).name.equalsIgnoreCase(entity.name)){
                list.set(i, entity);
            }
        }
    }

    @Override
    public Product find(Serializable id) {
        for(Product p: list){
            if(p.name.equals(id)){
                return p;
            }
        }
        return null;
    }
    
}
