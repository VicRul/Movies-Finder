package org.vicrul.moviesfinder.domain;

import java.io.Serializable;
import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class DetailsMovie extends Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("genres")
	@Expose
	private List<Genre> genres = null;
	@SerializedName("homepage")
	@Expose
	private String homePage;
	@SerializedName("runtime")
	@Expose
	private int runtime;
	@SerializedName("spoken_languages")
	@Expose
	private List<SpokenLanguage> spokenLanguages = null;
	@SerializedName("production_companies")
	@Expose
	private List<ProductionCompany> productionCompanies = null;
	@SerializedName("production_countries")
	@Expose
	private List<ProductionCountry> productionCountries = null;
	@SerializedName("popularity")
	@Expose
	private float popularity;
	@SerializedName("vote_average")
	@Expose
	private float voteAverage;
	@SerializedName("vote_count")
	@Expose
	private int voteCount;
	
	
}
