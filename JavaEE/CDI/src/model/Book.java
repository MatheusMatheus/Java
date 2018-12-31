package model;

public class Book {
	private String isbn;
	private String title;
	private Float price;
	private String description;
	public Book(String title, Float price, String description) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
