package fr.webank.dataaccessservice.services;


import fr.webank.dataaccessservice.repositories.StockRepository;
import fr.webank.webankmodels.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<UserDto> getAllStocks() {
        // TODO Get data from repository
        return null;
    }

}
