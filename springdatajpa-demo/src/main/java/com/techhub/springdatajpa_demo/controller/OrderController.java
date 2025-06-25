package com.techhub.springdatajpa_demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.model.CartItem;
import com.techhub.springdatajpa_demo.model.Order;
import com.techhub.springdatajpa_demo.service.CartService;
import com.techhub.springdatajpa_demo.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;

    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/place")
    public String placeOrder() {
        List<Book> booksToOrder = cartService.getCartItems().stream()
                .map(CartItem::getBook)
                .collect(Collectors.toList());

        if (!booksToOrder.isEmpty()) {
            orderService.placeOrder(booksToOrder);
            cartService.clearCart();
        }

        return "redirect:/orders/history";
    }

    @GetMapping("/history")
    public String orderHistory(Model model) {
        List<Order> allOrders = orderService.getAllOrders();
        model.addAttribute("orders", allOrders);
        return "orders"; 
    }
}
