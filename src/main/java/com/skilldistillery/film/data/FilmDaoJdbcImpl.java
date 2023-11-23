package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PW = "student";
	
	
	public FilmDaoJdbcImpl(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		
		String sql = "SELECT * FROM film f WHERE f.id = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int filmId1 = rs.getInt("id");
			String title = rs.getString("title");
			String desc = rs.getString("description");
			short releaseYear = rs.getShort("release_year");
			int langId = rs.getInt("language_id");
			String language  = findLanguagebyFilmID(filmId1);
			int rentDur = rs.getInt("rental_duration");
			double rate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double repCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String features = rs.getString("special_features");
			String category = findCategorybyFilmID(filmId1);
			List<Actor> filmActors = findActorsByFilmId(filmId1);
			film = new Film(filmId1, title, releaseYear, desc, langId, language, rentDur, rate, length, repCost, rating, features, category, filmActors);
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	
	@Override
	public List<Film> searchByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		
		try {
		
		Connection conn = DriverManager.getConnection(URL, USER, PW);

		String sql = "SELECT * FROM film f WHERE f.title LIKE ? OR f.description LIKE ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");

		ResultSet rs = stmt.executeQuery();
		Film film = null;
		while (rs.next()) {
			int filmId = rs.getInt("id");
			String title = rs.getString("title");
			String desc = rs.getString("description");
			short releaseYear = rs.getShort("release_year");
			int langId = rs.getInt("language_id");
			String language = findLanguagebyFilmID(filmId);
			int rentDur = rs.getInt("rental_duration");
			double rate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double repCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String features = rs.getString("special_features");
			String category = findCategorybyFilmID(filmId);
			List<Actor> filmActors = findActorsByFilmId(filmId);
			film = new Film(filmId, title, releaseYear, desc, langId, language, rentDur, rate, length, repCost, rating, features, category, filmActors);

			films.add(film);

		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}
	
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			
			String sql = "SELECT * FROM actor a JOIN film_actor fa ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String fn = rs.getString("first_name");
				String ln = rs.getString("last_name");
				int id = rs.getInt("id");
				Actor actor = new Actor(id, fn, ln);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	
	@Override
	public String findLanguagebyFilmID(int filmID) {
		String language = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);

			String sql = "SELECT name FROM language l JOIN film f ON l.id = f.language_id WHERE f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				language = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}
	@Override
	public String findCategorybyFilmID(int filmID) {
		String language = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			
			String sql = "SELECT name FROM category c "
					+ "JOIN film_category fc ON c.id = fc.category_id "
					+ "JOIN film f ON fc.film_id = f.id "
					+ "WHERE f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				language = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}

}
