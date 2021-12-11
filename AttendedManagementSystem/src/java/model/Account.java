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
public class Account {
    private String username;
    private String password;
    private String displayName;
    private Role RoleID;
}
