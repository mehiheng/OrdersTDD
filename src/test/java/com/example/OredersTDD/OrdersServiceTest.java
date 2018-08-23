package com.example.OredersTDD;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrdersServiceTest{

    @Mock
    OrdersRepository ordersRepository;


    @org.junit.jupiter.api.Test
    void should_return_all_orders() {

        //given
        OrdersService ordersService = new OrdersService(ordersRepository);
        Orders orders =new Orders("存车","无人处理","粤A123123");
        List<Orders> ordersList = Arrays.asList(orders);
        when(ordersRepository.findAll()).thenReturn(ordersList);
        //when
        List<Orders> ordersList1 = ordersService.getAllOrders();

        //then
        assertThat(ordersList1.size(), is(1));
        assertThat(ordersList1.get(0).getType(), is("存车"));
    }
}