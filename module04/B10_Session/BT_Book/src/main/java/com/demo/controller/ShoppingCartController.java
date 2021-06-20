package com.demo.controller;

import com.demo.model.Book;
import com.demo.model.ShoppingCart;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class ShoppingCartController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/addToCart/{id}")
    public String addToCart(HttpSession session, @PathVariable("id") Long id){
        HashMap<Long, ShoppingCart> shoppingCarts = (HashMap<Long, ShoppingCart>) session.getAttribute("myShoppingCarts");
        if(shoppingCarts == null){
            shoppingCarts = new HashMap<>();
        }
        Book book = bookService.findById(id);
        if(book != null){
//            neu trong gio hang da co san pham
            if(shoppingCarts.containsKey(id)){
                ShoppingCart shoppingCart = shoppingCarts.get(id);
                shoppingCart.setBook(book);
                shoppingCart.setQuantityOrder(shoppingCart.getQuantityOrder() + 1);
                shoppingCarts.put(id, shoppingCart);
//                neu trong gio hang chua co san pham
            }else {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setBook(book);
                shoppingCart.setQuantityOrder(1);
                shoppingCarts.put(id, shoppingCart);
            }
        }
        session.setAttribute("myShoppingCarts", shoppingCarts);
        return "shoppingcart/list";
    }

    @GetMapping("/viewCart")
    public String viewCart(){
       return "shoppingcart/list";
    }

    @GetMapping("/updateCart/{id}")
    public String updateCart(HttpSession session, @PathVariable("id") Long id, @PathVariable("quantityOrder") int quantityOrder){
        HashMap<Long, ShoppingCart> shoppingCarts = (HashMap<Long, ShoppingCart>) session.getAttribute("myShoppingCarts");
        Book book = bookService.findById(id);
        if(shoppingCarts == null){
            shoppingCarts = new HashMap<>();
        }else {
            ShoppingCart shoppingCart = shoppingCarts.get(id);
            shoppingCart.setBook(book);
            shoppingCart.setQuantityOrder(quantityOrder);
            shoppingCarts.put(id, shoppingCart);
        }
        session.setAttribute("myShoppingCarts", shoppingCarts);
        return "shoppingcart/list";
    }

    @GetMapping("remove/{id}")
    public String removeCart(HttpSession session, @PathVariable("id") Long id){
        HashMap<Long, ShoppingCart> shoppingCarts = (HashMap<Long, ShoppingCart>) session.getAttribute("myShoppingCarts");
        if(shoppingCarts == null){
            shoppingCarts = new HashMap<>();
        }
        if (shoppingCarts.containsKey(id)){
            shoppingCarts.remove(id);
        }
        session.setAttribute("myShoppingCarts", shoppingCarts);
        return "shoppingcart/list";
    }
}
