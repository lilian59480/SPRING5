package com.spring.demo.controller.api;

import com.spring.demo.dto.SchedulesDto;
import com.spring.demo.dto.TeacherDto;
import com.spring.demo.dto.TeachersDto;
import com.spring.demo.service.ScheduleService;
import com.spring.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Teacher controller
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Controller()
public class TeacherApiController extends AbstractApiController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("/teachers")
    @ResponseBody()
    public TeachersDto getTeachers() {
        return teacherService.findAll();
    }

    @RequestMapping("/teachers/{teacherId}")
    @ResponseBody()
    public TeacherDto getTeacherById(@PathVariable int teacherId) {
        return teacherService.findById(teacherId);
    }

    @RequestMapping(value = "/teachers/{teacherId}/schedules")
    @ResponseBody
    public SchedulesDto getSchedule(@PathVariable int teacherId) {
        return scheduleService.getTeacherSchedule(teacherId);
    }

}
