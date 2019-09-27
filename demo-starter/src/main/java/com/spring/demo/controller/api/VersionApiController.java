package com.spring.demo.controller.api;

import java.text.MessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Return the version of the Api
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Controller
public class VersionApiController extends AbstractApiController {

    @Autowired
    private Environment env;

    @RequestMapping("/version")
    @ResponseBody()
    public String getVersion() {
        String version = env.getProperty("application.version", "undefined");

        return MessageFormat.format("Version {0} - Demo Application", version);
    }

}
