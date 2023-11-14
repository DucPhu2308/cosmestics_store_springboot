package hcmute.springbootdemo.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity

@Table(name = "Users")

@NamedQuery(name = "User.findAll", query = "SELECT p FROM User p")

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(columnDefinition = "varchar(255)")
	private String firstName;
	
	@Column(columnDefinition = "varchar(255)")
	private String lastName;
	
	@Column(columnDefinition = "varchar(11)")
	private String phone;
	
	@Column(columnDefinition = "varchar(255)")
	private String email;
	
	@Column(columnDefinition = "date")
	private Date dob;
	
	@Column
	private Boolean gender;
	
	@Column(columnDefinition = "varchar(255)")
	private String avatarLink;
	
	@Column(columnDefinition = "varchar(40)")
	private String passwordHashed;
	
	@Column
	private Boolean isAdmin;
	
	@Column
	private Boolean active;
	
	@Column
	private LocalDateTime createdAt;
	
	@Column
	private LocalDateTime lastLogin;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Review> reviews;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Cart> carts;
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getAvatarLink() {
		return avatarLink;
	}

	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}

	public String getPasswordHashed() {
		return passwordHashed;
	}

	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
}
