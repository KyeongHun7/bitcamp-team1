package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.BookDao;
import bitcamp.java89.ems.server.vo.Book;

public class BookViewController implements Command {
  private BookDao bookDao;
  
  
  public BookViewController() {
    bookDao =  BookDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Book> list = bookDao.getListByName(paramMap.get("name"));
    for (Book book : list) {
      out.printf("교재 제목 : %s\n", book.getName());
      out.printf("과정 : %s\n", book.getSubject());
      out.printf("출판사 : %s\n", book.getPublisher());
      out.printf("저자 : %s\n", book.getAuthor());
      out.printf("발행일 : %s\n", book.getYear());
      out.printf("교재 가격 : %s\n", book.getPrice());
      out.printf("교재 페이지수 : %s\n", book.getPages());
      out.printf("cd유/무 : %b\n", book.isCd());
      out.println("-----------------------------------------");
    }
  }
}
