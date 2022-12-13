package am.itspace.onlinechesstournamentcommon.util;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
@RequiredArgsConstructor
public class BindingResultUtil {

    public static StringBuilder check(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            stringBuilder.append(error.getDefaultMessage()).append("\n");
        }
        return ResponseEntity.badRequest().body(stringBuilder).getBody();
    }
}
