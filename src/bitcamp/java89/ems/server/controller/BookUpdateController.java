package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.BookDao;
import bitcamp.java89.ems.server.vo.Book;

public class BookUpdateController implements Command{
  
  
  //book/update?name=자바&subject=java222222&publisher=남경훈222&author=asd22&year=12322&price=12322&pages=12322&cd=y22
  
  private BookDao bookDao;
  
  public BookUpdateController() {
    bookDao = BookDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!bookDao.exsistName(paramMap.get("name"))) {
      out.println("해당 교제를 찾지 못했습니다.");
      return;
    }
    
    Book book = new Book();
    book.setName(paramMap.get("name"));
    book.setSubject(paramMap.get("subject"));
    book.setPublisher(paramMap.get("publisher"));
    book.setAuthor(paramMap.get("author"));
    book.setYear(paramMap.get("year"));
    book.setPrice(paramMap.get("price"));
    book.setPages(paramMap.get("pages"));
    book.setCd(paramMap.get("cd").equals("y") ? true : false);
    bookDao.update(book);
    out.println("변경했습니다.");
  }
}
