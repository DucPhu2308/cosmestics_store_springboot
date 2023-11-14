package hcmute.springbootdemo.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
@Entity

@Table(name = "Cart")

@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(columnDefinition = "varchar(255)")
	private String name;
	
	@Column(columnDefinition = "bit")
	private int active;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany(mappedBy = "product")
	Set<Product> product_carts;

	public Cart(int id, String name, int active, List<Order> orders, User user, Set<Product> product_carts) {
		this.id = id;
		this.name = name;
		this.active = active;
		this.orders = orders;
		this.user = user;
		this.product_carts = product_carts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Product> getProduct_carts() {
		return product_carts;
	}

	public void setProduct_carts(Set<Product> product_carts) {
		this.product_carts = product_carts;
	}
	

}
