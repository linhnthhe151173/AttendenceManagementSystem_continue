package model;

import java.sql.Time;
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
public class TimeSlot {
    private int TimeSlotID;
    private Time TimeSlotStart;
    private Time TimeSlotEnd;
}
