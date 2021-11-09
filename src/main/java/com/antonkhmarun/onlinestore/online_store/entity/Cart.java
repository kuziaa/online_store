package com.antonkhmarun.onlinestore.online_store.entity;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
//    @JoinTable(name = "cart_product",
//            joinColumns = @JoinColumn(name = "cart_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "cart_id")
    private List<CartProduct> cartProducts;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

//    @Override
//    public String toString() {
//        return "Cart{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", cartProducts=" + cartProducts +
//                '}';
//    }
}
