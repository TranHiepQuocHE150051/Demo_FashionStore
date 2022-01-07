package com.example.categories_crud.repository;

import com.example.categories_crud.dto.ShippingDTO;
import com.example.categories_crud.model.ShippingUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingUnitRepository extends JpaRepository<ShippingUnits,Integer> {

    @Query(value = "select new com.example.categories_crud.dto.ShippingDTO(" +
            "s.id, s.name, count(o.id)" +
            ") from ShippingUnits s join Orders o on s.id = o.shipping_unit.id" +
            " where MONTH (o.created_at)=1 and YEAR(o.created_at)=2022 and o.status=2" +
            " group by s.id")
    public List<ShippingDTO> getListShipping();


}
