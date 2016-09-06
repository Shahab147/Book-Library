package com.ahm.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String fileName = null;
	static Book b = new Book();
	static BookShelf lib = new BookShelf();
	static Scanner in = new Scanner(System.in);
	static Boolean isRunning = true;

	public static void main(String[] args) {
		while (isRunning) {
			System.out.println("\nEnter 0 to get BookShelf." + "\nEnter 1 for save and quit"
					+ "\nEnter 2 for list all books in book shelf." + "\nEnter 3 for add book to book shelf");
			int answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("Enter the file name to load");
				loadShelf(in.next());
				break;

			case 1:
				saveAndQuit();
				break;

			case 2:
				System.out.println(lib.toString());
				break;

			case 3:
				addBook();
				break;

			/*case 4:
				displayRack();
				break;
			}*/
		}
		System.exit(0);
		/*for(int i = 0; true; i++) {
            System.out.println("Hello");
            break;
        }*/
	}}

	/*private static void displayRack() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ; i++) {
			
		}
		
	}*/

	private static void addBook() {
		String title;
		String author;
		String genre;
		int rating;
		int noOfPages;

		System.out.println("\nEnter title:");
		title = in.next();

		System.out.println("\nEnter Author");
		author = in.next();

		System.out.println("\nEnter Genre");
		genre = in.next();

		System.out.println("\nEnter Rating");
		rating = in.nextInt();

		System.out.println("\nEnter NoOfPages");
		noOfPages = in.nextInt();

		Book b = new Book();
		lib.addBook(b);

	}

	private static void saveAndQuit() {
		System.out.println("Enter file name");
		fileName = in.next() + " .ser";
		isRunning = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void loadShelf(String name) {
		FileInputStream fis = null;// FileInputStream obtains input bytes from a
									// file in a file system
		ObjectInputStream ois = null;// ObjectInputStream deserializes primitive
										// data and objects previously written
										// using an ObjectOutputStream
		File file = new File(name + " .ser");
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				lib = (BookShelf) ois.readObject();
				fis.close();
				ois.close();
			} /*
				 * catch (FileNotFoundException e) { // TODO Auto-generated
				 * catch block e.printStackTrace(); }
				 */ catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("\nThe file does'nt exists.");
		}

	}

}
