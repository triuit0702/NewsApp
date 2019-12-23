package tri.chung.newsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tri.chung.newsapp.entity.NewEntity;
import tri.chung.newsapp.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewService {

	@Autowired
	private NewsRepository newsRepository;

	public NewEntity saveNew(NewEntity news) {
		return newsRepository.save(news);
	}

	public List<NewEntity> getAllNews() {
		return newsRepository.findAll();
	}

	public NewEntity getNewsById(Long id) {
		NewEntity news = newsRepository.findById(id).orElse(null);
		return news;
	}

	public void deleteNews(Long id) {
		newsRepository.deleteById(id);
	}

}
