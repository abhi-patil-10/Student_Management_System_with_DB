import java.util.ArrayList;

public class Student {
    String name;
    int roll_no;
    float marks;

Student(String name , int roll_no,float marks){
 this.name = name;
 this.roll_no = roll_no;
 this.marks = marks;
}

public Student(int int1, String string, double double1) {
    //TODO Auto-generated constructor stub
}

// getters
public int get_roll_no(){
    return roll_no;
}
public String get_name(){
    return name;
}
public float get_marks(){
    return marks;
}

public void display(){
    System.out.println("Name : "+name+" Roll Number :"+roll_no+" Marks :"+marks);
}

// setters
public void setName(String name){
    this.name = name;
}
public void setmarks(float marks){
    this.marks = marks;
}
public void setrollno(int roll_no){
    this.roll_no = roll_no;
}
   
}
