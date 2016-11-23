package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.BookDao;

public class BookDeleteController implements Command{
  private BookDao bookDao;
  
  public BookDeleteController() {
    bookDao = bookDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!bookDao.exsistName(paramMap.get("name"))) {
      out.println("해당 교제가 없습니다.");
      return;
    }
    
    bookDao.delete(paramMap.get("name"));
    out.println("삭제하였습니다.");
  }
}
