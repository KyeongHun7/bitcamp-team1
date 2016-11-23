package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Book implements Serializable{

  private static final long serialVersionUID = 1L;
  
  
  protected String name;
  protected String subject;
  protected String publisher;
  protected String author;
  protected String year;
  protected String price;
  protected String pages;
  protected boolean cd;

  public Book() {

  }
  public Book(String name, String subject, String year) {
    this.name = name;
    this.subject = subject;
    this.year = year;
  }
  
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getYear() {
    return year;
  }
  public void setYear(String year) {
    this.year = year;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  public String getPages() {
    return pages;
  }
  public void setPages(String pages) {
    this.pages = pages;
  }
  public boolean isCd() {
    return cd;
  }
  public void setCd(boolean cd) {
    this.cd = cd;
  }
  
  
  @Override
  public String toString() {
    return "Book [name=" + name + ", subject=" + subject + ", publisher=" + publisher + ", author=" + author + ", year="
        + year + ", price=" + price + ", pages=" + pages + ", cd=" + cd + "]";
  }
  
  


}
