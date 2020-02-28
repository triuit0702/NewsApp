package tri.chung.newsapp.model;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

	private String accessToken;
	private String tokenType = "Bearer";

	public JwtAuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}
}
