package bitcamp.java89.ems;
import java.util.Scanner;

public class EduApp {

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    BookController bookController = new BookController(keyScan);
    System.out.println("비트캠프 관리 시스템에 오신걸 환영합니다.");

    loop :
    while (true) {
      System.out.println("명령>");
      String input = keyScan.nextLine().toLowerCase();


      switch (input) {
        case "menu" :
           doMenu();
           break;
        case "go 1" : bookController.service();
        break;


        case "quit" :
         System.out.println("잘가용");
         break loop;
         default :
         System.out.println("지원하지 않는 명령어 입니다.");
       }
      }
    }
    static void doMenu() {
      System.out.println("[메뉴]");
      System.out.println("1. 교재관리");
      System.out.println("메뉴 이동은 'go 메뉴 번호'를 누르세요");
    }


  }
