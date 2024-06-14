public class StudentGradesBook {
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

    public StudentGradesBook(String name, String gNumber, double[] weights) {
        setStudentName(name);
        setGNumber(gNumber);
        setWeights(weights);

        // Initialize arrays
        labs = new double[0];
        exercises = new double[0];
        projects = new double[0];
        readings = new double[0];
    }

    public void addReading(double d){
        double[] newReadings = new double[readings.length + 1];
        System.arraycopy(readings, 0, newReadings, 0, readings.length);
        newReadings[readings.length] = d;
        readings = newReadings;
    }

    public void addLab(double d){
        double[] newLabs = new double[labs.length + 1];
        System.arraycopy(labs, 0, newLabs, 0, labs.length);
        newLabs[labs.length] = d;
        labs = newLabs;
    }

    public void addExercise(double d){
        double[] newExercises = new double[exercises.length + 1];
        System.arraycopy(exercises, 0, newExercises, 0, exercises.length);
        newExercises[exercises.length] = d;
        exercises = newExercises;
    }

    public void addProject(double d){
        double[] newProjects = new double[projects.length + 1];
        System.arraycopy(projects, 0, newProjects, 0, projects.length);
        newProjects[projects.length] = d;
        projects = newProjects;
    }

    public void setWeights(double[] weights){
        participationWeight = weights[0];
        readingsWeight = weights[1];
        labsWeight = weights[2];
        exercisesWeight = weights[3];
        projectsWeight = weights[4];
        midtermWeight = weights[5];
        finalExamWeight = weights[6];
    }

    public double unweightedReadingsScore(){
        int count = 0;
        double sum = 0;
        if(readings.length >= 16){
            for(int i = 15; i < readings.length; i++){
                sum += readings[i];
                count++;
            }
            return sum / count;
        }
        else{
            return 100.0;
        }
    }

    public double unweightedLabsScore(){
        double sum = 0;
        for(double lab : labs){
            sum += lab;
        }
        return labs.length == 0 ? 100.0 : sum / labs.length;
    }

    public double unweightedExercisesScore(){
        double sum = 0;
        for(double exercise : exercises){
            sum += exercise;
        }
        return exercises.length == 0 ? 100.0 : sum / exercises.length;
    }

    public double unweightedProjectsScore(){
        double sum = 0;
        for(double project : projects){
            sum += project;
        }
        return projects.length == 0 ? 100.0 : sum / projects.length;
    }

    public boolean finalReplacesMidterm(){
        return finalExam > midterm;
    }

    public boolean finalIsPassing(){
        return finalExam >= 60.0;
    }

    public double totalScore(){
        double result = 0;
        result += participation * participationWeight;
        result += unweightedReadingsScore() * readingsWeight;
        result += unweightedLabsScore() * labsWeight;
        result += unweightedExercisesScore() * exercisesWeight;
        result += unweightedProjectsScore() * projectsWeight;

        if(finalReplacesMidterm()){
            result += finalExam * finalExamWeight;
        }
        else{
            result += midterm * midtermWeight;
            result += finalExam * finalExamWeight;
        }

        return result;
    }

    public String letterGrade(){
        if(!finalIsPassing()){
            return "F";
        }
        double score = totalScore();
        if(score >= 98 && score <= 100){
            return "A+";
        }
        else if(score >= 92 && score < 98){
            return "A";
        }
        else if(score >= 90 && score < 92){
            return "A-";
        }
        else if(score >= 88 && score <=90){
            return "B+";
        }
        else if(score >= 82 && score < 88){
            return "B";
        }
        else if(score >= 80 && score < 82){
            return "B-";
        }
        else if(score >= 78 && score < 80){
            return "C+";
        }
        else if(score >= 72 && score < 78){
            return "C";
        }
        else if(score >= 70 && score < 72){
            return "C-";
        }
        else if(score >= 60 && score < 70){
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
        rv += "Participation: " + participation + "\n";
        rv += "Readings: " + unweightedReadingsScore() + ", " + Arrays.toString(readings) + "\n";
        rv += "Labs: " + unweightedLabsScore() + ", " + Arrays.toString(labs) + "\n";
        rv += "Exercises: " + unweightedExercisesScore() + ", " + Arrays.toString(exercises) + "\n";
        rv += "Projects: " + unweightedProjectsScore() + ", " + Arrays.toString(projects) + "\n";
        rv += "Midterm: " + midterm + "\n";
        rv += "Final Exam: " + finalExam + "\n";
        rv += totalScore() + ", " + letterGrade() + "\n";
        return rv;
    }

    public double getParticipation() {
        return participation;
    }

    public void setParticipation(double participation) {
        this.participation = participation;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGNumber() {
        return gNumber;
    }

    public void setGNumber(String gNumber) {
        this.gNumber = gNumber;
    }
}
