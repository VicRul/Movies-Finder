package org.vicrul.moviesfinder.domain;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class MoviesList implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("page")
	@Expose
	private int page;
	@SerializedName("total_results")
	@Expose
	private int totalResults;
	@SerializedName("total_pages")
	@Expose
	private int totalPages;
	@SerializedName("results")
	@Expose
	private List<Movie> moviesList = null;
}