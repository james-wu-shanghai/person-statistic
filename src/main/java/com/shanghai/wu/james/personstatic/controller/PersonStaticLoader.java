package com.shanghai.wu.james.personstatic.controller;

import com.shanghai.wu.james.personstatic.model.PersonStat;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonStaticLoader {
    @RequestMapping(value = "/load-static", method = RequestMethod.POST)
    public PersonStat loadStatic(@RequestBody PersonStat personStat) {
        return personStat;
    }

}
