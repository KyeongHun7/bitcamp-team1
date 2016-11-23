package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.StudentDao;
import bitcamp.java89.ems.server.vo.Student;


public class StudentDeleteController implements Command {
  private StudentDao studentDao;
  

  public StudentDeleteController() {
    studentDao = StudentDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!studentDao.existUserId(paramMap.get("userid"))) {
      out.println("해당 아이디의 학생이 없습니다.");
      return;
    }
    
    studentDao.delete(paramMap.get("userid"));
    out.printf("%s 학생 정보를 삭제하였습니다.\n", paramMap.get("userid"));
  }
}




