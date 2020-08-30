package org.vicrul.moviesfinder.domain;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ProductionCompany implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("name")
	@Expose
	private String name;
}
