public class Library{
  private Book[] bookList;
  private int currentNumberOfUniqueBooks;

  public Library(int maxBooks){
    bookList = new Book[maxBooks];
  }

  public void addBook(Book givenBook){
    for(int i = 0; i < bookList.length; i++){
      if(bookList[i] == null){
        bookList[i] = givenBook;
        break;
      }
    }
  }

  public void whichBooks(){
    for(int i = 0; i < bookList.length; i++){
      if(bookList[i] != null){
        System.out.println(bookList[i].getTitle());
      }
    }
  }

  public void whichAuthors(){
    for(int i = 0; i < bookList.length; i++){
      if(bookList[i] != null){
        System.out.println(bookList[i].getAuthor());
      }
    }
  }

  public void returnBook(Book givenBook){
    for(int i = 0; i < bookList.length; i++){
      if(bookList[i] == null){
        bookList[i] = givenBook;
        System.out.println("Returned " + givenBook);
        break;
      }
    }
  }

  public void borrowBook(Book givenBook){
    for(int i = 0; i < bookList.length; i++){
      if(bookList[i] == givenBook){
        bookList[i] = null;
        System.out.println("Borrowed " + givenBook);
        break;
        // print message if book not available
      }
    }
  }

  public static void main(String[] args){
    System.out.println("Starting my new library\n");
    //1. Create library
    Library l= new Library(100);

    //2. Populate library
    //Add 'Oscar Wilde' as a new author
    Author a1 = new Author("Oscar Wilde", 1889);
    //Add three items of 'The Importance of Being Earnest' to the library
    Book b1 = new Book("The Importance of Being Earnest", a1, 3);
    l.addBook(b1);
    //Add two items of 'The Picture of Dorian Gray' to the library
    Book b2 = new Book("The Picture of Dorian Gray", a1, 2);
    l.addBook(b2);
    //Add 'Charles Dickens' as a new author
    Author a2 = new Author("Charles Dickens", 1812);
    //Add five items of 'The Picture of Dorian Gray' to the library

    Book b3 = new Book("Oliver Twist", a2, 3);
    l.addBook(b3);

    //3. Explore library
    l.whichBooks();
    l.whichAuthors();

    //4. Interact with the library
    //Borrow Oliver Twist
    l.borrowBook(b3);

    //Return Oliver Twist
    l.returnBook(b3);

    //Borrow more than available
    l.borrowBook(b2);
    l.borrowBook(b2);
    l.borrowBook(b2);
  }
}
