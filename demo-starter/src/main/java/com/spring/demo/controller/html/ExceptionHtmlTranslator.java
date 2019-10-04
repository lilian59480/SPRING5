package com.spring.demo.controller.html;

import com.spring.demo.controller.api.ExceptionApiTranslator;
import com.spring.demo.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Transform Exceptions into flash messages
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@ControllerAdvice("com.spring.demo.controller.html")
public class ExceptionHtmlTranslator {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionApiTranslator.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFoundException(RedirectAttributes redirectAttributes, Exception exception) {
        LOG.error("NotFoundException", exception);
        redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
        return "redirect:/teachers";
    }
}
