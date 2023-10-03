package capture;

import StudentInformation.StudentRecord;
import StudentInformation.StudentStageRecord;

import java.util.HashMap;

abstract class CaptureStage {

    protected StudentRecord studentRecord;
    protected AnswerQuestions answerQuestions = AnswerQuestions.getInstance();

    CaptureStage(StudentRecord studentRecord){
        this.studentRecord = studentRecord;
    }

    abstract HashMap<String, String> getQuestions();

    protected HashMap<String, String> getAnswers(HashMap<String, String> questions){
        return answerQuestions.getAnswer(questions);
    }

    abstract StudentStageRecord getStudentStage(HashMap<String, String> answers);

    public StudentStageRecord stage(){
        HashMap<String, String> answers = getAnswers(getQuestions());
        return getStudentStage(answers);
    }
}
