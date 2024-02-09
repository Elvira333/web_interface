package org.openapitools.configuration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер главной страницы
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(path = "/")
    public String hello() {
        return "homePage.html";
    }
    @RequestMapping("/swagger")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}