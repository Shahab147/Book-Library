package com.ahm.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Serializable {
	public List<Book> bookCollection;
	public int noOfRacks;
	// public String rackName;

	public BookShelf() {
		bookCollection = new ArrayList<>();
	}

	public void addBook(Book book) {
		bookCollection.add(book);
	}

	public String toString() {
		String total = "\n";
		Iterator<Book> i = bookCollection.iterator();
		if (i.hasNext()) {
			Book b = (Book) i.next();
			total = total + b.toString();
		}

		return total;
	}

}