package com.OnlineVoatingSystem.OnlineVoatingSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminID;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role", nullable = false)
    private String role; // e.g., system admin, election manager

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    // Getters and Setters
    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", fullName=" + fullName + ", username=" + username + ", password="
				+ password + ", email=" + email + ", role=" + role + ", phoneNumber=" + phoneNumber + ", getAdminID()="
				+ getAdminID() + ", getFullName()=" + getFullName() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getRole()=" + getRole()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Admin(long adminID, String fullName, String username, String password, String email, String role,
			String phoneNumber) {
		super();
		this.adminID = adminID;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
}
