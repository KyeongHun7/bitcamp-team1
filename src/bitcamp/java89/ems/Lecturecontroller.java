// 주제: 사용자 정의 타입의 인스턴스 - 응용 III
// => 메서드를 이용하여 객체를 생성한다.

package bitcamp.java89.ems;
import java.util.Scanner;

public class Lecturecontroller {

  private Lecture[] lectures = new Lecture[100];
  private int length = 0;
  private Scanner keyscan;

  public Lecturecontroller(Scanner keyscan){
    this.keyscan = keyscan;
  }

  public void service(){
    loop:
    while (true){
      System.out.println("------------------------------");
      System.out.print("강의관리>");

      String command = keyscan.nextLine().toLowerCase();

      switch (command) {
        case "add": this.doAdd(); break;
        case "list": this.doList(); break;
        case "view": this.doView(); break;
        case "delete": this.doDelete(); break;
        case "update": this.doUpdate(); break;
        case "main":
          break loop;
          default:
          System.out.println("지원하지않는 명령어입니다.");

      }
    }
  }

  private void doList(){
    Lecture lecture = null;
    for(int i = 0; i < this.length; i++){
      lecture = this.lectures[i];
      System.out.printf("%s, %s, %s, %s, %d, %d, %d, %d \n",
      lecture.name,
      lecture.teacher,
      lecture.book,
      lecture.time,
      lecture.cost,
      lecture.sta,
      lecture.fin,
      lecture.code);
  }
}
  private void doAdd(){
    while (length < this.lectures.length){
      Lecture lecture = new Lecture();

      System.out.print("강의이름(예:김건우) : ");
      lecture.name = this.keyscan.nextLine();
      System.out.print("강사(예:엄진영) : ");
      lecture.teacher = this.keyscan.nextLine();
      System.out.print("교재(예:자바프로그래밍) : ");
      lecture.book = this.keyscan.nextLine();
      System.out.print("강의시간(예:60분) : ");
      lecture.time = this.keyscan.nextLine();
      System.out.print("강의비용(예:120000) : ");
      lecture.cost =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의시작날짜(예:161011) : ");
      lecture.sta =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의종료날짜(예:170328) : ");
      lecture.fin =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의코드(예:123486) : ");
      lecture.code =Integer.parseInt(this.keyscan.nextLine());


      this.lectures[length++] = lecture;
      System.out.print("계속입력하시겠습니까?(y/n)? ");
      if(!this.keyscan.nextLine().equals("y"))
      break;
    }
  }
  private void doView(){
  System.out.print("조회할 강의는?");
  String name = this.keyscan.nextLine().toLowerCase();
  for(int i = 0; i < this.length; i++){
    if (this.lectures[i].name.toLowerCase().equals(name)){
      System.out.printf("강의이름 : %s\n", this.lectures[i].name);
      System.out.printf("강사 : %s\n", this.lectures[i].teacher);
      System.out.printf("교재 : %s\n", this.lectures[i].book);
      System.out.printf("강의시간 : %s\n", this.lectures[i].time);
      System.out.printf("강의비용 : %d\n", this.lectures[i].cost);
      System.out.printf("강의시작날짜 : %d\n", this.lectures[i].sta);
      System.out.printf("강의종료날짜 : %d\n", this.lectures[i].fin);
      System.out.printf("강의코드 : %d\n", this.lectures[i].code);
      break;
      }
    }
  }
  private void doDelete() {
  System.out.print("삭제할 강의는? ");
  String name = this.keyscan.nextLine().toLowerCase();

  for (int i = 0; i < this.length; i++) {
    if (this.lectures[i].name.toLowerCase().equals(name)) {
      for (int x = i + 1; x < this.length; x++, i++) {
        this.lectures[i] = this.lectures[x];
      }
      this.lectures[--length] = null;

      System.out.printf("%s 강의를 삭제하였습니다.\n", name);
      return; // 함수 실행을 종료한다.
    }
  }
  System.out.printf("%s 학생이 없습니다.\n", name);
}
private void doUpdate() {
  System.out.print("변경할 강의는?");
  String name = this.keyscan.nextLine().toLowerCase();

  for(int i = 0; i < this.length; i++){
    if (this.lectures[i].name.toLowerCase().equals(name)){
      Lecture lec = new Lecture();
      System.out.print("강의이름(예:김건우) : ");
      lec.name = this.keyscan.nextLine();
      System.out.print("강사(예:엄진영) : ");
      lec.teacher = this.keyscan.nextLine();
      System.out.print("교재(예:자바프로그래밍) : ");
      lec.book = this.keyscan.nextLine();
      System.out.print("강의시간(예:60분) : ");
      lec.time = this.keyscan.nextLine();
      System.out.print("강의비용(예:120000) : ");
      lec.cost =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의시작날짜(예:161011) : ");
      lec.sta =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의종료날짜(예:170328) : ");
      lec.fin =Integer.parseInt(this.keyscan.nextLine());
      System.out.print("강의코드(예:123486) : ");
      lec.code =Integer.parseInt(this.keyscan.nextLine());

      System.out.print("저장하시겠습니까?(y/n)? ");
      if(this.keyscan.nextLine().equals("y")){
      lectures[i] = lec;
      System.out.print("저장하였습니다.\n");
      return;
    } else{
      System.out.print("취소하였습니다.\n");
      return;

    }
      }
     System.out.printf("%s강의가 없습니다.\n", name);
     return;
    }
  }
}


/*
#









*/
