package model;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Linh
 */
@Getter
@Setter
@ToString
@Builder
public class Student {
    private String StudentID;
    private String StudentName;
    private String StudentImage;
    private boolean StudentGender;
    private String StudentAddress;
    private String StudentEmail;
    private String StudentPhone;
    private Date StudentDOB;
    private Semester SemesterID;
}
