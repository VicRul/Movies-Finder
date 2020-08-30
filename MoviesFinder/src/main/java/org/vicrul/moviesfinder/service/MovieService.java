package org.vicrul.moviesfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.vicrul.moviesfinder.domain.MoviesList;
import org.vicrul.moviesfinder.repo.FavoriteMovieRepo;
import org.vicrul.moviesfinder.api.MovieRepo;
import org.vicrul.moviesfinder.domain.DetailsMovie;
import org.vicrul.moviesfinder.domain.FavoriteMovie;
import org.vicrul.moviesfinder.domain.FavoriteMoviesList;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import lombok.AllArgsConstructor;

@GraphQLApi
@Service
@AllArgsConstructor
public class MovieService {

	private final MovieRepo movieRepository;
	private final FavoriteMovieRepo favoriteMoviesRepository;

	@GraphQLQuery
	public FavoriteMoviesList getListFavoriteMovies(@GraphQLArgument(name = "userId") int userId,
			@GraphQLArgument(name = "page", defaultValue = "1") int page) throws Exception {
		Pageable pageWithFiveElements = PageRequest.of(page - 1, 5);
		List<FavoriteMovie> listFromDB = favoriteMoviesRepository.findByUserId(userId, pageWithFiveElements);
		int totalResult = favoriteMoviesRepository.countByUserId(userId);
		int totalPages = (int) Math.ceil((double) totalResult / 5);
		List<DetailsMovie> listFavoriteMovies = new ArrayList<DetailsMovie>();

		for (FavoriteMovie item : listFromDB) {
			listFavoriteMovies.add(getMovieById(item.getMovieId()));
		}

		FavoriteMoviesList favoriteMoviesList = new FavoriteMoviesList();
		favoriteMoviesList.setPage(page);
		favoriteMoviesList.setTotalPages(totalPages);
		favoriteMoviesList.setTotalResult(totalResult);
		favoriteMoviesList.setFavoriteMovies(listFavoriteMovies);
		return favoriteMoviesList;
	}

	@GraphQLMutation
	public DetailsMovie addToFavoriteMoviesList(@GraphQLArgument(name = "userId") int userId,
			@GraphQLArgument(name = "movieId") int movieId) throws Exception {
		FavoriteMovie movie = new FavoriteMovie();
		movie.setUserId(userId);
		movie.setMovieId(movieId);
		try {
			if (favoriteMoviesRepository.findByUserIdAndMovieId(userId, movieId) == null) {
				favoriteMoviesRepository.save(movie);
			}
		} catch (Exception e) {
			System.out.println("Фильм уже есть в избранном");
		}
		return getMovieById(movieId);
	}

	@GraphQLMutation
	public DetailsMovie deleteFromFavoriteMovieList(@GraphQLArgument(name = "userId") int userId,
			@GraphQLArgument(name = "movieId") int movieId) throws Exception {
		favoriteMoviesRepository.deleteByUserIdAndMovieId(userId, movieId);
		return getMovieById(movieId);
	}

	@GraphQLQuery
	public DetailsMovie getMovieById(@GraphQLArgument(name = "id") int movieId) throws Exception {
		return movieRepository.getMovieById(movieId);
	}

	@GraphQLQuery
	public MoviesList getListPopularMovies(@GraphQLArgument(name = "page", defaultValue = "1") int pageNumber)
			throws Exception {
		return movieRepository.getListPopularMovies(pageNumber);
	}

	@GraphQLQuery
	public MoviesList getListMoviesByName(@GraphQLArgument(name = "title") String name,
			@GraphQLArgument(name = "page", defaultValue = "1") int pageNumber) throws Exception {
		return movieRepository.getListMoviesByName(name, pageNumber);
	}
}
