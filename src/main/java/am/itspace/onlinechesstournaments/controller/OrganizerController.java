package am.itspace.onlinechesstournaments.controller;

import am.itspace.onlinechesstournaments.dto.RegisterOrgDto;
import am.itspace.onlinechesstournaments.exception.handler.OrganizerException;
import am.itspace.onlinechesstournaments.service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static am.itspace.onlinechesstournaments.exception.handler.ErrorCode.EMAIL_EXIST_ERROR;

@Controller
//@RequestMapping("orga")
@RequiredArgsConstructor
public class OrganizerController {

    public final OrganizerService organizerService;

    @GetMapping("/registerOrg")
    public String registerOrgPage(RegisterOrgDto registerOrgDto) {
        return "registerOrg";
    }

    @PostMapping("/registerOrg")
    public String registerOrganizer(@Valid RegisterOrgDto registerOrgDto,
                                    BindingResult bindingResult,
                                    ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError error : allErrors) {
                if (error.getField().equals("email")) {
                    modelMap.addAttribute("emailError", error.getDefaultMessage());
                }

            }
            return "registerOrg";
        }
        try {
            organizerService.registerOrg(registerOrgDto);
        } catch (OrganizerException e) {
            if (e.getCode() == EMAIL_EXIST_ERROR) {
                modelMap.addAttribute("emailError", "Email already use");
            }
        }
        modelMap.addAttribute("organizer", organizerService.findAll());
        return "registerOrg";
    }
}
