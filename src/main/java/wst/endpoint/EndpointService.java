package wst.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wst.database.PeopleRepository;
import wst.database.entities.People;
import wst.generated.*;

import javax.jws.WebService;
import javax.xml.ws.Holder;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "wst.generated.DB",
        targetNamespace = "http://new.webservice.namespace", name = "DB"
)
@Service("db")
public class EndpointService implements DB {
    @Autowired
    private PeopleRepository peopleRepository;
    private String wolf = "https://memepedia.ru/wp-content/uploads/2020/02/volk-s-palcem-u-viska-1-350x270.gif";

    @Override
    public void find(Person fields, Holder<List<String>> find, Holder<Integer> total) throws FindFault_Exception {
        try {
            List<People> byName = peopleRepository.findPeopleByNameAndAgeAndPatronymic(
                    fields.getName(),
                    fields.getSurname(),
                    fields.getPatronymic(),
                    fields.getAge() != null ? fields.getAge().getValue() : null,
                    fields.getWeight() != null ? fields.getWeight().getValue() : null);
            total.value = byName.size();
            find.value = byName.stream()
                    .map(People::toString)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindFault_Exception(wolf);
        }
    }

    @Override
    public int delete(int personId) throws DeleteFault {
        try {
            peopleRepository.deleteById(personId);
        } catch (Exception e) {
            throw new DeleteFault(wolf);
        }
        return 0;
    }

    @Override
    public int insert(Person person) throws InsertFault {
        People save;
        try {
            People people = new People();
            people.setWeight(person.getWeight().getValue());
            people.setAge(person.getAge().getValue());
            people.setSurname(person.getSurname());
            people.setName(person.getName());
            people.setPatronymic(person.getPatronymic());
            if (people.getId() != null &&
                    peopleRepository.findById(people.getId()).isPresent())
                throw new Exception();
            save = peopleRepository.save(people);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InsertFault(wolf);
        }
        return save.getId();
    }

    @Override
    public int update(Person person) throws UpdateFault {
        try {
            People people = new People();
            people.setId(person.getId());
            people.setWeight(person.getWeight().getValue());
            people.setAge(person.getAge().getValue());
            people.setSurname(person.getSurname());
            people.setName(person.getName());
            people.setPatronymic(person.getPatronymic());
            if (!peopleRepository.findById(person.getId()).isPresent())
                throw new Exception();
            peopleRepository.save(people);
        } catch (Exception e) {
            throw new UpdateFault(wolf);
        }
        return 0;
    }
}
