package tri.chung.newsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tri.chung.newsapp.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	@Query("select c from CategoryEntity c where c.code = ?1")
	CategoryEntity findByCode(String code);
}
