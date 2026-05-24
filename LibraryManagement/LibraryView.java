import java.util.*;

class LibraryView{

    Scanner sc = new Scanner(System.in);

    public int getMenu(){

        System.out.println("---Menu---");
        System.out.println("1. Display Book");
        System.out.println("2. Search Book");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Delete Book");
        System.out.println("6. Exit");

        return sc.nextInt();
    }

    public void displayBook(Book book){
        System.out.println("Id : " + book.getBookId());
        System.out.println("Book Title : " + book.getBookTitle());
        System.out.println("Is Issued : " + book.getIsIssued());
    }

    public void displayBooks(List<Book> books){
        
        if(!books.isEmpty()){
            System.out.println("No books found");
            return;
        }

        for(Book book : books){
            System.out.println(book);
        }

    }

    public int getBookId(){
        System.out.println("Enter book id : ");
        return sc.nextInt();
    }

    public void showMessage(String msg){
        System.out.println(msg);
    }
}
