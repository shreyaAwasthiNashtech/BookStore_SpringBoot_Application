package com.techhub.springdatajpa_demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.model.CartItem;

@Service
public class CartService {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Book book, int quantity) {
        cartItems.add(new CartItem(book, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}