/*
* Names: Deepika Parthasarathy
* netID: dparthas
* G#: 01365740
* Lecture section: 
* Lab section:
*/

public class StudentGradesBook {

    private double participationWeight;
    private double readingsWeight;
    private double labsWeight;
    private double exercisesWeight;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    private String studentName;
    private String gNumber;

    // Constructor
    // need to add a new parameter (double of weighted grades?)
    public StudentGradesBook(String name, String gNumber) {
       //code
    }

    public String toString() {
        String rv = "Name: " + getStudentName() + "\n";
        rv += "G#: " + getGNumber() + "\n";
        rv += "Participation: " + getParticipation() + "\n";
        rv += "Readings: " + unweightedReadingsScore() + "\n";
        rv += "Labs: " + unweightedLabsScore() + "\n";
        rv += "Exercises: " + unweightedExercisesScore() + "\n";
        rv += "Projects: " + unweightedProjectsScore() + "\n";
        rv += "Midterm: " + getMidterm() + "\n";
        rv += "Final Exam: " + getFinalExam() + "\n";
        rv += "Total Score: " + totalScore() + "\n";
        rv += "Letter Grade: " + letterGrade() + "\n";
        return rv;
    }
    
    public static void main(String[]args){
    
    }
}
