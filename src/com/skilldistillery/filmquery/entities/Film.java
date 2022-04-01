package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class Film {
	
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int launguageId; 
	private double rentalRate;
	private int length;
	private double replacmentCost;
	private String rating; 
	private String specialFeatures;
	private List<Actor> actorList;
	
	public Film(int id, String title, String description, int releaseYear, int launguageId, double rentalRate,
			int length, double replacmentCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.launguageId = launguageId;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacmentCost = replacmentCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		DatabaseAccessorObject dbao = new DatabaseAccessorObject();
		this.actorList = new ArrayList<>(dbao.findActorsByFilmId(id));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLaunguageId() {
		return launguageId;
	}

	public void setLaunguageId(int launguageId) {
		this.launguageId = launguageId;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacmentCost() {
		return replacmentCost;
	}

	public void setReplacmentCost(double replacmentCost) {
		this.replacmentCost = replacmentCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", launguageId=" + launguageId + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacmentCost=" + replacmentCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
				+ "\nactorList=" + actorList + "]";
	}
	
	
	
	
}
