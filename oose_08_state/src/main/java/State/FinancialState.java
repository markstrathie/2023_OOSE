package State;

import StudentInformation.StudentRecord;

public class FinancialState implements State{
    public void setState(StudentRecord studentRecord){
        if(studentRecord.getStudentFinanceRecord().getHowToPay() == "SAAS"){
            studentRecord.setState(new ActiveState());
        } else {
            studentRecord.setState(new EnterPaymentState());
        }
    }
    @Override
    public StudentStateType getState() {
        return StudentStateType.FINANCIAL;
    }
}
