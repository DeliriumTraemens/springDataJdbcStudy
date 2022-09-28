package org.mykola.springDataJdbcStudy.repo;

import org.mykola.springDataJdbcStudy.model.Dog;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select * from dog where name = :name")
    List<Dog> findByName(@Param("name") String dogName);

//    @Query(value = "select * from dog where name = :name", rowMapperClass= GuardDogMapper.class)
//    Optional<GuardDog> findGuardDogByName(@Param("name") String name);

}
