package mil.army.moda.vehicle.operator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    private OperatorService service;
    public OperatorController(OperatorService service){
        this.service = service;
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Operator saveOperator(@RequestBody Operator operator){
        return service.saveOperator(operator);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Operator getOperator(@PathVariable Long id){
        return service.getOperator(id);
    }
}
