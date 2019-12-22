package tri.chung.newsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String Hello() {
		System.out.println("ok ok");
		return "Chao cac ban";
	}
}
