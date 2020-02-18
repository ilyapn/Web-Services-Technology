package wst.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wst.database.PeopleRepository;
import wst.database.entities.People;
import wst.generated.DB;
import wst.generated.Field;

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

    @Override
    public void find(Field fields, Holder<List<String>> find, Holder<Integer> total) {
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
    }
}
