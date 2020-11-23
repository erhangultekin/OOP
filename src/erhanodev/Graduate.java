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
public class Graduate extends Student {

        String subject;
        String advisor;

        public Graduate() {
        }

        public Graduate(String subject, String advisor) {
            this.subject = subject;
            this.advisor = advisor;
        }

        public Graduate(int studentID, String Name, String Surname) {
            super(studentID, Name, Surname);
        }
        
        Graduate(Graduate copy){
            Name=copy.Name;
            studentID=copy.studentID;
            Surname=copy.Surname;
            advisor=copy.advisor;
            
            
        }

        @Override
        public String toString() {
            return  String.format("Name : %s ; Surname : %s ; Student ID : %s ; Subject : %s ; Advisor : %s ",getName(),getSurname(),getStudentID(),subject,advisor);
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getAdvisor() {
            return advisor;
        }

        public void setAdvisor(String advisor) {
            this.advisor = advisor;
        }

        public Graduate(int studentID, String Name,String Surname,String subject,String advisor ) {
            super(studentID, Name, Surname);
            this.subject = subject;
            this.advisor = advisor;
            
        
        }
    }