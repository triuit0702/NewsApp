package tri.chung.newsapp.service;

import java.util.List;

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

	public CategoryEntity findById(Long id) {
		return categoryRepository.findById(id).orElse(null); 
	}

	public CategoryEntity findByCode(String code) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCode(code);
	}

	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
}
