package tri.chung.newsapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tri.chung.newsapp.entity.NewEntity;

public interface NewService {

	public void saveNew(NewEntity news);
	public List<NewEntity> getAllNews();
	public NewEntity getNewsById(Long id);
	public void deleteNews(Long id);
}
