/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.controlador;

import RETO2_CICLO4.modelo.Footwear;
import RETO2_CICLO4.servicio.FootwearService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nelly borda
 */
@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class FootwearController {
    
    @Autowired
    private FootwearService footwearsService;
       
     @GetMapping("/all")
    public List<Footwear> getAll() {
        return footwearsService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Footwear> getFootwears(@PathVariable("reference") String reference) {
        return footwearsService.getFootwears(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Footwear create(@RequestBody Footwear gadget) {
        return footwearsService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Footwear update(@RequestBody Footwear gadget) {
        return footwearsService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return footwearsService.delete(reference);
    } 
    
    @GetMapping("/price/{price}")
    public List<Footwear> productByPrice(@PathVariable("price") double precio) {
        return footwearsService.productByPrice(precio);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Footwear> findByDescriptionLike(@PathVariable("description") String description) {
        return footwearsService.findByDescriptionLike(description);
    }
    
    
}
