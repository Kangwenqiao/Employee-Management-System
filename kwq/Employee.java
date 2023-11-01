package ncwu.kwq;

import java.util.HashSet;
import java.util.Set;

public class Employee {
 private int ID;
 private String name;
 private int age;
 private String address;

 public Employee(int ID,String name,int  age,String address){
  this.ID=ID;
  this.name=name;
  this.age=age;
  this.address=address;
 }

 public void setID(int ID) {
  this.ID = ID;
 }

 public int getID() {
  return ID;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 public void setAge(int age) {
  this.age = age;
 }

 public int getAge() {
  return age;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getAddress() {
  return address;
 }

 @Override
 public String toString() {
  return "Employee{" +
          "ID=" + ID +
          ", name='" + name + '\'' +
          ", age=" + age +
          ", address='" + address + '\'' +
          '}';
 }

}
