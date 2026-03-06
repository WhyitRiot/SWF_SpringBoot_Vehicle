package mil.army.moda.vehicle.operator;

import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    private OperatorRepository repository;
    public OperatorService(OperatorRepository repository){
        this.repository = repository;
    }
    public Operator getOperator(Long id){
        return repository.getReferenceById(id);
    }
    public Operator saveOperator(Operator operator){
        return repository.save(operator);
    }
}
