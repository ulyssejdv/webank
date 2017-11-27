package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Balance;
import fr.webank.dataaccessservice.repositories.BalanceRepository;
import fr.webank.webankmodels.BalanceDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 23/11/2017.
 */
@Service
public class BalanceService implements  IBalanceService{
	
	
	private final BalanceRepository balanceRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public BalanceService(BalanceRepository balanceRepository) {
		this.balanceRepository = balanceRepository;
	}
	
	
	@Override
	public List<BalanceDto> getAll() {
		return balanceRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, BalanceDto.class)
					   )
					   .collect(Collectors.toList());	
	}
	
	
	@Override
	public Optional<BalanceDto> getBalanceById(String id) {
		Balance balance = balanceRepository.findOne(Long.parseLong(id));
		return (balance != null) ?
					   Optional.of(
							   mapper.map(balance, BalanceDto.class)
					   )
					   : Optional.empty();	}
	
	@Override
	public BalanceDto create(BalanceDto balanceDto) {
		Balance balanceEntity = balanceRepository.save(mapper.map(balanceDto,Balance.class));
		return mapper.map(balanceEntity, BalanceDto.class);	}
	
	@Override
	public void update(String id, BalanceDto balanceDto) {
		
	}
}
