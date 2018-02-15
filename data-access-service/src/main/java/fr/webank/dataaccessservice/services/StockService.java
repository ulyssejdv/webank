package fr.webank.dataaccessservice.services;


import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Ayda Najjar.
 */

@Service
public class StockService {

    private final StockRepository StockRepository;

    // constructor
    // @Autowired : dependency injection
    @Autowired
    public StockService(StockRepository StockRepository) {
        this.StockRepository = StockRepository;
    }
       // get list stock from data base
    public Page<StockDto> getAllStocks(Integer page, Integer size) {
        // create instance of pageRequest with page and size param
        Pageable pageable = new PageRequest(page, size);
        //
        Page<StockDto> listStocks = StockRepository.findAll(pageable)
                // map stock information to a new stockdto object
                .map(
                        // builder: create a new instance stockdto
                        // -> the mapping
                        stock -> StockDto.builder()
                        .stockId(stock.getStockId())
                        .stockDescription(stock.getStockDescription())
                         // build() : finalize the creation of new instance
                        .build()
                );
        // return the list of stocks
        return listStocks;
    }

    public Page<StockDto> getStocksByIdOrDescription(String search, Integer page, Integer size) {
        // create instance of pageRequest with page and size param
        Pageable pageable = new PageRequest(page, size);
        //
        Page<StockDto> listStocks = StockRepository.FindByIdOrDescription(search, pageable)
                // map stock information to a new stockdto object
                .map(
                        // builder: create a new instance stockdto
                        // -> the mapping
                        stock -> StockDto.builder()
                                .stockId(stock.getStockId())
                                .stockDescription(stock.getStockDescription())
                                // build() : finalize the creation of new instance
                                .build()
                );
        // return the list of stocks
        return listStocks;
    }

}
