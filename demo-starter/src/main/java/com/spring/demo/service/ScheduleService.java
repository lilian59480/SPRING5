package com.spring.demo.service;

import com.spring.demo.dto.SchedulesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Service that manipulate Schedules
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Service
public class ScheduleService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Cacheable(value = "schedule", key = "#teacherId")
    public SchedulesDto getTeacherSchedule(int teacherId) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(env.getProperty("webservices.schedule.url"))
                .queryParam("teacherId", Integer.toString(teacherId));

        return restTemplate.getForObject(builder.toUriString(), SchedulesDto.class);
    }
}
