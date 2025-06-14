package az.nokia.nokia.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RunTimeException.class)
    public String runTimeException(RunTimeException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
