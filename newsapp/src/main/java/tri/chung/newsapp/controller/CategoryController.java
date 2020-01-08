package tri.chung.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tri.chung.newsapp.entity.CategoryEntity;
import tri.chung.newsapp.service.CategoryService;

@RestController
@RequestMapping("/api-cate")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@GetMapping("/test")
	public String test() {
		return "chao moi nguoi";
	}
	@PostMapping("/category")
	public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
		CategoryEntity newCategory = categoryService.save(category);
		if (newCategory == null) {
			return new ResponseEntity<CategoryEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<CategoryEntity>(newCategory, null, HttpStatus.CREATED);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryEntity> getCateById(@PathVariable("id") Long id) {
		CategoryEntity cate = categoryService.findById(id);
		if (cate == null) {
			return new ResponseEntity<CategoryEntity>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryEntity>(cate, null, HttpStatus.OK);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<CategoryEntity>> getCategory() {
		List<CategoryEntity> listCategory = categoryService.findAll();
		if (CollectionUtils.isEmpty(listCategory)) {
			return new ResponseEntity<List<CategoryEntity>>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CategoryEntity>>(listCategory, null, HttpStatus.OK);
	}
}
