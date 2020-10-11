package com.yasinbee.apifirst.order.dao;

import com.yasinbee.apifirst.order.dao.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
