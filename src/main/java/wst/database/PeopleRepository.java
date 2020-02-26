package wst.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wst.database.entities.People;

import java.util.List;

public interface PeopleRepository extends CrudRepository<People, Integer> {

    @Query("SELECT p " +
            "FROM People p " +
            "WHERE (:name is null or p.name = :name) " +
            "and (:surname is null  or p.surname = :surname) " +
            "and (:patronymic is null  or p.patronymic = :patronymic)" +
            "and (:age is null  or p.age = :age) " +
            "and (:weight is null  or p.weight = :weight) "

    )
    List<People> findPeopleByNameAndAgeAndPatronymic(
            String name,
            String surname,
            String patronymic,
            Integer age,
            Integer weight);
}
