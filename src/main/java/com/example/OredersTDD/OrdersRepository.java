package com.example.OredersTDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {


}
