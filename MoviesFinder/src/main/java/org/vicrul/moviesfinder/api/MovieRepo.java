package org.vicrul.moviesfinder.api;

import org.springframework.stereotype.Component;
import org.vicrul.moviesfinder.api.queries.GetMovies;
import org.vicrul.moviesfinder.domain.DetailsMovie;
import org.vicrul.moviesfinder.domain.MoviesList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class MovieRepo {
	
	private GetMovies getMovies() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.themoviedb.org/3/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();		
		return retrofit.create(GetMovies.class);
	}
	
	private <T> T foundMovie(Call<T> searchingMovie) throws Exception {
		Response<T> execute = searchingMovie.execute();
		T result = execute.body();
		new GenreRepo().clearGenresList();
		return result;
	}

	public DetailsMovie getMovieById(int movieId) throws Exception {
		Call<DetailsMovie> searchMovie = getMovies().getMovieById(movieId);
		return foundMovie(searchMovie);
	}

	public MoviesList getListPopularMovies(int pageNumber) throws Exception {
		Call<MoviesList> popularMoviesList = getMovies().getListPopularMovies(pageNumber);
		return foundMovie(popularMoviesList);
	}

	public MoviesList getListMoviesByName(String name, int pageNumber) throws Exception {
		Call<MoviesList> moviesByName = getMovies().getMoviesByName(name, pageNumber);
		return foundMovie(moviesByName);
	}

}
