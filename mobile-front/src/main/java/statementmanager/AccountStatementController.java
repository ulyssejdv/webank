package statementmanager;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by boubacar on 30/11/2017.
 */
@Log
@Controller
public class AccountStatementController {

@Autowired
    private AccountStatementService pdfService;

//http://localhost:8001/mobile-front/releve/pdf/1

    @GetMapping("releve/pdf/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementPDF(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyPDF(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }

//route : http://localhost:8001/mobile-front/releve/infos/1

    @GetMapping("releve/infos/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementJSON(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyJsonDocumnt(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/JSON"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }
}
