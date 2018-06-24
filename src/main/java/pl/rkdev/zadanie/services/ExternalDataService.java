package pl.rkdev.zadanie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.rkdev.zadanie.models.Beer;
import pl.rkdev.zadanie.repositories.BeerRepository;

@Service
public class ExternalDataService {

	@Autowired
	private BeerRepository beerRepository;
	
	@Scheduled(fixedRate = 60 * 60 * 1000)
	private void getData() {
		RestTemplate restTemplate = new RestTemplate();
		int page = 1;
		Beer[] punkData;
		while((punkData = restTemplate.getForObject("https://api.punkapi.com/v2/beers?page=" + page, Beer[].class))
				.length != 0) {
			page++;
			for(Beer obj : punkData) {
				Beer beer;
				if((beer = beerRepository.findByPunkapiId(obj.getPunkapiId())) != null)
					obj.setId(beer.getId());
				beerRepository.save(obj);
			}
		}
	}
}
