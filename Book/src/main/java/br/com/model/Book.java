package br.com.model;

public class Book {
	private String title;
	private Float price;
	private String description;
	private String number;
	
	@Override
	public String toString()
	{
	   StringBuilder string = new StringBuilder();
	   string.append("{\n\t'title' : ").append(title);
	   string.append("\n\t'price' : ").append(price);
	   string.append("\n\t'description' : ").append(description);
	   string.append("\n\t'number' : ").append(number).append("\n}");
	   
	   return string.toString();
	}

	
	public Book(String title, Float price, String description) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
