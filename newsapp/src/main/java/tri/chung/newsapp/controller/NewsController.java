package tri.chung.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tri.chung.newsapp.entity.NewEntity;
import tri.chung.newsapp.service.NewService;

@RestController
@RequestMapping("/news-api")
public class NewsController {

	@Autowired
	private NewService newService;
	
	@PostMapping("/createNews")
	public ResponseEntity<NewEntity> createNews(@RequestBody NewEntity news) {
		if (news == null) {
			return new ResponseEntity<NewEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		NewEntity newsSaved = newService.saveNew(news);
		if (newsSaved == null) {
			return new ResponseEntity<NewEntity>(null, null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NewEntity>(newsSaved, null, HttpStatus.CREATED);
	}
	
	@GetMapping("/getNews")
	public ResponseEntity<List<NewEntity>> getAllNews() {
		List<NewEntity> listNews = newService.getAllNews();
		if (listNews == null) {
			return new ResponseEntity<List<NewEntity>>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<NewEntity>>(listNews, null, HttpStatus.OK);
	}
}
