package tri.chung.newsapp.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class SignUpRequest {

	@NotBlank
	@Size(min = 4, max = 40)
	private String fullname;

	@NotBlank
	@Size(min = 3, max = 15)
	private String username;

	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
}
