package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_getFilmById_with_id_of_one_returns_valid_film() {
	  Film f = db.findFilmById(1);
	  Film e = new Film();
		e.setId(1);
//		e.setTitle("ACADEMY DINOSAUR");
//		e.setDescription("A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies");
//		e.setReleaseYear( 1993 );
//		e.setLaunguageId(3);
//		e.setRentalRate(0.99);
//		e.setLength(86);
//		e.setReplacmentCost(20.99);
//		e.setRating("PG");
//		e.setSpecialFeatures("Deleted Scenes,Behind the Scenes");

	  assertEquals(e, f);
  }
  
  @Test
  void test_findActorsByFilmId_returns_EmptyList_with_invalid_filmId() {
	  List<Actor> actorList = new ArrayList<>(db.findActorsByFilmId(-345));
	  List<Actor> emptyList = new ArrayList<>();
	  assertEquals(emptyList, actorList);
  }
  
  @Test
  void test_findActorsByFilmId_returns_ActorList_with_filmId_two() {
	  List<Actor> actorList = new ArrayList<>(db.findActorsByFilmId(2));
	  List<Actor> compList = new ArrayList<>();
	  compList.add(new Actor(19));
	  compList.add(new Actor(85));
	  compList.add(new Actor(90));
	  compList.add(new Actor(160));
	  
	  assertEquals(compList, actorList);
	   
  }
  
  @Test
  void test_findFilmBySearch_returns_emptyList_for_invalid_search() {
	  List<Film> actorList = new ArrayList<>(db.findFilmBySearch("Hello"));
	  List<Actor> emptyList = new ArrayList<>();
	  
	  assertEquals(emptyList, actorList);
  }
  
  @Test
  void test_findFilmBySearch_returns_ListWFilms_for_search_YOUNG_LANGUAGE() {
	  List<Film> filmList = new ArrayList<>(db.findFilmBySearch("YOUNG LANGUAGE"));
	  List<Film> testList = new ArrayList<>();
	  Film temp = new Film();
	  temp.setId(996);
	  testList.add(temp);
	  
	  assertEquals(testList, filmList);
  }
  

}
