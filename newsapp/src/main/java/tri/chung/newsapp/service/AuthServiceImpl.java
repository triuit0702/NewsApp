package tri.chung.newsapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tri.chung.newsapp.entity.RoleEntity;
import tri.chung.newsapp.entity.UserEntity;
import tri.chung.newsapp.model.SignUpRequest;
import tri.chung.newsapp.repository.RoleRepository;
import tri.chung.newsapp.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public UserEntity postUser(SignUpRequest signUpRequest) {
		String encodePass = passwordEncoder.encode(signUpRequest.getPassword());
		UserEntity user = new UserEntity(signUpRequest.getUsername(), encodePass, signUpRequest.getFullname());
		RoleEntity roleUser = roleRepository.findByCode("USER");
		Set<RoleEntity> listRole = new HashSet<>();
		listRole.add(roleUser);
		user.setRoles(listRole);
		UserEntity newUser = userRepository.save(user);
		return newUser;
	}
}
