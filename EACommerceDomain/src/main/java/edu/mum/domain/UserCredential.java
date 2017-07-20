package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name = "findUserCredential", query = "select u from UserCredential u where u.username = :username")
public class UserCredential implements Serializable {

	private static final long serialVersionUID = -2294959910306288951L;

	@Id
	@Column(nullable = false, unique = true)
	String username;
	@Column(nullable = false)
	String password;
	String verifyPassword;
	Boolean enabled;

	@OneToOne(mappedBy = "userCredentials", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties(value = "userCredentials")
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id")
	List<Authority> authority = new ArrayList<Authority>();

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return this.verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return this.authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public User getMember() {
		return this.user;
	}

	public void setMember(User member) {
		this.user = member;
	}

}
