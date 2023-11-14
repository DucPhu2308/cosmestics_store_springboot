package hcmute.springbootdemo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity

@Table(name = "User")

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
	
	@Column(columnDefinition = "datetime")
	private Date dob;
	
	@Column(columnDefinition = "bit")
	private int gender;
	
	@Column(columnDefinition = "varchar(255)")
	private String avatarLink;
	
	@Column(columnDefinition = "varchar(40)")
	private String passwordHashed;
	
	@Column(columnDefinition = "bit")
	private int isAdmin;
	
	@Column(columnDefinition = "bit")
	private int active;
	
	@Column(columnDefinition = "datetime")
	private Date createdAt;
	
	@Column(columnDefinition = "datetime")
	private Date lastLogin;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Cart> carts;

	public User(int id, String firstName, String lastName, String phone, String email, Date dob, int gender,
			String avatarLink, String passwordHashed, int isAdmin, int active, Date createdAt, Date lastLogin,
			List<Cart> carts) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.avatarLink = avatarLink;
		this.passwordHashed = passwordHashed;
		this.isAdmin = isAdmin;
		this.active = active;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.carts = carts;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
}
