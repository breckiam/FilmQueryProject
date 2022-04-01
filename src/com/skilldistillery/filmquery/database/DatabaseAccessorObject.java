package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Driver not found");
			throw new RuntimeException("");
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Film film = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE film.id = ?";
			s = conn.prepareStatement(sqltxt);
			s.setInt(1, filmId);
			rs = s.executeQuery();

			if (rs.next()) {
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("release_year"), rs.getInt("language_id"), rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"), rs.getString("rating"), rs.getString("special_features") );
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} 
				if (s != null) {
					s.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Actor actor = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT * FROM actor WHERE actor.id = ?";
			s = conn.prepareStatement(sqltxt);
			s.setInt(1, actorId);
			rs = s.executeQuery();

			if (rs.next()) {
				actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} 
				if (s != null) {
					s.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		List<Actor> actorlist = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, user, pass);

			String sqltxt;
			sqltxt = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";
			s = conn.prepareStatement(sqltxt);
			s.setInt(1, filmId);
			rs = s.executeQuery();

			while (rs.next()) {
				actorlist.add( new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} 
				if (s != null) {
					s.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return actorlist;
	}

}
