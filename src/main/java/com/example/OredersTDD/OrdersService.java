package com.example.OredersTDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;

    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public boolean addOrders(Orders orders) {
        if (existCarid(orders.getCarId())) {
            return false;
        } else {
            ordersRepository.save(orders);
            return true;
        }
    }

    public boolean existCarid(String carId) {
        return ordersRepository.findBycarId(carId) != null && !ordersRepository.findBycarId(carId).getStatus().equals("无人管理");
    }

    public Orders setUsersToOrders(int useId, int ordersId) {
        Orders orders=ordersRepository.findById(ordersId).get();
        orders.setUserID(useId);
        orders.setStatus("存取中");
        ordersRepository.save(orders);
        Orders result = ordersRepository.findById(ordersId).get();
        return result;
    }



}
