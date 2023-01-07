package com.shanghai.wu.james.personstatistic.service;

import com.shanghai.wu.james.personstatistic.model.PersonStat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonService {
    private static Map<String, PersonStat> personStatMap = new ConcurrentHashMap<>();

    public void updatePersonStat(PersonStat personStat) {
        personStatMap.put(personStat.getEid(), personStat);
    }

    public List<PersonStat> listPersonStat() {
        return new ArrayList<>(personStatMap.values());
    }
}
