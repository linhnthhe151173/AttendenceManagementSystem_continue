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
public class Semester {
    private int SemesterID;
    private String SemesterName;
}
