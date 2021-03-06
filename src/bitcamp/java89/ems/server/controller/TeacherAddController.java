package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherAddController implements Command {
  private TeacherDao teacherDao;
  
  public TeacherAddController() {
    teacherDao = TeacherDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {

    if (teacherDao.existId(paramMap.get("id"))) {
      out.println("같은 아이디가 존재합니다. 등록을 취소합니다.");
      return;
    }
  
    Teacher teacher = new Teacher();
    teacher.setId(paramMap.get("id"));
    teacher.setName(paramMap.get("name"));
    teacher.setEmail(paramMap.get("email"));
    teacher.setTel(paramMap.get("tel"));
    teacher.setMajor(paramMap.get("major"));
    teacher.setMajorLanguage(paramMap.get("majorLanguage"));
    teacher.setBook(paramMap.get("book"));
    teacher.setProjectName(paramMap.get("projectName"));
    teacher.setGitAddress(paramMap.get("gitAddress"));
    teacher.setWorkExperience(Integer.parseInt(paramMap.get("workExperience")));
    teacher.setLectureExperience(Integer.parseInt(paramMap.get("lectureExperience")));
    teacher.setAge(Integer.parseInt(paramMap.get("age")));
    teacher.setSalary(Integer.parseInt(paramMap.get("salary")));
    
    teacherDao.insert(teacher);
    out.println("등록하였습니다.");
    }
  
}
