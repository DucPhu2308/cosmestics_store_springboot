package hcmute.springbootdemo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.*;

@Entity

@Table(name = "Cart_Product")

@Embeddable
public class Cart_Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	Long id;
	
	@Column(columnDefinition = "int")
	private int quantity;

    @ManyToOne
    @JoinColumn(name = "cartId")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;
    
    

	public Cart_Product() {
	}

	public Cart_Product(Long id, int quantity, Cart cart, Product product) {

		this.id = id;
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
