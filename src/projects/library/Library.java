package projects.library;
/*

 * Library Management System
 * Classes: Library, Book, Member (with StudentMember, TeacherMember).
 * Use composition (Library HAS-A List<Book>).
 * Store books in a Map<ISBN, Book>.
 * Features: add/remove books, search by title, list members.
 */


import java.util.*;

public class Library {
    // Use composition (Library HAS-A List<Book>).
    // All the library books.
    private final ListBook libraryBooks;
    // All the library members.
    private final Map<String, Member> members;

    public Library() {
        libraryBooks = new ListBook();
        members = new HashMap<>();
        // Store books in a Map<ISBN, Book>.
        String[] data = this.getBookData();
        this.populateLibraryBooks(data);

    }

    public static void main(String[] args) {
        // Set a Library instance to avoid to use static for the Library methods.
        Library library = new Library();
        // Add a single book.
        library.libraryBooks.addBook(new Book("The Demons", "Fyodor Dostoevsky"));
        // Add a list of Books.
        Book[] newComings = new Book[]{
                new Book("Oliver Twist", "Charles Dickens"),
                new Book("The Lion", "Joseph Kessel"),
                new Book("The Old man and the Sea", "Ernest Hemingway")
        };
        library.libraryBooks.addBooksList(newComings);
        // Search by title. Returns an ISBN Array if one or more books are find.
        library.libraryBooks.searchByTitle("One");
        // Search by author. Returns an ISBN array of if one or more books are find.
        List<String> isbns = library.libraryBooks.searchByAuthor("Gabriel");
        // Remove books.
        if (!isbns.isEmpty()) {
            for (String isbn : isbns) {
                // Remove a book by its ISBN.
                // TODO Check if this book is not borrowed.
                library.libraryBooks.removeBook(isbn);
            }
        }
        // MEMBERS
        // Populate members Map.
        Map<String, Member> _members = library.getMembers();
        _members.put("bob", new TeacherMember("Bob The Indian"));
        _members.put("laura", new StudentMember("Laura Palmer"));
        // Borrow // Return book process.
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("what is your id ? ");
            String studentId = scanner.nextLine();
            if(studentId.contentEquals("exit")){break;}
            Member current = _members.get(studentId.trim());
            if (current == null) {
                System.out.println("Unknown member.");
                continue;
            }
            boolean memberInLibrary = true;
            while(memberInLibrary){
                System.out.print("Do you want to : \n- Check the library list (type 3) \n- Return a book (type 1)\n- Borrow a book (type 2)\n- Quit the library (type 0) ? ");
                int response = scanner.nextInt();
                scanner.nextLine();
                switch (response){
                    case 0: {
                        memberInLibrary = false;
                        break;
                    }
                    case 1:{
                        System.out.print("Type the isbn of the book you want to return. ");
                        String isbn = scanner.next();
                        library.returnBook(studentId , isbn);
                        break;

                    }
                    case 2:{
                        System.out.print("Type the title of the book you want to borrow. ");
                        String title = scanner.next();
                        System.out.println(title);
                        library.borrowBook(current, title);
                        break;
                    }
                    case 3:{
                        library.libraryBooks.printList();
                        break;
                    }
                    default:
                        throw new InputMismatchException("You did not type the right number");
                }



            }
           //break;
        }
        //scanner.close();

    }

    // Raw Datas (alike fetch from database or json file or whatever).
    public String[] getBookData() {
        return new String[]{
                "Madame Bovary-Gustave Flaubert",
                "1984-George Orwell",
                "To Kill a Mockingbird-Harper Lee",
                "Pride and Prejudice-Jane Austen",
                "The Great Gatsby-F. Scott Fitzgerald",
                "Moby Dick-Herman Melville",
                "War and Peace-Leo Tolstoy",
                "The Catcher in the Rye-J.D. Salinger",
                "The Hobbit-J.R.R. Tolkien",
                "Crime and Punishment-Fyodor Dostoevsky",
                "The Odyssey-Homer",
                "Brave New World-Aldous Huxley",
                "The Divine Comedy-Dante Alighieri",
                "Don Quixote-Miguel de Cervantes",
                "The Brothers Karamazov-Fyodor Dostoevsky",
                "The Picture of Dorian Gray-Oscar Wilde",
                "The Count of Monte Cristo-Alexandre Dumas",
                "Anna Karenina-Leo Tolstoy",
                "The Iliad-Homer",
                "One Hundred Years of Solitude-Gabriel García Márquez"
        };
    }

    // Parse the Raw datas then populate the ListBook library collection.
    public void populateLibraryBooks(String[] bookList) {
        for (String book : bookList) {
            String[] data = book.split("-");
            if (data[0].isEmpty() || data[1].isEmpty()) {
                throw new EmptyBookDataException("Incomplete data");
            } else {
                libraryBooks.addBook(new Book(data[0].trim(), data[1].trim()));
            }
        }
    }
    // Member actions.
    // Borrow book.
    public boolean borrowBook(Member member, String title){
        // Check if this book is already borrowed.
        if(this.isBorrowed(title)){ return false; }
        List<String> isbns = this.libraryBooks.searchByTitle(title);
        if(!isbns.isEmpty()){
            String isbn = isbns.getFirst();
            Book book = this.libraryBooks.getBook(isbn);
            boolean isBorrowed = member.borrowBook(isbn, book);
            if(isBorrowed){
                this.libraryBooks.removeBook(isbn);
                return true;
            }
        }
        else {
            System.out.println(title + " is not in the library ");
            return false;
        }
        return true;
    }
    public boolean isBorrowed(String title){
        boolean isBorrowed = false;
        for( Map.Entry<String,Member> entry:members.entrySet()){
            Member member  = entry.getValue();
            if(!member.borrowedBooks.searchByTitle(title).isEmpty()){
                System.out.println(entry.getKey() + " has borrowed " + title);
                isBorrowed = true;
                break;
            }
        }
        return isBorrowed;
    }
    // Return book.
    public boolean returnBook(String memberId, String isbn){
        Member member = members.get(memberId);
        if(member == null){
            System.out.println( memberId + " is not a member of the library");
            return false;
        }
        Book book = member.borrowedBooks.removeBook(isbn);
        if(book !=null){
          this.libraryBooks.addBook(isbn,  book);
          return true;
        };
        return false;
    }

    public Map<String, Member> getMembers() {
        return members;
    }
}

