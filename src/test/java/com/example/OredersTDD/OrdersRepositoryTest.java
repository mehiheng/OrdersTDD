package com.example.OredersTDD;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private TestEntityManager entityManager;

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }

    @Test
    public void should_get_all_orders() throws Exception{
        //given
        entityManager.persist(new Orders("存车","无人处理","粤A123123"));

        //when
        List<Orders> ordersList = ordersRepository.findAll();

        //then
        assertThat(ordersList.size(), is(1));
        assertThat(ordersList.get(0).getType(), is("存车"));
    }

    @Test
    public void should_return_null_when_carId_not_exist() throws Exception{
        //given
        entityManager.persist(new Orders("存车","无人处理","粤A123123"));

        //when
        Orders orders = ordersRepository.findBycarId("粤A123");

        //then
        assertThat(orders, is(nullValue()));
    }

    @Test
    public void should_return_orders_when_carId_is_exist() throws Exception{
        //given
        Orders orders = new Orders("存车","无人处理","粤A123123");
        entityManager.persist(orders);

        //when
        Orders orders1 = ordersRepository.findBycarId("粤A123123");

        //then
        assertThat(orders, is(orders1));
    }


}