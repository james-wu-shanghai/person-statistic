package com.shanghai.wu.james.personstatistic.controller;

import com.shanghai.wu.james.personstatistic.model.PersonStat;
import com.shanghai.wu.james.personstatistic.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/person-stat")
public class PersonController {
    @Resource
    private PersonService personService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public PersonStat update(@RequestBody PersonStat personStat) {
        personService.updatePersonStat(personStat);
        return personStat;
    }

    @RequestMapping("list")
    public List<PersonStat> list() {
        return personService.listPersonStat();
    }

}
