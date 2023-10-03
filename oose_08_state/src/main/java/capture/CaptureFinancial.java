package capture;

import StudentInformation.StudentRecord;
import StudentInformation.StudentFinanceRecord;
import StudentInformation.StudentStageRecord;

import java.util.HashMap;

public class CaptureFinancial extends CaptureStage {

    protected String howToPay = "How will you pay?";

    public CaptureFinancial(StudentRecord studentRecord) {
        super(studentRecord);
    }

    @Override
    HashMap<String, String> getQuestions() {
        HashMap<String, String> questions = new HashMap<String, String>();
        questions.put(howToPay, "");
        return questions;
    }

    @Override
    StudentFinanceRecord getStudentStage(HashMap<String, String> answers) {
        StudentFinanceRecord studentFinance = null;
        if (answers.get(howToPay).length() > 0){
            studentFinance = new StudentFinanceRecord(studentRecord, answers.get(howToPay));
            studentRecord.setStudentFinanceRecord(studentFinance);
        }
        return studentFinance;
    }

    @Override
    public StudentFinanceRecord stage() {
        HashMap<String, String> answers = getAnswers(getQuestions());
        return getStudentStage(answers);
    }
}
