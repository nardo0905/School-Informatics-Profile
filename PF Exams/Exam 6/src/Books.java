import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

abstract class Book implements Comparable<Book> {

	private String genre;
	private int pages, count;

	public Book() {
		genre = "";
		pages = 0;
		count = 0;
	}

	public Book(String genre, int pages) {
		this.genre = genre;
		this.pages = pages;
		count = 0;
	}

	public String getGenre() {
		return genre;
	}

	public boolean setGenre(String genre) {
		if (this.genre != genre) {
			this.genre = genre;
			return true;
		}
		return false;
	}

	public int getPages() {
		return pages;
	}

	public boolean setPages(int pages) {
		if (this.pages != pages) {
			this.pages = pages;
			return true;
		}
		return false;
	}

	public int getCount() {
		return count;
	}

	public void incCount() {
		count++;
	}

	public String toString() {
		return String.format("count: %d, genre: %s, pages: %d", this.count, this.genre, this.pages);
	}

	public abstract int getPriority();

	public int compareTo(Book b) {

		if (this.getPriority() > b.getPriority()) {
			return -1;
		} else if (this.getPriority() < b.getPriority()) {
			return 1;
		} else if (this.getPriority() == b.getPriority()) {

			if (!this.genre.equals(b.genre)) {
				return b.genre.compareTo(this.genre) * -1;
			} else {
				return (this.pages > b.getPages()) ? 1 : -1;
			}

		}

		return 0;

	}

}

class ChildLiterature extends Book {

	public ChildLiterature() {
		super();
	}

	public ChildLiterature(String genre, int pages) {
		super(genre, pages);
	}

	@Override
	public int getPriority() {
		return 3;
	}

	public String toString() {
		return super.toString() + " - for children";
	}

}

class TeenageLiterature extends Book {

	public TeenageLiterature() {
		super();
	}

	public TeenageLiterature(String genre, int pages) {
		super(genre, pages);
	}

	@Override
	public int getPriority() {
		return 2;
	}

	public String toString() {
		return super.toString() + " - for teenagers";
	}

}

class AdultLiterature extends Book {

	public AdultLiterature() {
		super();
	}

	public AdultLiterature(String genre, int pages) {
		super(genre, pages);
	}

	@Override
	public int getPriority() {
		return 1;
	}

	public String toString() {
		return super.toString() + " - for adults";
	}

}

public class Books {

	public static void main(String[] args) {

		Scanner sc = null;

		ArrayList<Book> books = new ArrayList<>();

		try {
			sc = new Scanner(new File("books.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		while (sc.hasNextLine()) {

			String[] data = sc.nextLine().toLowerCase().split("\\+");

			if (data.length < 3)
				continue;

			String genre = data[1].toUpperCase();
			int pages = Integer.parseInt(data[2]);
			Book b = null;

			switch (data[0].charAt(0)) {

			case 'c':
				b = new ChildLiterature(genre, pages);
				break;
			case 't':
				b = new TeenageLiterature(genre, pages);
				break;
			case 'a':
				b = new AdultLiterature(genre, pages);
				break;
			default:
				continue;

			}

			b.incCount();

			boolean exists = false;

			for (Book book : books) {

				if (book.getPriority() == b.getPriority() && book.getGenre().equals(b.getGenre())
						&& book.getPages() == b.getPages()) {
					book.incCount();
					exists = true;
				}

			}

			if (!exists)
				books.add(b);

		}

		sc.close();

		Collections.sort(books);

		books.forEach((Book b) -> System.out.println(b.toString()));

	}

}
