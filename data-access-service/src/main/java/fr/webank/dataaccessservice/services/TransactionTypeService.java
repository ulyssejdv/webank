package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.TransactionType;
import fr.webank.dataaccessservice.repositories.TransactionTypeRepository;
import fr.webank.webankmodels.TypeTransactionDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 23/11/2017.
 */
@Service
public class TransactionTypeService implements ITransactionTypeService {
	
	private final TransactionTypeRepository transactionTypeRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Autowired
	public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
		this.transactionTypeRepository = transactionTypeRepository;
	}
	
	
	
	@Override
	public List<TypeTransactionDto> getAll() {
		return transactionTypeRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, TypeTransactionDto.class)
					   )
					   .collect(Collectors.toList());	}
	
	@Override
	public Optional<TypeTransactionDto> getTypeTransacById(String id) {
		TransactionType userEntity = transactionTypeRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
					   Optional.of(
							   mapper.map(userEntity, TypeTransactionDto.class)
					   )
					   : Optional.empty();	}
	
	@Override
	public TypeTransactionDto create(TypeTransactionDto typeTransactionDto) {
		TransactionType transactionEntity = transactionTypeRepository.save(mapper.map(transactionTypeRepository,TransactionType.class));
		return mapper.map(transactionEntity, TypeTransactionDto.class);
	}
	
	@Override
	public void update(String id, TypeTransactionDto typeTransactionDto) {
		
	}
}
