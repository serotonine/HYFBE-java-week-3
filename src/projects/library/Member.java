package projects.library;

abstract class Member{
    private String name;
    private String status;
    final ListBook borrowedBooks;
    private int maxBook;
    public Member(String name, String status){
        this.name = name;
        this.status = status;
        this.borrowedBooks = new ListBook();
    }
    // Getters.
    public String getName() {
        return this.name;
    }
    public String getStatus(){
        return this.status;
    }
    public int getMaxBook() {return this.maxBook; }
    // List Borrowed books
    public void printBorrowedBooks() {
        this.borrowedBooks.printList();
    }
    public boolean hasBook(String isbn){
        Book output = this.borrowedBooks.getBook(isbn);
        return output != null;
    }
    // Setters.
    protected void setMaxBook(int maxBook) {
        this.maxBook = maxBook;
    }
    // Book's events.
    public boolean borrowBook(String isbn, Book book){
        // TODO check if member has not this book and that is not maxBook.
        // TODO check if library has this book.
        if(this.hasBook(isbn)){
            System.out.println("This book is already in " + this.getName() + "'s borrowed books");
            return false;
        }
        if(this.borrowedBooks.getListBook().size() >= this.getMaxBook()){
            System.out.println(this.getName() + "'s Maximum borrowed books allowed is reached");
            return false;
        }
        // if all ok remove from the library and add to member.
        // library.removeBook(isbn);
        this.borrowedBooks.addBook(isbn, book);
        this.borrowedBooks.printList();
        return true;
    }
}

class StudentMember extends Member{
    public StudentMember(String name) {
        super(name, "Student");
        this.setMaxBook(5);
    }
}



class TeacherMember extends Member{
    public TeacherMember(String name) {
        super(name, "Teacher");
        this.setMaxBook(8);
    }
}
