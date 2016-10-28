package bitcamp.java89.ems;

public class Book {
  // 인스턴스 변수
  String name;
  String subject;
  String publisher;
  String author;
  String year;
  int price;
  int pages;
  boolean cd;

  public Book() {

  }
  public Book(String name, String subject, String year) {
    this.name = name;
    this.subject = subject;
    this.year = year;
  }


}
