package tri.chung.newsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tri.chung.newsapp.entity.NewEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewEntity, Long>{

}
