package com.shanghai.wu.james.personstatistic.controller;

import com.shanghai.wu.james.personstatistic.model.PersonStat;
import com.shanghai.wu.james.personstatistic.service.PersonService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {
    @Resource
    private PersonService personService;

    @RequestMapping(value = "/person-stat/update", method = RequestMethod.POST)
    public PersonStat update(@RequestBody PersonStat personStat) {
        personService.updatePersonStat(personStat);
        return personStat;
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        List<PersonStat> personStats = personService.listPersonStat();
        ModelAndView mv = new ModelAndView();
        mv.addObject("personStats", personStats);
        mv.setViewName("list.html");
        return mv;
    }

}
