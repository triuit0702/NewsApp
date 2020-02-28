package tri.chung.newsapp.service;

import tri.chung.newsapp.entity.UserEntity;
import tri.chung.newsapp.model.SignUpRequest;

public interface AuthService {
	UserEntity postUser(SignUpRequest signUpRequest);
}
