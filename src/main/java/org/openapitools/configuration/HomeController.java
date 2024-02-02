package org.openapitools.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер главной страницы
 * Данный контроллер описывает ручки на главной странице
 * Тут можно добавлять кнопки, которые будут делать redirect
 * Также этот контроллер должен получать имя шаблона главной страницы
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