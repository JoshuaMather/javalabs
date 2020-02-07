public class Book{
  private String title;
  private Author author;
  private int items;

  public Book(String givenTitle, Author givenAuthor, int givenItems){
    title = givenTitle;
    author = givenAuthor;
    items = givenItems;
  }

  public String getTitle(){
    return title;
  }

  public Author getAuthor(){
    return author;
  }

  public int getItems(){
    return items;
  }

  public void setTitle(String givenTitle){
    title = givenTitle;
  }

  public void setAuthor(Author givenAuthor){
    author = givenAuthor;
  }

  public void setItems(int givenItems){
    items = givenItems;
  }

}
