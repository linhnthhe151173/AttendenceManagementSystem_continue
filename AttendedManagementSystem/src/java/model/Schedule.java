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
public class Schedule {

    private int ScheduleID;
    private Teacher TeacherID;
    private Subject SubjectID;
    private Class ClassID;
    private Date ScheduleDate;
    private TimeSlot TimeSlotID;
}
