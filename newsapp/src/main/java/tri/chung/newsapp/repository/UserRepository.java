package tri.chung.newsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tri.chung.newsapp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("select c from UserEntity c where c.userName = ?1")
	UserEntity findByUsername(String userName);
}
