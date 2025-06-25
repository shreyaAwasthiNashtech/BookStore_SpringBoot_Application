package com.techhub.springdatajpa_demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.model.Order;
import com.techhub.springdatajpa_demo.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order placeOrder(List<Book> books) {
        Order order = new Order();
        order.setBooks(books);
        order.setOrderedAt(LocalDateTime.now());
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
