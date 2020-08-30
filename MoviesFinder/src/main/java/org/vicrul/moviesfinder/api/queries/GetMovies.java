package org.vicrul.moviesfinder.api.queries;

import org.vicrul.moviesfinder.domain.DetailsMovie;
import org.vicrul.moviesfinder.domain.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetMovies {
	
	@GET("movie/{movie_id}?api_key=67f7e969d680de8d4117972f8ca3884d&language=ru-RU")
	Call<DetailsMovie> getMovieById(@Path("movie_id") int movieId);
	
	@GET("movie/popular?api_key=67f7e969d680de8d4117972f8ca3884d&language=ru-RU")
	Call<MoviesList> getListPopularMovies(@Query("page") int pageNumber);
	
	@GET("search/movie?api_key=67f7e969d680de8d4117972f8ca3884d&language=ru-RU")
	Call<MoviesList> getMoviesByName(@Query("query") String name, @Query("page") int pageNumber);
}
