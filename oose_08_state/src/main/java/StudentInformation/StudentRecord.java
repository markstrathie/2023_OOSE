package StudentInformation;

import State.State;
import State.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class StudentRecord {

    private String studentID;
    private String firstName;
    private String lastName;
    private String email;
    private DegreeProgramme degreeProgramme;
    private StudentRegistrationRecord studentRegistrationRecord;
    private StudentFinanceRecord studentFinanceRecord;
    protected State state = new ApplicationState();
    protected List<State> states = new ArrayList<State>();

    public StudentRecord(String studentID, String firstName, String lastName, String email, DegreeProgramme degreeProgramme) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgramme = degreeProgramme;
    }

    public void setState(State state){
        System.out.println("From " + this.state.getState() + " To " + state.getState() + " stage.");
        this.state = state;
        this.states.add(state);
        this.state.setState(this);
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DegreeProgramme getDegreeProgramme() {
        return degreeProgramme;
    }

    public String getEmail() {
        return email;
    }

    public State getState() {
        return state;
    }

    public static void main(String[] args){
        DegreeProgramme degreeProgramme = new DegreeProgramme("Software Engineer");
        StudentRecord studentRecord = new StudentRecord("2213100S", "Derek", "Somerville", "derek.somervile@glasgow.ac.uk", degreeProgramme);
        studentRecord.setState(new ApplicationState());
    }

    public StudentRegistrationRecord getStudentRegistrationRecord() {
        return studentRegistrationRecord;
    }

    public StudentFinanceRecord getStudentFinanceRecord() {
        return studentFinanceRecord;
    }

    public void setStudentRegistrationRecord(StudentRegistrationRecord studentRegistrationRecord) {
        this.studentRegistrationRecord = studentRegistrationRecord;
    }

    public void setStudentFinanceRecord(StudentFinanceRecord studentFinanceRecord) {
        this.studentFinanceRecord = studentFinanceRecord;
    }

    public List<State> getStates() {
        return states;
    }
}
