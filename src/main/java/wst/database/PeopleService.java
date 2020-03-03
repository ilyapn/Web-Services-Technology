package wst.database;

import org.springframework.stereotype.Service;
import wst.database.entities.People;

import java.util.List;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;
    private String wolf = "https://memepedia.ru/wp-content/uploads/2020/02/volk-s-palcem-u-viska-1-350x270.gif";

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> find(
            String name,
            String surname,
            String patronymic,
            Integer age,
            Integer weight
    ) throws Exception {
        try {
            return peopleRepository.findPeopleByNameAndAgeAndPatronymic(
                    name,
                    surname,
                    patronymic,
                    age,
                    weight);
        } catch (Exception e) {
            throw new Exception(wolf);
        }
    }

    public Long update(Long id,
                       String name,
                       String surname,
                       String patronymic,
                       Integer age,
                       Integer weight) throws Exception {
        try {
            People people = new People();
            if (id != null)
                people.setId(Math.toIntExact(id));
            if (name != null)
                people.setName(name);
            if (surname != null)
                people.setSurname(surname);
            if (patronymic != null)
                people.setPatronymic(patronymic);
            if (age != null)
                people.setAge(age);
            if (weight != null)
                people.setWeight(weight);
            return Long.valueOf(peopleRepository.save(people).getId());

        } catch (Exception e) {
            throw new Exception(wolf);
        }

    }

    public Boolean delete(Long id) throws Exception {
        try {
            peopleRepository.deleteById(Math.toIntExact(id));
            return true;
        } catch (Exception e) {
            throw new Exception(wolf);
        }
    }
}
