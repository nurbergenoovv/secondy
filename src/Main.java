public class Main {
    public static void main(String[] args) {
        try {
            Duken<Kitap> duken = new Duken<>();

            duken.addBook(new FictionBook("Abay Zholy", "Muhtar Auezov", "123-ABC"));
            duken.addBook(new NonFictionBook("Koshpendiler", "Iliyas Esenberlin", "456-DEF"));

            System.out.println("Avialable books: ");
            duken.listAvailableBooks();

            duken.borrowBoook("123-ABC");
            System.out.println("Алынған кейінгі бар books: ");
            duken.listAvailableBooks();

            duken.returnBook("111-ABC");
            System.out.println("Қайтарғаннан кейінгі бар books: ");
            duken.listAvailableBooks();

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
