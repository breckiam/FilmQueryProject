package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

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
	private String category; 
	
	
	

	public Film() {
		super();
	}

	public Film(int id, String title, String description, int releaseYear, int launguageId, double rentalRate,
			int length, double replacmentCost, String rating, String specialFeatures, List<Actor> actorList) {
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
		this.actorList = actorList;
	}
	
	///////////// GETTERS and SETTERS //////////////////

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
	
	
	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	/////////////////// END GETTERS and SETTERS ////////////////

	public String filmLanguage() {
		String lang = "";
		
		switch(launguageId) {
		case 1: lang = "English"; break;
		case 2: lang = "Spanish"; break;
		case 3: lang = "Japanese"; break;
		case 4: lang = "Italian"; break;
		case 5: lang = "German"; break;
		}
		
		return lang;
	}
	
	public String fullDescription() {
		
		return "Film id: " + id + ", title: " + title  + ", releaseYear: " + releaseYear
				+ ", launguageId: " + filmLanguage() + ", rentalRate: " + rentalRate + ", length: " + length + ", description: " + description
				+ ", replacmentCost: " + replacmentCost + ", rating: " + rating + ", specialFeatures: " + specialFeatures
				+ ",\nActor List: " + actorList ;
	}

	@Override
	public String toString() {
		return "Film: " + title + ", releaseYear: " + releaseYear
				+ ", launguage: " + filmLanguage() + ", rating: " + rating 
				+ "\nSpecial Features: " + specialFeatures
				+ "\nCategory: " + category
				+ "\ndescription: " + description 
				+ "\nActor List: " + actorList +"\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return id == other.id;
	}
	
	
	
	
	
	
}
