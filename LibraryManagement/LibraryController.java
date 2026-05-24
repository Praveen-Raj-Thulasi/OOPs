import java.util.*;

class LibraryController{

    LibraryView view = new LibraryView();
    List<Book> books = new ArrayList<>(
        Arrays.asList(
            new Book(1, "C", false),
            new Book(2, "Java", false),
            new Book(3, "Python", true)
        )
    );

    public void start(){
        int choice = view.getMenu();

        do{
            choice = view.getMenu();

            switch(choice){

                case 1: 
                    view.displayBooks(getAllBooks());
                    break;
                
                case 2:
                    int searchId = view.getBookId();
                    Book book = searchBook(searchId);
                    view.displayBook(book);
                    break;

                case 3:
                    searchId = view.getBookId();
                    issueBook(searchId);
                    break;

                case 4:
                    searchId = view.getBookId();
                    returnBook(searchId);
                    break;

                case 5:
                    searchId = view.getBookId();
                    deleteBook(searchId);

                    break;
                
                case 6:
                    view.showMessage("You have exited the system");
                    return;

                default:
                    view.showMessage("Invalid choice");
                }

        }while(choice != 6);
        
    }

    public void addBook(Book book){
        books.add(book);
        view.showMessage(book.getBookTitle() + " book has been added");
    }

    public void deleteBook(int id){
        Book book = searchBook(id);
        if(book != null){
            books.remove(book);
            view.showMessage(book.getBookTitle() + " book has been removed");
        }
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book searchBook(int id){
        for(Book book : books){
            if(book.getBookId() == id){
                return book;
            }
        }
        view.showMessage("Book not found");
        return null;
    }

    public boolean issueBook(int id){
        Book book = searchBook(id);

        if(book != null && book.getIsIssued() != true){
            book.setIsIssued(true);
            view.showMessage(book.getBookTitle() + " book has been issued");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean returnBook(int id){
        Book book = searchBook(id);

        if(book != null && book.getIsIssued() == true){
            book.setIsIssued(false);
            view.showMessage(book.getBookTitle() + " book has been returned");
            return true;
        }
        else{
            return false;
        }
    }


}