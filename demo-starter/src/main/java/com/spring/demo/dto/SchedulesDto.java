package com.spring.demo.dto;

import java.util.List;

/**
 * Schedules representation
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class SchedulesDto {

    private List<ScheduleDto> schedules;

    public SchedulesDto() {
    }

    public SchedulesDto(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }
}
