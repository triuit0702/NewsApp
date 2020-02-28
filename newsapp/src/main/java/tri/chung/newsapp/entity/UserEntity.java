package tri.chung.newsapp.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity extends AbtractEntity {

	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="fullname")
	private String fullName;
	@Column
	private Integer status;
	@OneToMany(mappedBy = "user")
	private List<CommenEntity> comment;
	@ManyToMany
	@JoinTable(
		name = "user_role",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();
	
	  public UserEntity() {}

	  public UserEntity(String username, String password, String fullname) {
	    this.userName = username;
	    this.password = password;
	    this.fullName = fullname;
	  }
}
