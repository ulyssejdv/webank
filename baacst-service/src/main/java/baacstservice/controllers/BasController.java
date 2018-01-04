package baacstservice.controllers;

import baacstservice.services.BasService;
import baacstservice.services.PdfHdfsService;
import fr.webank.webankmodels.BasDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
@Log
@RestController
@RequestMapping(path = "/")
public class BasController {

    @Autowired
    private BasService basService;

    @Autowired
    private PdfHdfsService pdfHdfsService;

    /**
     * Return the list of bank account statement metadata for the given customer
     */
    @GetMapping("customer/{customerId}")
    public ResponseEntity<BasDto> getBasListForCustomer(@PathVariable Long customerId) {
        return null;
    }

    /**
     * Return the given bank account statement metadata
     */
    @GetMapping(value = "{basId}")
    public ResponseEntity<BasDto> getBas(@PathVariable Long basId) {

        final Optional<BasDto> dtoOpt = basService.getBas(basId);

        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Return the true physical bank account statement pdf
     */
    @GetMapping("/pdf/{basId}/customer/{customerId}")
    public ResponseEntity<?> getBasPdf(@PathVariable Long basId, @PathVariable Long customerId) {

        final Optional<BasDto> dtoOpt = basService.getBas(basId);

        BasDto basDto = (dtoOpt.isPresent()) ? dtoOpt.get() : null;

        byte[] contents = null;

        if (basDto != null) {
            contents = pdfHdfsService.getPdf(basDto, customerId);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = basDto.getFileName();
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        if (contents == null) {
            return new ResponseEntity<>("No PDF can be returned", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
}
