import java.util.*;

public class Duken<T extends Kitap> implements DukenOperations<T> {
    private Map<String, T> availableBooks;
    private Map<String, T> takenBooks;

    public Duken() {
        this.availableBooks = new HashMap<>();
        this.takenBooks = new HashMap<>();
    }

    @Override
    public void addBook(T book) {
        availableBooks.put(book.getIsbn(), book);
    }

    @Override
    public void listAvailableBooks() {
        availableBooks.forEach((k, v) -> {
            System.out.println(v.toString());
        });
    }
    @Override
    public void listBorrowedBooks() {
        takenBooks.forEach((k, v) -> {
            System.out.println(v.toString());
        });
    }

    @Override
    public T borrowBoook(String isbn) throws BookNotFoundException {
        if (!availableBooks.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
        T book = availableBooks.remove(isbn);
        takenBooks.put(isbn, book);
        return book;
    }

    @Override
    public void returnBook(String isbn) throws BookNotFoundException {
        if (!takenBooks.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " was not  borrowed.");
        }
        availableBooks.put(isbn, takenBooks.get(isbn));
        takenBooks.remove(isbn);
    }

    public Map<String, T> getTakenBooks() {
        return takenBooks;
    }
}