/**
 * @class Book
 * @field author
 * @field title
 */
class Book{
    private String title;
    private String author;

    /**
     * Constructs a new Book with the specified title and author.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }
}

/**
 * Manages the collection of books.
 *
 * Internally stores books in:
 * Map<ISBN, Book>
 */
class ListBook{
    /**
     * Stores books using:
     * Key   : ISBN (String)
     * Value : Book object
     */
    final Map<String, Book> listBooks = new HashMap<>();;
    /**
     * @return complete Map of books
     */
    public Map<String, Book> getListBook() {
        return listBooks;
    }
    /**
     * Retrieves a book by its ISBN.
     *
     * @param isbn Book ISBN
     * @return Book if found, otherwise null
     */
    public Book getBook(String isbn){
        Book book = this.listBooks.get(isbn);
        if(book == null){
           //  System.out.println(isbn + " was not found. Please search by title to get the right book.");
            return null;
        }
       return book;
    }
    /**
     * Removes a book from the collection using its ISBN.
     *
     * @param isbn ISBN of the book to remove
     */
    public Book removeBook(String isbn){
        Book book = this.listBooks.remove(isbn);
        if(book == null){
            System.out.println(isbn + " was not found. Please Check the ISBN or remove by title.");
            return null;
        }
        else{
            System.out.println(book.getTitle() + " has been removed");
            return book;
        }
    }

    public void addBook(Book book){
            String isbn = IsbnUtil.getIsbn();
            this.listBooks.put(isbn, book);
    }
    public void addBook(String isbn, Book book){
        this.listBooks.put(isbn, book);
    }
    public void addBooksList(Book[] books){
        for (Book book:books){
            this.addBook(book);
        }
    }
    public void printList(){
        for(Map.Entry<String,Book> book : this.listBooks.entrySet()){
            String title = book.getValue().getTitle();
            String author = book.getValue().getAuthor();
            System.out.println(book.getKey() + ": " + title +", " + author);
        }
    }
    public String printBook(Book book){
        return book.getTitle() +  ", Author: " +book.getAuthor();
    }

    public ArrayList<String> searchByTitle(String title){
       ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<String,Book> entry : this.listBooks.entrySet()){
            Book book = entry.getValue();
            if((book.getTitle().toLowerCase()).contains(title.toLowerCase())){
                System.out.println(this.printBook(book) + " - ISBN: " + entry.getKey());
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<String> searchByAuthor(String author){
        List<String> result = new ArrayList<>();
        for(Map.Entry<String,Book> entry : this.listBooks.entrySet()){
            Book book = entry.getValue();
            if((book.getAuthor().toLowerCase()).contains(author.toLowerCase())){
                System.out.println(this.printBook(book) + " - ISBN: " + entry.getKey());
                result.add(entry.getKey());
            }
        }
        return result;
    }
}



class EmptyBookDataException extends RuntimeException{
    public EmptyBookDataException(String message){
        super(message);
        System.out.println(message);
    }
}