package StudentInformation;

public class StudentRegistrationRecord extends StudentStageRecord {
    private String postcode;
    private String firstLineOfAddress;
    private boolean studentContract;

    public StudentRegistrationRecord(String postcode, String firstLineOfAddress, boolean studentContract, StudentRecord studentRecord) {
        super(studentRecord);
        this.postcode = postcode;
        this.firstLineOfAddress = firstLineOfAddress;
        this.studentContract = studentContract;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getFirstLineOfAddress() {
        return firstLineOfAddress;
    }

    public boolean isStudentContract() {
        return studentContract;
    }
}
