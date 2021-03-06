package model;

public class Book {
	
	private String title;
	private Integer pages;
	private Genre genre;
	private Author author;
	private Boolean available = true;
	
	public Book() {
		
	}
	
	public Book(String title, Integer pages, Genre genre, Author author) {
		this.title = title;
		this.pages = pages;
		this.genre = genre;
		this.author = author;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genrer) {
		this.genre = genrer;
	}

	public Author getAuthor() {
		return author;
	}
	
	public String getAuthorName() {
		return author.getName();
	}
	
	public String getGenreName() {
		return genre.getName();
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", pages=" + pages + ", genrer=" + genre.getName() + ", author=" + author.getName() + ", available=" + available + "]";
	}
		
}
