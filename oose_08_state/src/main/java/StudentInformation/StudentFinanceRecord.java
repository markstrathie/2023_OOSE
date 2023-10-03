package StudentInformation;

public class StudentFinanceRecord extends StudentStageRecord {

    private StudentRecord studentRecord;
    private String howToPay;

    public StudentFinanceRecord(StudentRecord studentRecord, String howToPay) {
        super(studentRecord);
        this.howToPay = howToPay;
    }

    public String getHowToPay() {
        return howToPay;
    }
}
