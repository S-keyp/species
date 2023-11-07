package com.example.species.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.species.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>  {
    Species findFirstBycommonName(String commonName);
    List<Species> findBylatinNameAllIgnoreCaseContains(String latinName);

    @Query(value = "from Species where commonName= :commonName order by commonName asc")
    List<Species> findAllByCommonName(@Param("commonName") String commonName);

    @Query(value = "from Species where commonName like %:commonName%")
    List<Species> findAllSpeciesCommonNameLike(@Param("commonName") String commonName);
}
