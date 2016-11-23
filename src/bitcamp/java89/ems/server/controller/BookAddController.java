package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.BookDao;
import bitcamp.java89.ems.server.vo.Book;

public class BookAddController implements Command {
    private BookDao bookDao;
    
    public BookAddController() {
      bookDao = BookDao.getInstance();
  }
    
  // add?name=자바&subject=java&publisher=남경훈&author=asd&year=123&price=123&pages=123&cd=y
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (bookDao.exsistName(paramMap.get("name"))) {
      out.print("같은 이메일이 존재합니다. 저장하지 못했습니다.");
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

    bookDao.insert(book);
    try {bookDao.save();} catch(Exception e) {}
    out.println("등록 하였습니다.");
  }
}
