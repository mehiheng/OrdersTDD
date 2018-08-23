package com.example.OredersTDD;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrdersServiceTest{

    @Mock
    OrdersRepository ordersRepository;


    @Test
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

    @Test
    void should_return_true_when_create_order_successfully_if_carId_not_exist() {

        //given
        OrdersService ordersService = new OrdersService(ordersRepository);
        Orders orders =new Orders("存车","无人处理","粤A123123");
        when(ordersRepository.findBycarId(any())).thenReturn(null);
        //when
        boolean result = ordersService.addOrders(orders);

        //then
        assertThat(result, is(true));
    }

    @Test
    void should_return_false_when_create_order_fail_if_carId_is_exist() {

        //given
        OrdersService ordersService = new OrdersService(ordersRepository);
        Orders orders =new Orders("存车","无人处理","粤A123123");
        Orders orders1 =new Orders("存车","无人处理","粤A123");
        when(ordersRepository.findBycarId(any())).thenReturn(orders1);
        //when
        boolean result = ordersService.addOrders(orders);

        //then
        assertThat(result, is(false));
    }

    @Test
    void should_update_status_from_STATUS_NO_to_STATUS_YES() {

        //given
        int userId = 1;
        OrdersService ordersService = new OrdersService(ordersRepository);
        Orders orders = new Orders("存车","无人处理","粤A123123");
        when(ordersRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(orders));

        //when
        Orders result = ordersService.setUsersToOrders(userId,orders.getId());
        //then

        verify(ordersRepository,times(2)).findById(anyInt());
        verify(ordersRepository).updateStatusById(anyInt(),anyString());
    }

}