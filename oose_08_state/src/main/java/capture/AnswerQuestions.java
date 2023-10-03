package capture;

import java.util.HashMap;
import java.util.Scanner;

public class AnswerQuestions {

    private static AnswerQuestions uniqueInstance = null;

    private AnswerQuestions(){

    }

    public static AnswerQuestions getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new AnswerQuestions();
        }
        return uniqueInstance;
    }

    private Scanner userInput = new Scanner(System.in);

    public void setUserInput(Scanner userInput){
        this.userInput = userInput;
    }

    protected String getInput(String message){
        System.out.println(message);
        return userInput.nextLine();
    }

    public HashMap<String,String> getAnswer(HashMap<String, String> questions){
        for (String question : questions.keySet()){
            questions.put(question, getInput(question));
        }
        return questions;
    }

}
