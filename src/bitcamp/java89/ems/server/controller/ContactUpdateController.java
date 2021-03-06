package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactUpdateController implements Command {
  private ContactDao contactDao;
  

  public ContactUpdateController() {
    contactDao = ContactDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!contactDao.existEmail(paramMap.get("email"))) {
      out.println("해당 이메일이 없습니다.");
      return;
    }
    
    Contact contact = new Contact();
    contact.setEmail(paramMap.get("email"));
    contact.setName(paramMap.get("name"));
    contact.setPosition(paramMap.get("position"));
    contact.setTel(paramMap.get("tel"));
    
    contactDao.update(contact);
    out.println("변경 완료했습니다.");
  }
}