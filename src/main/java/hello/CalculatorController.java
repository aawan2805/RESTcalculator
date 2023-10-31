package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private static String history = "";

    // Get add
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String sum(@RequestParam(value = "op1", defaultValue = "0") Double op1, @RequestParam(value = "op2", defaultValue = "0") Double op2) {
        double op1_d=Double.parseDouble(String.valueOf(op1));
        double op2_d=Double.parseDouble(String.valueOf(op2));
        String result = op1+" + "+op2+" = "+String.valueOf(op1_d+op2_d);
        history = history + result + "<br>";
        return result;
    }
    // Get minus
    @RequestMapping(value="/minus", method=RequestMethod.GET)
    public String minus(@RequestParam(value = "op1", defaultValue = "0") Double op1, @RequestParam(value = "op2", defaultValue = "0") Double op2) {
        double op1_d=Double.parseDouble(String.valueOf(op1));
        double op2_d=Double.parseDouble(String.valueOf(op2));
        String result = op1+" - "+op2+" = "+String.valueOf(op1_d-op2_d);
        history = history + result + "<br>";
        return result;
    }
    // Get product
    @RequestMapping(value="/product", method=RequestMethod.GET)
    public String product(@RequestParam(value = "op1", defaultValue = "0") Double op1, @RequestParam(value = "op2", defaultValue = "0") Double op2) {
        double op1_d=Double.parseDouble(String.valueOf(op1));
        double op2_d=Double.parseDouble(String.valueOf(op2));
        String result = op1+" x "+op2+" = "+String.valueOf(op1_d*op2_d);
        history = history + result + "<br>";
        return result;
    }
    // Get division
    @RequestMapping(value="/divide", method=RequestMethod.GET)
    public String divide(@RequestParam(value = "op1", defaultValue = "0") Double op1, @RequestParam(value = "op2", defaultValue = "0") Double op2) {
        double op1_d=Double.parseDouble(String.valueOf(op1));
        double op2_d=Double.parseDouble(String.valueOf(op2));
        String result;
        if(op2_d == 0) {
            result = "Infinity";
        } else {
            result =  String.valueOf(op1_d / op2_d);
        }
        String aux = op1 + " / " + op2 + " = " + result + "<br>";
        history = history + aux;
        return op1 + " / " + op2 + " = " + result;
    }
    // Get history.
    @RequestMapping(value="/history", method=RequestMethod.GET)
    public String history() {
        return history;
    }
    // Clear history.
    @RequestMapping(value="/clear", method=RequestMethod.GET)
    public String clearHistory() {
        history = "";
        return "history cleared";
    }
}
