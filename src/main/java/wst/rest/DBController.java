package wst.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wst.database.PeopleService;
import wst.database.entities.People;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DBController {
    private final PeopleService peopleService;

    public DBController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<People> find(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "weight", required = false) Integer weight
    ) throws Exception {
        return peopleService.find(name, surname, patronymic, age, weight);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean delete(
            @RequestParam(name = "id") Long id
    ) throws Exception {
        return peopleService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean update(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "weight", required = false) Integer weight
    ) throws Exception {
        peopleService.update(id, name, surname, patronymic, age, weight);
        return true;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Long insert(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "weight", required = false) Integer weight
    ) throws Exception {
        return peopleService.update(null, name, surname, patronymic, age, weight);
    }


}
