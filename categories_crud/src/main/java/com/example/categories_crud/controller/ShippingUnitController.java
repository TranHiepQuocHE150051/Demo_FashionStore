package com.example.categories_crud.controller;

import com.example.categories_crud.dto.ShippingDTO;
import com.example.categories_crud.model.ShippingUnits;
import com.example.categories_crud.service.ShippingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ShippingUnitController {
    @Autowired
    private ShippingUnitService service;

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Welcome to java K2", HttpStatus.OK);
    }

    @GetMapping("/shipping_units")
    public ResponseEntity<List<ShippingUnits>> getAllShipingUnits() {
        List<ShippingUnits> shippinglist = service.getAllShippingUnit();
        return new ResponseEntity<>(shippinglist, HttpStatus.OK);
    }
    @PostMapping("/shipping_units")
    public ResponseEntity<ShippingUnits> addShippingUnit(@RequestBody ShippingUnits shippingUnits) {
        ShippingUnits todo1 = service.insert(shippingUnits);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @DeleteMapping({"/shipping_units/{id}"})
    public ResponseEntity<ShippingUnits> deleteTodo(@PathVariable("id") Integer id) {
        service.deleteShipping(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping({"/shipping_units/{id}"})
    public ResponseEntity<ShippingUnits> updateTodo(@PathVariable("id") Integer id, @RequestBody ShippingUnits shippingUnits) {
        service.updateShipping(id, shippingUnits);
        return new ResponseEntity<>(service.getShippingbyId(id), HttpStatus.OK);
    }
    @GetMapping("/getShippingList")
    public ResponseEntity<List<ShippingDTO>> getListStoreDTO() {
        List<ShippingDTO> shippinglist = service.getListShippingDTO();
        return new ResponseEntity<>(shippinglist, HttpStatus.OK);
    }

}
