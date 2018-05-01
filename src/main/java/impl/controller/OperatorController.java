package impl.controller;

import impl.entity.Operator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/operator")
public class OperatorController extends UserController {
    @GetMapping(path = "/create")
    public @ResponseBody
    Operator createOperator(@RequestParam String name, @RequestParam String password, @RequestParam String description) {
        return null;
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    Operator getOperator(@RequestParam int clientId) {
        return null;
    }
}
