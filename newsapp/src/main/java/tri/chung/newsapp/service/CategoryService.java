package tri.chung.newsapp.service;

import java.util.List;

import tri.chung.newsapp.entity.CategoryEntity;

public interface CategoryService {

	public CategoryEntity save(CategoryEntity category);
	public CategoryEntity findById(Long id);
	public CategoryEntity findByCode(String code);
	public List<CategoryEntity> findAll();
}
