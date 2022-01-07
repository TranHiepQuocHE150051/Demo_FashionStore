package com.example.categories_crud.service;

import com.example.categories_crud.dto.ShippingDTO;
import com.example.categories_crud.model.ShippingUnits;
import com.example.categories_crud.model.categories;
import com.example.categories_crud.repository.CategoryRepository;
import com.example.categories_crud.repository.ShippingUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingUnitService {
    @Autowired
    private ShippingUnitRepository repo;
    public List<ShippingUnits> getAllShippingUnit() {
        return repo.findAll();
    }

    public List<ShippingUnits> addShipping(List<ShippingUnits> shippinglist, ShippingUnits shippingunit) {
        shippinglist.add(shippingunit);
        return shippinglist;
    }

    

    public ShippingUnits getShippingbyId(Integer id) {
        return repo.findById(id).get();
    }

    public void updateShipping(Integer id, ShippingUnits shippingUnits) {
        ShippingUnits shipping = repo.findById(id).get();
        System.out.println(shipping);
        shipping.setName(shippingUnits.getName());
        shipping.setAddress(shippingUnits.getAddress());
        shipping.setPhone(shippingUnits.getPhone());
        repo.save(shipping);
    }

    public void deleteShipping(Integer id) {
        repo.deleteById(id);
    }

    public ShippingUnits insert(ShippingUnits shippingUnits) {
        return repo.save(shippingUnits);
    }
    public List<ShippingDTO> getListShippingDTO(){
        return repo.getListShipping();
    }
}
