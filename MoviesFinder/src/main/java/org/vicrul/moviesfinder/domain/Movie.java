package org.vicrul.moviesfinder.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.vicrul.moviesfinder.api.GenreRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SerializedName("id")
	@Expose
	@Getter
	private int id;
	@SerializedName("title")
	@Expose
	@Getter
	private String title;
	@SerializedName("release_date")
	@Expose
	@Getter
	private String releaseDate;
	@SerializedName("overview")
	@Expose
	@Getter
	private String overview;
	@SerializedName("genre_ids")
	@Expose
	private List<Integer> genres = null;
	
	public List<Genre> getGenres() throws IOException {
		int genreIdsSize = this.genres.size();
		
		if (genreIdsSize == 0) {
			return null;
		}
		List<Genre> unloadingGenres = GenreRepo.getAllGenres();
		List<Genre> genres = new ArrayList<Genre>();

		for (Genre genre : unloadingGenres) {
			String genreName = genre.getNameById(this.genres);
			
			if (genreName != null) {
				genreIdsSize --;
				genres.add(genre);
				
				if (genreIdsSize == 0) {
					break;
				}
			}
		}
		return genres;
	}
}
