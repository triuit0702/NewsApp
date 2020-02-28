package tri.chung.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tri.chung.newsapp.entity.UserEntity;
import tri.chung.newsapp.model.JwtAuthenticationResponse;
import tri.chung.newsapp.model.LoginRequest;
import tri.chung.newsapp.model.SignUpRequest;
import tri.chung.newsapp.repository.UserRepository;
import tri.chung.newsapp.security.CustomUserDetails;
import tri.chung.newsapp.security.JwtTokenProvider;
import tri.chung.newsapp.service.AuthService;

@RestController
@RequestMapping("/api/")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthService authService;

	@GetMapping("/index")
	public String index() {
		return "<html><h1>Chao cac ban</h1></html>";
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String jwt = tokenProvider.generateToken(customUserDetails.getId());
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@GetMapping("/getUser/{username}")
	public ResponseEntity<?> welcome(@PathVariable String username) {
		UserEntity user = userRepository.findByUsername(username);
		return new ResponseEntity<UserEntity>(user, null, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		if (userRepository.findByUsername(signUpRequest.getUsername()) != null) {
			return new ResponseEntity<String>("User name is aldready taken!", null, HttpStatus.BAD_REQUEST);
		}
		UserEntity newUser = authService.postUser(signUpRequest);
		return new ResponseEntity<UserEntity>(newUser, null, HttpStatus.CREATED);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUser() {
		List<UserEntity> listUser = userRepository.findAll();
		return new ResponseEntity<List<UserEntity>>(listUser, null, HttpStatus.OK);
	}
}
