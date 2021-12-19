/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RETO2_CICLO4.servicio;

import RETO2_CICLO4.modelo.Footwear;
import RETO2_CICLO4.repositorio.FootwearRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nelly borda
 */
@Service
public class FootwearService {
    
    @Autowired
    private FootwearRepositorio footwearsRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Footwear> getAll() {
        return footwearsRepository.getAll();
    }

   public Optional<Footwear> getFootwears(String reference) {
        return footwearsRepository.getFootwears(reference);
    }

    public Footwear create(Footwear Footwears) {
        if (Footwears.getReference() == null) {
            return Footwears;
        } else {
            return footwearsRepository.create(Footwears);
        }
    }

    public Footwear update(Footwear Footwears) {

        if (Footwears.getReference() != null) {
            Optional<Footwear> FootwearsDb = footwearsRepository.getFootwears(Footwears.getReference());
            if (!FootwearsDb.isEmpty()) {
                
                if (Footwears.getBrand()!= null) {
                    FootwearsDb.get().setBrand(Footwears.getBrand());
                }
                
                if (Footwears.getCategory() != null) {
                    FootwearsDb.get().setCategory(Footwears.getCategory());
                }

                if (Footwears.getMaterial() != null) {
                    FootwearsDb.get().setMaterial(Footwears.getMaterial());
                }

                if (Footwears.getGender() != null) {
                    FootwearsDb.get().setGender(Footwears.getGender());
                }

                if (Footwears.getSize() != null) {
                    FootwearsDb.get().setSize(Footwears.getSize());
                }
                
                if (Footwears.getDescription() != null) {
                    FootwearsDb.get().setDescription(Footwears.getDescription());
                }
                if (Footwears.getPrice() != 0.0) {
                    FootwearsDb.get().setPrice(Footwears.getPrice());
                }
                if (Footwears.getQuantity() != 0) {
                    FootwearsDb.get().setQuantity(Footwears.getQuantity());
                }
                if (Footwears.getPhotography() != null) {
                    FootwearsDb.get().setPhotography(Footwears.getPhotography());
                }
                
                FootwearsDb.get().setAvailability(Footwears.isAvailability());
                footwearsRepository.update(FootwearsDb.get());
                return FootwearsDb.get();
            } else {
                return Footwears;
            }
        } else {
            return Footwears;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFootwears(reference).map(Footwears -> {
            footwearsRepository.delete(Footwears);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<Footwear> productByPrice(double price) {
        return footwearsRepository.productByPrice(price);
    }

    //Reto 5
    public List<Footwear> findByDescriptionLike(String description) {
        return footwearsRepository.findByDescriptionLike(description);
    }
    
}
