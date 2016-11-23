// 모든 예외 처리를 service() 에서 수행한다.
// => doXxx() 메서드에서 예외처리 코드를 작성할 필요가 없다.
// => 단점 : 각각의 명령어 마다 섬세하게 예외를 다룰 수 없다.
// 따라서 예외를 중아에서 처리할 지 개별적으로 처리할 지,
// 아니면 섞을 지 개발자가 선택하면 된다.
package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.BookDao;
import bitcamp.java89.ems.server.vo.Book;


public class BookListController implements Command {
  private BookDao bookDao;



  public BookListController() {

    
    bookDao = BookDao.getInstance();
  }
  

  

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Book> list = bookDao.getList();
    for (Book book : list) {

      out.printf("%s,%s,%s,%s,%s,%s,%s,%b\n", book.getName(),
          book.getSubject(),
          book.getPublisher(),
          book.getAuthor(),
          book.getYear(),
          book.getPrice(),
          book.getPages(),
          ((book.isCd())?"yes" : "no"));
    
    }
  }
}