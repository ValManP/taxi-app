package edu.unn.taxi.impl.controller;

import edu.unn.taxi.impl.db.OperatorRepository;
import edu.unn.taxi.impl.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/operator")
public class OperatorController extends UserController {
    @Autowired
    private OperatorRepository operatorRepository;

    @GetMapping(path = "/create")
    public @ResponseBody
    Operator createOperator(@RequestParam String name, @RequestParam String password, @RequestParam String description) {
        Operator operator = new Operator();
        operator.setName(name);
        operator.setPassword(password);

        return operatorRepository.save(operator);
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Operator getOperator(@RequestParam int operatorId) {
        return operatorRepository.findById(operatorId).orElse(null);
    }
}
