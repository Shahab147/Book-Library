package com.ahm.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
	private String title;
	private String author;
	private String genre;
	private int rating;
	private int noOfPages;

	public Book() {
		 //genre = new ArrayList<>();
	}

	public Book(String title, String author, List<String> genre, int rating, int noOfPages) {
		this.title = title;
		this.author = author;
		genre = new ArrayList<>();
		this.rating = rating;
		this.noOfPages = noOfPages;
	}

	@Override
	public String toString() {
		return "\nTitle:" + title + "\nAuthor:" + author + "\nGenre:" + genre + "\nRating:" + rating + "\nNoOfPages:"
				+ noOfPages;
	}

}
