package fr.webank.webankmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * Created by ulysse on 09/11/2017.
 */
@Data
@Builder
@ToString
public class UserDto {
    @Pattern(regexp = "[0-9]{1,}")
    private String id;
    private String lastName;
    private String firstName;
}