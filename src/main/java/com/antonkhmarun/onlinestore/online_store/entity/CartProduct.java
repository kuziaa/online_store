package com.antonkhmarun.onlinestore.online_store.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
