package State;

import StudentInformation.StudentRecord;

public interface State {

    public void setState(StudentRecord studentRecord);
    public StudentStateType getState();
}
