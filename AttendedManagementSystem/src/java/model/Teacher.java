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
public class Teacher {
    private int TeacherID;
    private String TeacherName;
    private String TeacherImage;
    private boolean TeacherGender;
    private String TeacherAddress;
    private String TeacherEmail;
    private String TeacherPhone;
    private Date TeacherDOB;
}
