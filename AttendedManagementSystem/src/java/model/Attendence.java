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
public class Attendence {
    private int AttendenceID;
    private Student StudentID;
    private Schedule ScheduleID;
    private Date AttendenceDate;
    private boolean Present;
}
