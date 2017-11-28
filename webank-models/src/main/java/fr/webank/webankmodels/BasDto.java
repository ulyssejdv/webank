package fr.webank.webankmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ulysse on 28/11/2017.
 */
@Data
@ToString
@Builder
public class BasDto {

    private Long id;

    private String fileName;

    // it is a timestamp
    private Long createdAt;
}
