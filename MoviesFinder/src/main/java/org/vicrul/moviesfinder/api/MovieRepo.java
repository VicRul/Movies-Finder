package org.vicrul.moviesfinder.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.vicrul.moviesfinder.api.queries.GetMovies;
import org.vicrul.moviesfinder.domain.DetailsMovie;
import org.vicrul.moviesfinder.domain.MoviesList;

import lombok.Getter;
import lombok.Setter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
@ConfigurationProperties
@Getter
@Setter
public class MovieRepo {
	
	private String apiKey;
	
	private GetMovies getMovies() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.themoviedb.org/3/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();		
		return retrofit.create(GetMovies.class);
	}
	
	private <T> T foundMovie(Call<T> searchingMovie) throws Exception {
		Response<T> execute = searchingMovie.execute();
		System.out.println(execute);
		T result = execute.body();
		return result;
	}

	public DetailsMovie getMovieById(int movieId) throws Exception {
		Call<DetailsMovie> searchMovie = getMovies().getMovieById(movieId, apiKey);
		return foundMovie(searchMovie);
	}

	public MoviesList getListPopularMovies(int pageNumber) throws Exception {
		Call<MoviesList> popularMoviesList = getMovies().getListPopularMovies(apiKey, pageNumber);
		return foundMovie(popularMoviesList);
	}

	public MoviesList getListMoviesByName(String name, int pageNumber) throws Exception {
		Call<MoviesList> moviesByName = getMovies().getMoviesByName(apiKey, name, pageNumber);
		return foundMovie(moviesByName);
	}

}
