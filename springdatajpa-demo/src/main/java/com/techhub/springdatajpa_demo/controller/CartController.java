package com.techhub.springdatajpa_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techhub.springdatajpa_demo.model.Book;
import com.techhub.springdatajpa_demo.service.BookService;
import com.techhub.springdatajpa_demo.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final BookService bookService;

    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart"; // Thymeleaf template: cart.html
    }

    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId, @RequestParam int quantity) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            cartService.addToCart(book, quantity);
        }
        return "redirect:/cart";
    }
}
