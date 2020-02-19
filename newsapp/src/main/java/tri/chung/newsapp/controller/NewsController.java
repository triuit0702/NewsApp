package tri.chung.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tri.chung.newsapp.dto.NewsDTO;
import tri.chung.newsapp.entity.CategoryEntity;
import tri.chung.newsapp.entity.NewEntity;
import tri.chung.newsapp.service.CategoryService;
import tri.chung.newsapp.service.NewService;
import tri.chung.newsapp.utils.Utils;

@RestController
@RequestMapping("/news-api")
public class NewsController {

	@Autowired
	private NewService newService;
	@Autowired
	private CategoryService categoryService;

	@PostMapping(path="/News", consumes = "application/json", produces = "application/json")
	public ResponseEntity<NewEntity> createNews(@RequestBody NewEntity news) {
		if (news == null) {
			return new ResponseEntity<NewEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		CategoryEntity category = categoryService.findByCode(news.getCategory().getCode());
		news.setCategory(category);
		NewEntity newsSaved = newService.saveNew(news);
		if (newsSaved == null) {
			return new ResponseEntity<NewEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NewEntity>(newsSaved, null, HttpStatus.CREATED);
	}

	@GetMapping("/News")
	public ResponseEntity<List<NewEntity>> getAllNews() {
		List<NewEntity> listNews = newService.getAllNews();
		if (listNews == null) {
			return new ResponseEntity<List<NewEntity>>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NewEntity>>(listNews, null, HttpStatus.OK);
	}

	@GetMapping(path = "/News/{id}")
	public ResponseEntity<NewsDTO> getNews(@PathVariable("id") Long id) {
		NewEntity news = newService.getNewsById(id);
		if (news == null) {
			return new ResponseEntity<NewsDTO>(null, null, HttpStatus.NOT_FOUND);
		}
		NewsDTO result = new NewsDTO();
		NewsDTO newsDTO = null;
		try {
			newsDTO = (NewsDTO) Utils.mergeObject(result, news);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<NewsDTO>(newsDTO, null, HttpStatus.OK);
	}

	@DeleteMapping("/News/{id}")
	public ResponseEntity<NewEntity> deleteNewsById(@PathVariable("id") Long id) {
		newService.deleteNews(id);

		NewEntity newsExist = newService.getNewsById(id);
		if (newsExist != null) {
			return new ResponseEntity<NewEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NewEntity>(null, null, HttpStatus.OK);
	}
}
