package data;

import java.util.Objects;

public class Book extends Publication{
    // Pola
    private String author;
    private int pages;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Konstruktory
    public Book(String title, String author, int year, int pages, String publisher, String isbn) {
        super(year, title, publisher);
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);
    }

    public void printInfo() {
        String info = getTitle() + "; " + getAuthor() + "; " + getYear() + "; " + getPages()
                + "; " + getPublisher() + "; " + getIsbn();
        System.out.println(info);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), author, pages, isbn);
    }
}