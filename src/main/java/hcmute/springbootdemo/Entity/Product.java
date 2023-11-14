package hcmute.springbootdemo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity

@Table(name = "Product")

@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "int")
	private int stoke;
	
	@Column(columnDefinition = "decimal(10,2)")
	private int price;
	
	@Column
	private Boolean available;
	
	@Column(columnDefinition = "float")
	private float discountPercent;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(columnDefinition = "varchar(255)")
	private String name;

	@Column(columnDefinition = "varchar(255)")
	private String createdAt;
	
	@Column
	private Date discountStart;
	
	@Column
	private Date discountEnd;
	
	@ManyToOne
	@JoinColumn(name = "cateId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Image> images;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "product")
	List<Cart_Product> cart_products;

	
	public Product() {
	}
	public List<Cart_Product> getCart_products() {
		return cart_products;
	}

	public void setCart_products(List<Cart_Product> cart_products) {
		this.cart_products = cart_products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDiscountStart() {
		return discountStart;
	}

	public void setDiscountStart(Date discountStart) {
		this.discountStart = discountStart;
	}

	public Date getDiscountEnd() {
		return discountEnd;
	}

	public void setDiscountEnd(Date discountEnd) {
		this.discountEnd = discountEnd;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
