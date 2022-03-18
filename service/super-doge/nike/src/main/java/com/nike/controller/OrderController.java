package com.nike.controller;

import com.nike.mapper.OrderMapper;
import com.nike.models.Order;
import com.nike.models.OrderRequest;
import com.nike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "*")
    @GetMapping("/order/{memberId}")
    @ResponseBody
    public List<Order> getOrderByMemberId(@PathVariable Integer memberId) {
        List<Order> orders = orderMapper.getOrders(memberId);
        return orders;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/orders")
    @ResponseBody
    public String getOrderByMemberId() {
        String number = orderMapper.getOrderCounts();
        return number;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/order")
    @ResponseBody
    public void insertNewOrder(@RequestBody OrderRequest request) {

        Order newOrder = new Order();
        newOrder.setOrderId(request.getOrderId());
        newOrder.setMemberId(request.getMemberId());
        newOrder.setProductName(request.getProductName());
        newOrder.setCostPoints(request.getCostPoints());
        orderService.setDelivery(newOrder);
        orderService.updatePoints(request);

        orderMapper.insertNewOrder(newOrder);

    }
}
