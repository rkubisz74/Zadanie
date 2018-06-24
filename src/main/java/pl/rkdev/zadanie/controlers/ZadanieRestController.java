package pl.rkdev.zadanie.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.rkdev.zadanie.models.Beer;
import pl.rkdev.zadanie.repositories.BeerRepository;

@RestController
public class ZadanieRestController {
	
	@Autowired
	BeerRepository beerRepository;
	
	@Autowired
	private ApplicationContext context;

	@RequestMapping("/")
	public List<Beer> home() {
		return beerRepository.findAll();
	}
	
	@RequestMapping(value = "/foodpairings/search/{phrase}", method = RequestMethod.GET)
	public List<Beer> searchFoodPairingsPhrase(@PathVariable String phrase) {
		return beerRepository.findByFoodPairingsLike("%" + phrase + "%");
	}
	
	@RequestMapping(value = "/beers", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Beer beer) {
		if(beerRepository.save(beer) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
	}
	
	@RequestMapping("/shutdown")
	public void shutdown() {
		SpringApplication.exit(context, () -> 0);
	}
}
