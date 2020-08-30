package org.vicrul.moviesfinder.api;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.vicrul.moviesfinder.api.queries.GetGenres;
import org.vicrul.moviesfinder.domain.Genre;
import org.vicrul.moviesfinder.domain.GenresList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class GenreRepo {

	private static List<Genre> genresList = null;

	public List<Genre> getAllGenres() throws IOException {
		if (genresList == null || genresList.isEmpty()) {
			Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
					.addConverterFactory(GsonConverterFactory.create()).build();
			GetGenres getAllGenres = retrofit.create(GetGenres.class);
			Call<GenresList> responseGenres = getAllGenres.getGenres();
			Response<GenresList> execute = responseGenres.execute();
			genresList = execute.body().getGenres();
		}
		return genresList;
	}
	
	public void clearGenresList() {
		if (genresList != null) {
			genresList.clear();
		}
	}
}
