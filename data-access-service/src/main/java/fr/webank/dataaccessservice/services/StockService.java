package fr.webank.dataaccessservice.services;


import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<StockDto> getAllStocks() {
        //
        return stockRepository.findAll()
                .stream()
                .map(
                        stock -> StockDto.builder()
                        .stockId(stock.getStockId())
                        .stockDescription(stock.getStockDescription())
                        .build()
                )
                .collect(Collectors.toList());
    }

}
