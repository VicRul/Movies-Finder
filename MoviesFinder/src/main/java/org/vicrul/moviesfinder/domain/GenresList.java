package org.vicrul.moviesfinder.domain;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GenresList implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("genres")
	@Expose
	private List<Genre> genres = null;
}
