package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.TypeTransactionDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017
 */
public interface ITransactionTypeService {
	
	List<TypeTransactionDto> getAll();
	
	Optional<TypeTransactionDto> getTypeTransacById(String id);
	
	TypeTransactionDto create(TypeTransactionDto typeTransactionDto);
	
	void update(String id, TypeTransactionDto typeTransactionDto);
	
}
