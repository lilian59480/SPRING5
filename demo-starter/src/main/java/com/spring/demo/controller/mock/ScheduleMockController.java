package com.spring.demo.controller.mock;

import com.spring.demo.dto.ScheduleDto;
import com.spring.demo.dto.SchedulesDto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Mock for schedules controller
 *
 * Act as an external service
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Controller
@RequestMapping(value = "/mock")
public class ScheduleMockController {

    private static final Map<Integer, List<ScheduleDto>> SCHEDULES = new HashMap<Integer, List<ScheduleDto>>() {
        {
            this.put(1, Arrays.asList(
                    new ScheduleDto(LocalDate.now(), LocalTime.of(8, 0), LocalTime.of(10, 0), "S005"),
                    new ScheduleDto(LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(12, 0), "S301")));
            this.put(2, Arrays.asList(
                    new ScheduleDto(LocalDate.now(), LocalTime.of(8, 0), LocalTime.of(12, 0), "S201")));
        }
    };

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    @ResponseBody
    public SchedulesDto getTeacherSchedule(@RequestParam int teacherId) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {

        }

        List<ScheduleDto> scheduleDTOs = SCHEDULES.get(teacherId);
        return new SchedulesDto(scheduleDTOs == null ? new ArrayList<>() : scheduleDTOs);
    }
}
