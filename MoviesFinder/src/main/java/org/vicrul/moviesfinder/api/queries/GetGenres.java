package org.vicrul.moviesfinder.api.queries;

import org.vicrul.moviesfinder.domain.GenresList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGenres {

	@GET("genre/movie/list?api_key=7d390a86785cece213ab038481248e69&language=ru")
	Call<GenresList> getGenres();
}
