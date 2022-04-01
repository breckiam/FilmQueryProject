package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner kb = new Scanner(System.in);
	private DatabaseAccessorObject dao = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Welcome to Film Query!");
		
		displayMainMenu();

	}

	private void displayMainMenu() {
		boolean keepGoing = true;

		while (keepGoing) {

			System.out.println("1. Look up a film by id");
			System.out.println("2. Look up a film by a search keyword");
			System.out.println("3. Exit the application");
			String choice = kb.next();

			switch (choice) {
			case "1":
			case "id":
				filmLookupById();
				break;
			case "2":
			case "search":
			case "keyword":
				filmLookupBySearch();
				break;
			case "3":
			case "quit":
				keepGoing = false;
				break;
			default:
				System.out.println("Please slect a valid choice");
			}
		}
	}

	private void filmLookupBySearch() {
		// TODO Auto-generated method stub

	}

	private void filmLookupById() {
		System.out.print("Please enter a film ID: ");
		int choice = kb.nextInt();
		Film f = dao.findFilmById(choice);
		
		if(f == null) {
			System.out.println("No film found for that ID");
		} else {
			System.out.println(f);
		}

		System.out.println();
	}

}
