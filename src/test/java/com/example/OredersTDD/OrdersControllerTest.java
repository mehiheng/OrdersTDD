package com.example.OredersTDD;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
@EnableSpringDataWebSupport
public class OrdersControllerTest {


    @Autowired
    private OrdersController OrdersController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrdersService ordersService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_get_all_orders() throws Exception {


        //given
        Orders orders =new Orders("存车","无人处理","粤A123123");
        List<Orders> ordersList = Arrays.asList(orders);
        when(ordersService.getAllOrders()).thenReturn(ordersList);
        //when
        ResultActions result = mvc.perform(get("/orders"));
        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type", is("存车")))
                .andExpect(jsonPath("$[0].status", containsString("无人处理")))
                .andExpect(jsonPath("$[0].carId", is("粤A123123")));

    }
}