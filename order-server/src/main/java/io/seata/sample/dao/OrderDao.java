package io.seata.sample.dao;

import io.seata.sample.entity.Order;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param productId
     */
    void update(@Param("userId") Long userId,@Param("productId") Long productId, @Param("status") Integer status);

    Order detail(Order order);
}
