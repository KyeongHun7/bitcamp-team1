// 모든 예외 처리를 service() 에서 수행한다.
// => doXxx() 메서드에서 예외처리 코드를 작성할 필요가 없다.
// => 단점 : 각각의 명령어 마다 섬세하게 예외를 다룰 수 없다.
// 따라서 예외를 중아에서 처리할 지 개별적으로 처리할 지,
// 아니면 섞을 지 개발자가 선택하면 된다.
package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Book;


public class BookDao {
  static BookDao obj;
  private String filename = "book-v1.7.data";
  
 
  private ArrayList<Book> list;

  private BookDao() {
  
    this.doLoad();
    
  }
  
  public static BookDao getInstance() {
    if (obj == null) {
      obj = new BookDao();
    }
    return obj;
  }


  

  @SuppressWarnings("unchecked")
  private void doLoad() {
    FileInputStream in = null;
    ObjectInputStream in2 = null;

    try {
      in = new FileInputStream(this.filename);
      in2 = new ObjectInputStream(in);
      list = (ArrayList<Book>)in2.readObject();
    } catch (EOFException e) {
     
    } catch(Exception e) {
      System.out.println("교재 데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
    } finally {
      try {
        in2.close();
        in.close();
      } catch (Exception e) {

      }
    }
  }
  
  synchronized public void save() throws Exception{
    FileOutputStream out = new FileOutputStream(this.filename);
    ObjectOutputStream out2 = new ObjectOutputStream(out);

    out2.writeObject(list);
    
    out2.close();
    out.close();
  }

  
  public boolean exsistName(String name) {
    for (Book book : list) {
      if (book.getName().toLowerCase().equals(name.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
  
  
  //예) add?name=자바&subject=java&publisher=남경훈&author=asd&year=123&price=123&pages=123&cd=y
    

  public ArrayList<Book> getList() {
    return this.list;
  }

  // view?name
  public ArrayList<Book> getListByName(String name) {
    ArrayList<Book> results = new ArrayList<>();
   
    for(Book book : list) {
      if (book.getName().equals(name)) {
        results.add(book);
      } 
    }
    return results;
  }

  synchronized public void insert(Book book) {
    list.add(book);
    try {this.save();} catch(Exception e) {}
  }

  synchronized public void delete(String name) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        return;
      }
    }
    try {this.save();} catch(Exception e) {}
  }

  
  synchronized public void update(Book book) {

    for (int i = 0; i < list.size(); i++ ) {
      if (list.get(i).getName().toLowerCase().equals(book.getName())) {
        list.set(i, book);
      }
    }
    try {this.save();} catch(Exception e) {}
  }

  

}

// 예외 처리를 사용하면 프로그램 실행중에 오류가 발생했을때 시스템을 멈추지 않고
// 프로그램을 계속 실행한다.
