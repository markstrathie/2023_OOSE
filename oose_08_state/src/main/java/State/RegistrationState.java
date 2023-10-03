package State;

import StudentInformation.StudentRecord;

public class RegistrationState implements State{
    public void setState(StudentRecord studentRecord){
        if(studentRecord.getStudentRegistrationRecord() != null){
            studentRecord.setState(new FinancialState());
        }
    }

    @Override
    public StudentStateType getState() {
        return StudentStateType.REGISTRATION;
    }
}
