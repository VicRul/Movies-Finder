package org.vicrul.moviesfinder.api.queries;

import org.vicrul.moviesfinder.domain.GenresList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGenres {

	@GET("genre/movie/list?api_key=67f7e969d680de8d4117972f8ca3884d&language=ru")
	Call<GenresList> getGenres();
}
