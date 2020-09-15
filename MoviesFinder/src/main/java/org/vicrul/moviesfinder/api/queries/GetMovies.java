package org.vicrul.moviesfinder.api.queries;

import org.vicrul.moviesfinder.domain.DetailsMovie;
import org.vicrul.moviesfinder.domain.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetMovies {
		
	@GET("movie/{movie_id}?language=ru-RU")
	Call<DetailsMovie> getMovieById(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
	
	@GET("movie/popular?language=ru-RU")
	Call<MoviesList> getListPopularMovies(@Query("api_key") String apiKey, @Query("page") int pageNumber);
	
	@GET("search/movie?language=ru-RU")
	Call<MoviesList> getMoviesByName(@Query("api_key") String apiKey, @Query("query") String name, @Query("page") int pageNumber);
}
