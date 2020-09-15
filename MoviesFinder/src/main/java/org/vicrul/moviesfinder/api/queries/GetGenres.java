package org.vicrul.moviesfinder.api.queries;

import org.vicrul.moviesfinder.domain.GenresList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetGenres {

	@GET("genre/movie/list?language=ru")
	Call<GenresList> getGenres(@Query("api_key") String apiKey);
}
