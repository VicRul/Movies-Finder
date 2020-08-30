package org.vicrul.moviesfinder.domain;

import java.io.Serializable;
import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DetailsMovie implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("release_date")
	@Expose
	private String releaseDate;
	@SerializedName("overview")
	@Expose
	private String overview;
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
