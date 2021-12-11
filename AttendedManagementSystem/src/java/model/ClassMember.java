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
public class ClassMember {
    private Class ClassID;
    private Student StudentID;
    private Date DateStart;
    private Date DateEnd;
}
