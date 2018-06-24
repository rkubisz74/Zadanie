package pl.rkdev.zadanie.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "beers")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"punkapiId", "name", "tagline", "firstBrewed", "description",
		"imageUrl", "ibu", "foodPairings"})
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private Long punkapiId;
	@Size(max = 255)
	private String name;
	@Size(max = 255)
	private String tagline;
	@Size(max = 10)
	private String firstBrewed;
	@Lob
	@Column(length = 2048)
	private String description;
	@Size(max = 250)
	private String imageUrl;
	private Double ibu;
	@ElementCollection
	private List<String> foodPairings = new ArrayList<>();
	
	public Beer() {
		punkapiId = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("punkapiId")
	public Long getPunkapiId() {
		return punkapiId;
	}
	
	@JsonProperty("id")
	public void setPunkapiId(Long punkapiId) {
		this.punkapiId = punkapiId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTagline() {
		return tagline;
	}
	
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	
	@JsonProperty("firstBrewed")
	public String getFirstBrewed() {
		return firstBrewed;
	}
	
	@JsonProperty("first_brewed")
	public void setFirst_Brewed(String firstBrewed) {
		this.firstBrewed = firstBrewed;
	}
	
	@JsonProperty("firstBrewed")
	public void setFirstBrewed(String firstBrewed) {
		this.firstBrewed = firstBrewed;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}

	@JsonSetter("image_url")
	public void setImage_Url(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@JsonSetter("imageUrl")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Double getIbu() {
		return ibu;
	}
	
	public void setIbu(Double ibu) {
		this.ibu = ibu;
	}
	
	@JsonProperty("foodPairing")
	public List<String> getFoodPairings() {
		return foodPairings;
	}

	@JsonProperty("food_pairing")
	public void setFoodPairings(List<String> foodPairings) {
		this.foodPairings = foodPairings;
	}
}
