package j6.demo7.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "full_name")
	private String fullname;
	@Column(name = "email")
	private String email;
	@Column(name = "photo")
	private String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private List<Authority> authorities;
}
