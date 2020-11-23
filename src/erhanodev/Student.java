/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erhanodev;

/**
 *
 * @author DELL
 */
public class Student {
        
        int studentID;
        String Name;
        String Surname;

        public Student() {
        }

        public Student(int studentID, String Name, String Surname) {
            this.studentID = studentID;
            this.Name = Name;
            this.Surname = Surname;
            
        }
        
        Student (Student copy){
            Name=copy.Name;
            studentID=copy.studentID;
            Surname=copy.Surname;        
        }

        public int getStudentID() {
            return studentID;
        }

        public void setStudentID(int studentID) {
            this.studentID = studentID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getSurname() {
            return Surname;
        }

        public void setSurname(String Surname) {
            this.Surname = Surname;
        }

        @Override
        public String toString() {
            return "Student{" + "studentID=" + studentID + ", Name=" + Name + ", Surname=" + Surname + '}';
        }

    }
