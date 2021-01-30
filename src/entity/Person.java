package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.platform.commons.annotation.Testable;

public class Person {
    protected static int count = 0;
    protected String name;
    protected LocalDate birthdate;
    protected String sex;
    protected String province;
    protected String city;

    public Person(String name, LocalDate birthdate, String sex, String province, String city) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.province = province;
        this.city = city;
        count++;
    }

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        count++;
    }

    public Person() {
        count++;
    }
    public Person(Person person) {
        this.set(person.name,person.birthdate,person.sex,person.province,person.city);
        count++;
    }
    public void set(String name, LocalDate birthdate, String sex, String province, String city){
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.province = province;
        this.city = city;
    }
    public void set(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    public static void howMany(){
        System.out.println("总共"+count+"�?.");
    }
    @Override
    public void finalize(){
        count = 0;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthdate, person.birthdate) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(province, person.province) &&
                Objects.equals(city, person.city);
    }

}
class Student extends Person{
    private String department;
    private String speciality; // 01,02,03,04
    private String number;  //2020,01 分别代表年级，专�?
    private String member; //1,2,3,4

    private int calculus; // 微积�?
    private int programing; //程序设计
    private int dataStruct; // 数据结构

    public static void statisGrade(List<Student> students){
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        List<Student> students4 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).speciality.equals("CS")){
                students1.add(students.get(i));
            }else if(students.get(i).speciality.equals("SE")){
                students2.add(students.get(i));
            }else if(students.get(i).speciality.equals("CE")){
                students3.add(students.get(i));
            }else if(students.get(i).speciality.equals("EI")){
                students4.add(students.get(i));
            }
        }
        students1.sort((a,b)->{
            int total = a.calculus + a.dataStruct + a.programing;
            int total2 = b.calculus + b.dataStruct + b.programing;
            return  total2 - total;
        });
        students2.sort((a,b)->{
            int total = a.calculus + a.dataStruct + a.programing;
            int total2 = b.calculus + b.dataStruct + b.programing;
            return  total2 - total;
        });
        students3.sort((a,b)->{
            int total = a.calculus + a.dataStruct + a.programing;
            int total2 = b.calculus + b.dataStruct + b.programing;
            return  total2 - total;
        });
        students4.sort((a,b)->{
            int total = a.calculus + a.dataStruct + a.programing;
            int total2 = b.calculus + b.dataStruct + b.programing;
            return  total2 - total;
        });
        System.out.println("计算机科学专业学生成绩：");
        students1.forEach((stu)->{
            System.out.println(stu);
        });
        System.out.println("软件工程专业学生成绩�?");
        students2.forEach((stu)->{
            System.out.println(stu);
        });
        System.out.println("计算机技术专业学生成绩：");
        students3.forEach((stu)->{
            System.out.println(stu);
        });
        System.out.println("电子信息学生成绩�?");
        students4.forEach((stu)->{
            System.out.println(stu);
        });
    }
    public Student(String name, LocalDate birthdate, String sex, String province, String city, String department, String speciality, String number, String member) {
        super(name, birthdate, sex, province, city);
        this.department = department;
        this.speciality = speciality;
        this.number = number;
        this.member = member;
    }

    public Student() {
    }
    public void computeNumber(){
        number = "";
        switch (member){
            case "大一": number += "2020";break;
            case "大二": number += "2019";break;
            case "大三": number += "2018";break;
            case "大四": number += "2017";break;
            default:break;
        }
        if(speciality.equals("CS")){
            number += "01";
        }else if(speciality.equals("SE")){
            number += "02";
        }else if(speciality.equals("CE")){
            number += "03";
        }else if(speciality.equals("EI")){
            number += "04";
        }
        number = String.format("%s%04d",number,count);
    }
    public static List<Student> findByName(List<Student> students,String name){
        List<Student> out = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).name.indexOf(name) != -1){
                out.add(students.get(i));
            }
        }
        return out;
    }
    public static List<Student> findByProvince(List<Student> students,String province){
        List<Student> out = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).province.equals(province)){
                out.add(students.get(i));
            }
        }
        return out;
    }
    public static List<Student> findByBirthdate(List<Student> students,LocalDate birthdate){
        List<Student> out = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).birthdate.getYear()==birthdate.getYear()){
                out.add(students.get(i));
            }
        }
        return out;
    }
    public Student(Person person, String department, String speciality, String number, String member) {
        super(person.name,person.birthdate,person.sex,person.province,person.city);
        this.department = department;
        this.speciality = speciality;
        this.number = number;
        this.member = member;
    }
    public Student(Student student){
        this(student.name,student.birthdate,student.sex,student.province,student.city,student.department,student.speciality,student.number,student.member);
    }
    public void set(String department, String speciality, String number, String member){
        this.department = department;
        this.speciality = speciality;
        this.number = number;
        this.member = member;
    }
    public static void howMany(){
        System.out.println("总共"+count+"名学�?");
    }

    @Override
    public String toString() {
        return "Student{" +
                "department='" + department + '\'' +
                ", speciality='" + speciality + '\'' +
                ", number='" + number + '\'' +
                ", member='" + member + '\'' +
                ", calculus=" + calculus +
                ", programing=" + programing +
                ", dataStruct=" + dataStruct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return number == student.number &&
                Objects.equals(department, student.department) &&
                Objects.equals(speciality, student.speciality) &&
                Objects.equals(member, student.member);
    }

}
class Friend{
    private String name;
    private String sex;
    private int phone;
    private String relationship;
}
class GoodFriend extends Person{
    private int phone;
    private String relationship;
}


