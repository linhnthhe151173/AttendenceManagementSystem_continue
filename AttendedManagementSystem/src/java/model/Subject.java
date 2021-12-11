package model;

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
public class Subject {
    private int SubjectID;
    private String SubjectCode;
    private int TotalSlot;
    private Semester SemesterID;
    private String SubjectName;
}
