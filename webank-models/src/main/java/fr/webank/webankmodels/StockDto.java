package fr.webank.webankmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Ayda Najjar.
 */

@Data
@Builder
@ToString
public class StockDto {
    private String stockId;
    private String stockDescription;
}
