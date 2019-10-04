package com.spring.demo.controller.html;

import com.spring.demo.dto.TeacherDto;
import com.spring.demo.service.TeacherService;
import com.spring.demo.validator.TeacherValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Teacher controller
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Controller
public class TeacherHtmlController extends AbstractHtmlController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherValidator teacherValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(this.teacherValidator);
    }

    @RequestMapping("/teachers")
    public String teachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll().getTeachers());
        return "teachers";
    }

    @RequestMapping("/teachers/create")
    public String initCreateTeacher(Model model) {
        if (!model.containsAttribute("teacher")) {
            model.addAttribute("teacher", new TeacherDto());
        }
        model.addAttribute("action", "create");
        return "teacher-update";
    }

    @PostMapping(value = "/teachers/create")
    public String createTeacher(Model model, @Valid TeacherDto teacher, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teacher", result);
            redirectAttributes.addFlashAttribute("teacher", teacher);
            return "redirect:/teachers/create";
        }

        this.teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/teachers/{teacherId}")
    public String initUpdateTeacher(Model model, @PathVariable int teacherId) {
        if (!model.containsAttribute("teacher")) {
            model.addAttribute("teacher", this.teacherService.findById(teacherId));
        }

        model.addAttribute("action", "update");
        return "teacher-update";
    }

    @PostMapping(value = "/teachers/{teacherId}")
    public String updateTeacher(Model model, @PathVariable int teacherId, @Valid TeacherDto teacher, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teacher", result);
            redirectAttributes.addFlashAttribute("teacher", teacher);
            return "redirect:/teachers/" + teacherId;
        }

        this.teacherService.save(teacher);
        return "redirect:/teachers";
    }
}
