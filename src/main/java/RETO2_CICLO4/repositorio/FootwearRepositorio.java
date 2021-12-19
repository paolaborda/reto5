/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.repositorio;

import RETO2_CICLO4.interfaz.InterfaceFootwear;
import RETO2_CICLO4.modelo.Footwear;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nelly borda
 */
@Repository
public class FootwearRepositorio {
    @Autowired
    private InterfaceFootwear InterfaceOrder;
    
public List<Footwear> getAll() {
        return InterfaceOrder.findAll();
    }

    public Optional<Footwear> getFootwears(String reference) {
        return InterfaceOrder.findById(reference);
    }
    public Footwear create(Footwear Footwear) {
        return InterfaceOrder.save(Footwear);
    }

    public void update(Footwear Footwear) {
        InterfaceOrder.save(Footwear);
    }
    
    public void delete(Footwear Footwear) {
        InterfaceOrder.delete(Footwear);
    }
    //Reto 5
    public List<Footwear> productByPrice(double precio){
        return InterfaceOrder.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Footwear> findByDescriptionLike(String description){
        return InterfaceOrder.findByDescriptionLike(description);
    }
}
    
    
    

