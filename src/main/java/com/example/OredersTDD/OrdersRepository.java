package com.example.OredersTDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {



    @Query(value = "select * from orders where car_id = ?1 and status<>'取车完成'", nativeQuery = true)
    Orders findBycarId(String carId);


}
