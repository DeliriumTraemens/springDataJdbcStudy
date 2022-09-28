package org.mykola.springDataJdbcStudy.repo;

import org.mykola.springDataJdbcStudy.model.Owner;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, String> {

    @Modifying
    @Query("UPDATE owner SET address = :address WHERE owner_name = :ownerName")
    void updateAddress(@Param("ownerName") String ownerName, @Param("address") String address);
}
