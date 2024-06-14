/*
* Names: Deepika Parthasarathy
* netID: dparthas
* G#: 01365740
* Lecture section: 
* Lab section:
*/

public class StudentGradesBook {
    //int i is for the for loops
    private int i;

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
       //code
        setStudentName(name);
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
    public void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
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
    public double unweightedReadingsScore(){
        //count is for the number of grades in readings list
        int count = 0;
        //sum is to find the sum all the grades past the first 15 grades
        double sum = 0;
        //if statement is for if the array contains more than 15 grades
        if(readings.length >= 16){
            for(i = 15; i < readings.length; i++){
                sum += readings[i];
                count++;
                return sum / count;
            }
        }
        else{
            return 100.0;
        }
            
    }

    //rest of the unweighted scores
    public double unweightedLabsScore(){
        int count = 0;
        int sum = 0;
        for(i = 0; i < labs.length; i++){
            sum += labs.length[i];
            count++; 
        }
        return sum / count;
    }
    public double unweightedExercisesScore(){
        int count = 0;
        int sum = 0;
        for(i = 0; i < exercises.length; i++){
            sum += exercises.length[i];
            count++; 
        }
        return sum / count;
    }
    
    public double unweightedProjectsScore(){
        int count = 0;
        int sum = 0;
        for(i = 0; i < projects.length; i++){
            sum += projects.length[i];
            count++; 
        }
        return sum / count;
    
    }

    //finals grading
    public boolean finalReplacesMidterm(){
        if(finalExam < midterm){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean finalIsPassing(){
        if(finalExam >= 60.0){
            return true;
        }
        else{
            return false;
        }
    }

    //total score calcuation
    public double totalScore(){
        int result = 0;
        result += participation * participationWeight;
        result += unweightedReadingsScore() * readingsWeight;
        result += unweightedLabsScore() * labsWeight;
        result += unweightedExercisesScore() * exercisesWeight;
        result += unweightedProjectsScore() * projectsWeight;

        //Note: this is to check whether or not the final replaces the midterm when the final is greater than the midterm. 
        if(finalReplacesMidterm){
            result += finalExam * finalExamWeight;
        }
        else{
            result += midterm * midtermWeight;
            result += finalExam * finalExamWeight;
        }

        
    }

    //letter grading
    public String letterGrade(){
        if(!finalIsPassing()){
            return "F";
        }
        if(totalScore() >= 98 && totalCore() <= 100){
            return "A+";
        }
        else if(totalScore() >= 92 && totalCore() < 98){
            return "A";
        }
        else if(totalScore() >= 90 && totalCore() < 92){
            return "A-";
        }
        else if(totalScore() >= 88 && totalCore() <=90){
            return "B+";
        }
        else if(totalScore() >= 82 && totalCore() < 88){
            return "B";
        }
        else if(totalScore() >= 80 && totalCore() < 82){
            return "B-";
        }
        else if(totalScore() >= 78 && totalCore() < 80){
            return "C+";
        }
        else if(totalScore() >= 72 && totalCore() < 78){
            return "C";
        }
        else if(totalScore() >= 70 && totalCore() < 72){
            return "C-";
        }
        else if(totalScore() >= 60 && totalCore() < 70){
            return "D";
        }
        else{
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
