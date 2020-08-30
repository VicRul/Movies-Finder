package org.vicrul.moviesfinder.domain;

import java.util.List;

import lombok.Data;

@Data
public class FavoriteMoviesList {

	private int page;
	private int totalResult;
	private int totalPages;
	private List<DetailsMovie> favoriteMovies;
}
