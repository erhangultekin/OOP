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
public class UnderGraduate extends Student {

        private String track;

        public UnderGraduate() {
        }

        public UnderGraduate(String track) {
            this.track = track;
        }

        public UnderGraduate(int studentID, String Name, String Surname, String track) {
            super(studentID, Name, Surname);
            this.track = track;
        }
        UnderGraduate(UnderGraduate copy){
            Name=copy.Name;
            studentID=copy.studentID;
            Surname=copy.Surname;
            
        }
        @Override
        public String toString() {
            return String.format("Name : %s ; Surname : %s ; Student ID : %s ; Track : %s  " ,getName(),getSurname(),getStudentID(),track);
        }

        public String getTrack() {
            return track;
        }

        public void setTrack(String track) {
            this.track = track;
        }

    }
