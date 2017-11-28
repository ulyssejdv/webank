package baacstservice.controllers;

import fr.webank.webankmodels.BasDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ulysse on 28/11/2017.
 */
@RestController
public class BasController {

    /**
     * Return the list of bank account statement metadata for the given customer
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<BasDto> getBasListForCustomer(@PathVariable Long customerId) {
        return null;
    }

    /**
     * Return the given bank account statement metadata
     */
    @GetMapping(value = "/{basId}")
    public ResponseEntity<BasDto> getBas(@PathVariable Long basId) {
        return null;
    }

    /**
     * Return the true physical bank account statement pdf
     */
    @GetMapping("/pdf/{basId}")
    public ResponseEntity<byte[]> getBasPdf(@PathVariable Long basId) {
        // convert JSON to Employee
        //Employee emp = convertSomehow(json);

        // generate the file
        //PdfUtil.showHelp(emp);

        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
        byte[] contents = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }
}
