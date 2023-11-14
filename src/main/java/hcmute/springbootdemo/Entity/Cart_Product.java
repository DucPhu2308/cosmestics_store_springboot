package hcmute.springbootdemo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.*;

@Entity

@Table(name = "Cart_Product")

@Embeddable
public class Cart_Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "int")
	private int quantity;
	
    @EmbeddedId
    Cart_Product id;

    @ManyToOne
    @JoinColumn(name = "cartId")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

	public Cart_Product(int quantity, Cart_Product id, Cart cart, Product product) {
		this.quantity = quantity;
		this.id = id;
		this.cart = cart;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart_Product getId() {
		return id;
	}

	public void setId(Cart_Product id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    
}
