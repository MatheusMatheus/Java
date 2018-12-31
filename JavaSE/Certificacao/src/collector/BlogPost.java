package collector;

public class BlogPost {
	private String title;
	private String author;
	private BlogPostType type;
	private int likes;

	public BlogPost(String title, String author, BlogPostType type, int likes) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.likes = likes;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n\nTitle: " + getTitle());
		str.append("\nAuthor: " + getAuthor());
		str.append("\nType: " + getType().name());
		str.append("\nLikes: " + getLikes());
		return str.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BlogPostType getType() {
		return type;
	}

	public void setType(BlogPostType type) {
		this.type = type;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}

class Tuple {
	private BlogPostType type;
	private String author;

	public Tuple(BlogPostType type, String author) {
		super();
		this.type = type;
		this.author = author;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n\nAuthor: " + getAuthor());
		str.append("\nType: " + getType().name());
		return super.toString();
	}

	public BlogPostType getType() {
		return type;
	}

	public void setType(BlogPostType type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
