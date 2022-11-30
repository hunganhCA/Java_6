package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class OrderService {
    @Autowired
    OrderRepository orRe;
    @Autowired
    OrderDetailRepository orDeRE;
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData, Order.class);
        orRe.save(order);
        TypeReference<List<OrderDetail>> type = new  TypeReference<List<OrderDetail>> () {};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
        		.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
        		
        orDeRE.saveAll(details);
        return order;
    }
	public Object findById(Long id) {
		
		return orRe.findById(id).get();
		
	}
	public Object findByUsername(String username) {
		return orRe.findByUsername(username);
	}

}
