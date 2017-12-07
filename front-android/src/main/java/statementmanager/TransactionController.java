package statementmanager;

import fr.webank.webankmodels.TransactionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * Created by RubenEdery on 05/12/2017.
 */

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {


    @RequestMapping(path = "/gettransactionsbyaccount/{id}", method = RequestMethod.GET)
    public ResponseEntity<TransactionDto[]> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") long id) {
        TransactionDto[] transactionDto = RestManagement.getResponseTransaction(
                "transaction/gettransactionsbyaccount/", id);
        return !(transactionDto == null) ?
                new ResponseEntity<>(transactionDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
