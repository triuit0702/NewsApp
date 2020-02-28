package tri.chung.newsapp.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tri.chung.newsapp.entity.UserEntity;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {

	private Long id;
	private String username;
	private String password;
	private String fullname;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(Long id, String username, String password, String fullname,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static CustomUserDetails create(UserEntity user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());

		return new CustomUserDetails(user.getId(), user.getUserName(), user.getPassword(), user.getFullName(),
				authorities);
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
