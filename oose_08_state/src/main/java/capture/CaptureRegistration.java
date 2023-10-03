package capture;

import StudentInformation.StudentRecord;
import StudentInformation.StudentRegistrationRecord;
import StudentInformation.StudentStageRecord;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureRegistration extends CaptureStage {

    protected String postCodeQuestion = "Enter your Postcode?";
    protected String firstLineQuestion = "Enter your First Line of Address?";
    protected String studentContract = "Do you agree to the StudentInformation.Student Contract?";


    public CaptureRegistration(StudentRecord studentRecord) {
        super(studentRecord);
    }

    private Matcher hasValidPostcode(String postCode){
        String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(postCode);
    }

    @Override
    HashMap<String, String> getQuestions() {
        HashMap<String, String> questions = new HashMap<String, String>();
        questions.put(postCodeQuestion,"");
        questions.put(firstLineQuestion,"");
        questions.put(studentContract,"");
        return questions;
    }

    @Override
    StudentRegistrationRecord getStudentStage(HashMap<String, String> answers) {
        StudentRegistrationRecord studentRegistration = null;
        if (hasValidPostcode(answers.get(postCodeQuestion)).find()
        && answers.get(firstLineQuestion).length() > 0
        && answers.get(studentContract).length() > 0
        && answers.get(studentContract).startsWith("Y")){
            studentRegistration = new StudentRegistrationRecord(answers.get(postCodeQuestion), answers.get(firstLineQuestion),
                    true, studentRecord);
            studentRecord.setStudentRegistrationRecord(studentRegistration);
        }
        return studentRegistration;
    }

    @Override
    public StudentRegistrationRecord stage() {
        HashMap<String, String> answers = getAnswers(getQuestions());
        return getStudentStage(answers);
    }

    public String getPostCodeQuestion() {
        return postCodeQuestion;
    }

    public String getFirstLineQuestion() {
        return firstLineQuestion;
    }

    public String getStudentContract() {
        return studentContract;
    }
}
