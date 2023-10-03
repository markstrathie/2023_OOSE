package State;

import StudentInformation.StudentRecord;

public class ApplicationState implements State{
    @Override
    public void setState(StudentRecord studentRecord) {
        if (studentRecord.getStudentID() != "" && studentRecord.getFirstName() != "" && studentRecord.getEmail().contains("@")){
            studentRecord.setState(new RegistrationState());
        }
    }

    @Override
    public StudentStateType getState() {
        return StudentStateType.APPLICATION;
    }
}
