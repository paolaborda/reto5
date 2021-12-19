/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.interfaz;

import RETO2_CICLO4.modelo.Footwear;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author nelly borda
 */
public interface InterfaceFootwear extends MongoRepository<Footwear, String>{
    //Reto 5
    public List<Footwear> findByPriceLessThanEqual(double precio);
    
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Footwear> findByDescriptionLike(String description);
}
