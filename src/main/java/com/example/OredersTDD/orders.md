1. 查询所有停车订单
    given orders
    when getAllOrders
    then return all created orders

2. 创建停车订单
    given orders
    when addParkOrders
    then return all created orders

3. 指派停车单
    given orderId，userId
    when setUsersToOrders
    then update the status of orders