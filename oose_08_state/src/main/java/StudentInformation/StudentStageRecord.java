package StudentInformation;

public class StudentStageRecord {

    private StudentRecord studentRecord;

    StudentStageRecord(StudentRecord studentRecord){
        this.studentRecord = studentRecord;
    }

    public StudentRecord getStudent() {
        return studentRecord;
    }
}
