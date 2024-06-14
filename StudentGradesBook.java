/*
* Names: Deepika Parthasarathy
* netID: dparthas
* G#: 01365740
* Lecture section: 
* Lab section:
*/

public class StudentGradesBook {

// This global variable is not needed.
//     //int i is for the for loops
//     private int i;

    private double participation;
    private double midterm;
    private double finalExam;

    private double[] labs;
    private double[] exercises;
    private double[] projects;
    private double[] readings;

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
    /* This constructor should pass these arguments to the setters for the student name, G#, and weight array (described below), 
    and then create empty array instances (with appropriate type specifiers) for the readings, labs, exercises, and projects fields.
    Note: I'm not too sure what it means by "create empty array instances for the readings, labs, exercises, and projects fields." */
    public StudentGradesBook(String name, String gNumber, double[] weights) {
        setGNumber(gNumber);
        setWeights(weights);
        
    }

    //add methods
    public void addReading(double d){

    }
    
    public void addLab(double d){

    }
    
    public void addExercise(double d){

    }
    
    public void addProject(double d){

    }

    //Getters
    public double getParticipation(){
        return participation;
    }
    
    public double getMidterm(){
        return midterm;
    }
    
    public double getFinalExam(){
        return finalExam;
    }
    
    public String getStudentName(){
        return studentName;
    }
    
    public String getGNumber(){
        return gNumber;
    }

    //Setters
    public void setParticipation(double participation){
        this.participation = participation;
    }
    
    public void setMidterm(double midterm){
        this.midterm = midterm;
    }
    
    public void setFinalExem(double finalExam){
        this.finalExam = finalExam;
    }
    
    //EDIT: I believe you meant to write student name (Currenly produces compiler errors)
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void setGNumber(String gNumber){
        this.gNumber = gNumber;
    }
    //weight setter
    /* Assume that the weights are provided in the order given above (participation, reading, labs, exercises, projects, midterm, final), 
       that they are between 0 and 1 and sum to 1.0 (no validation necessary)*/
    public void setWeights(double[] weights){
        participationWeight = weights[0];
        readingsWeight = weights[1];
        labsWeight = weights[2];
        exercisesWeight = weights[3];
        projectsWeight = weights[4];
        midtermWeight = weights[5];
        finalExamWeight = weights[6];
    }

    //unweigthed methods

    /* Assume that scores are provided per subsection in ascending order, therefore to calculate the score for the reading category, 
    you should add together all the scores - excluding the lowest 15 - and then divide the result by the total number of scores minus 15.
    The easiest way to exclude the lowest 15 scores is to locate the right index to start including values in the calculation, 
    the scores are already sorted, from lowest to highest, 
    skip the first 15, and then add together the remaining scores starting from the 16th. 
    Note: if there are fewer than 16 items in the reading category, this method should just return 100, indicating full credit. 
    P.S. This is straight from the exercise */
    
    
    // EDIT: edited this code, was hard to understand
    public double unweightedReadingsScore() {
        if (readings.length < 16) {
            return 100.0;
        }
        double sum = 0;
        for (int i = 15; i < readings.length; i++) {
            sum += readings[i];
        }
        return sum / (readings.length - 15);
    }

    //rest of the unweighted scores
    
    /* EDIT: to reduce redundancy I just made a 
     calculateAverage method 
    
    */
    public double unweightedLabsScore() {
        return calculateAverage(labs);
    }

    public double unweightedExercisesScore() {
        return calculateAverage(exercises);
    }

    public double unweightedProjectsScore() {
        return calculateAverage(projects);
    }

    private double calculateAverage(double[] array) {
        if (array.length == 0) {
            return 100.0;
        }
        double sum = 0;
        for (double score : array) {
            sum += score;
        }
        return sum / array.length;
    }

    //finals grading
    
    /* EDIT: You don't need if-else statements because
    using the comparative operators in this case will
    return T/F.
    
    */
    public boolean finalReplacesMidterm() {
        return finalExam > midterm;
    }

    public boolean finalIsPassing() {
        return finalExam >= 60.0;
    }

    //total score calcuation
    
    public double totalScore(){
    
        /* EDIT: This method is meant to return a double
           but the variable result is int...
           
           there was also no return statement here
    
        */
        double result = 0.0;
        result += participation * participationWeight;
        result += unweightedReadingsScore() * readingsWeight;
        result += unweightedLabsScore() * labsWeight;
        result += unweightedExercisesScore() * exercisesWeight;
        result += unweightedProjectsScore() * projectsWeight;

        //Note: this is to check whether or not the final replaces the midterm when the final is greater than the midterm. 
        if(finalReplacesMidterm()){
            result += finalExam * finalExamWeight;
        }
        else{
            result += midterm * midtermWeight;
            result += finalExam * finalExamWeight;
        }

        return result;
    }

    //letter grading
    /* EDIT: You were missing parentheses which 
       caused complier errors so I rewrote this
    
    */
    public String letterGrade() {
        if (!finalIsPassing()) {
            return "F";
        }

        double score = totalScore();

        if (score >= 98.0) {
            return "A+";
        } else if (score >= 92.0) {
            return "A";
        } else if (score >= 90.0) {
            return "A-";
        } else if (score >= 88.0) {
            return "B+";
        } else if (score >= 82.0) {
            return "B";
        } else if (score >= 80.0) {
            return "B-";
        } else if (score >= 78.0) {
            return "C+";
        } else if (score >= 72.0) {
            return "C";
        } else if (score >= 70.0) {
            return "C-";
        } else if (score >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }


    @Override
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
