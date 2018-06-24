package pl.rkdev.zadanie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.rkdev.zadanie.models.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long>{
	
	public Beer findByPunkapiId(Long id);
	public List<Beer> findByFoodPairingsLike(String phrase);
}
