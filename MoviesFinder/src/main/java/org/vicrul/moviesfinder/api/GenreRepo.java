package org.vicrul.moviesfinder.api;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.vicrul.moviesfinder.api.queries.GetGenres;
import org.vicrul.moviesfinder.domain.Genre;
import org.vicrul.moviesfinder.domain.GenresList;

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
public class GenreRepo {

	private String apiKey;

	public List<Genre> getAllGenres() throws IOException {
			Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
					.addConverterFactory(GsonConverterFactory.create()).build();
			GetGenres getAllGenres = retrofit.create(GetGenres.class);
			Call<GenresList> responseGenres = getAllGenres.getGenres(apiKey);
			Response<GenresList> execute = responseGenres.execute();
			System.out.println(execute);
			List<Genre> genresList = execute.body().getGenres();
		
		return genresList;
	}
}
