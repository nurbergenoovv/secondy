import java.util.List;

public interface DukenOperations<T> {
    void addBook(T book);
    void listAvailableBooks();
    void listBorrowedBooks();
    T borrowBoook(String isbn) throws BookNotFoundException;
    void returnBook(String isbn) throws BookNotFoundException;
}
