package fr.webank.dataaccessservice.services;


import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Page<StockDto> getAllStocks(Integer page, Integer size) {
        //
        Pageable pageable = new PageRequest(page, size);

        return stockRepository.findAll(pageable)
                .map(
                        stock -> StockDto.builder()
                        .stockId(stock.getStockId())
                        .stockDescription(stock.getStockDescription())
                        .build()
                );
    }

}
