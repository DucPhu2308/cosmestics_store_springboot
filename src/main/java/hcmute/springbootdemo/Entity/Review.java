package hcmute.springbootdemo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity

@Table(name = "Review")

@NamedQuery(name = "Review.findAll", query = "SELECT p FROM Review p")
public class Review implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(columnDefinition = "bigint")
	private int parentId;

	@Column(columnDefinition = "smallint(2)")
	private int rating;
	
	@Column(columnDefinition = "text")
	private String content;
	
	@Column(columnDefinition = "bit")
	private int published;
	
	@Column(columnDefinition = "datetime")
	private Date createdAt;
	
	@Column(columnDefinition = "datetime")
	private Date lastUpdate;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER)
	private List<User> users;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Review parent;

	public Review(int id, int parentId, int rating, String content, int published, Date createdAt, Date lastUpdate,
			Product product, List<User> users, Review parent) {
		this.id = id;
		this.parentId = parentId;
		this.rating = rating;
		this.content = content;
		this.published = published;
		this.createdAt = createdAt;
		this.lastUpdate = lastUpdate;
		this.product = product;
		this.users = users;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Review getParent() {
		return parent;
	}

	public void setParent(Review parent) {
		this.parent = parent;
	}
	
}
