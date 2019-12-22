package tri.chung.newsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tri.chung.newsapp.entity.CategoryEntity;
import tri.chung.newsapp.service.CategoryService;

@RestController
@RequestMapping("/cate")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@GetMapping("/test")
	public String test() {
		return "chao moi nguoi";
	}
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
		CategoryEntity newCategory = categoryService.save(category);
		if (newCategory == null) {
			return new ResponseEntity<CategoryEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CategoryEntity>(newCategory, null, HttpStatus.CREATED);
	}
}
