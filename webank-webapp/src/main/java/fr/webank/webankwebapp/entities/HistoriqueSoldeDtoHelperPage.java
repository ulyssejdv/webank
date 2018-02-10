package fr.webank.webankwebapp.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.webank.webankmodels.HistoriqueSoldeDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class HistoriqueSoldeDtoHelperPage extends PageImpl<HistoriqueSoldeDto> {

    @JsonCreator
    // Note: I don't need a sort, so I'm not including one here.
    // It shouldn't be too hard to add it in tho.
    public HistoriqueSoldeDtoHelperPage(@JsonProperty("content") List<HistoriqueSoldeDto> content,
                      @JsonProperty("number") int number,
                      @JsonProperty("size") int size,
                      @JsonProperty("totalElements") Long totalElements) {
        super(content, new PageRequest(number, size), totalElements);
    }
}
