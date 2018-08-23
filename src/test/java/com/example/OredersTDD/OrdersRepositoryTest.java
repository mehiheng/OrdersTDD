package com.example.OredersTDD;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private TestEntityManager entityManager;

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}
