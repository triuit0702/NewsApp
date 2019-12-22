package tri.chung.newsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tri.chung.newsapp.entity.CategoryEntity;
import tri.chung.newsapp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryEntity save(CategoryEntity category) {
		return categoryRepository.save(category);
	}

}
