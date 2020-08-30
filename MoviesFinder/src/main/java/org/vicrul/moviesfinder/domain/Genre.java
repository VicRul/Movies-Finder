package org.vicrul.moviesfinder.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("name")
	@Expose
	private String name;
	
	public String getNameById(List<Integer> items) {
		for (Integer item : items) {
			if(item == this.id) {
				return this.name;
			}
		}
		return null;
	}
}
