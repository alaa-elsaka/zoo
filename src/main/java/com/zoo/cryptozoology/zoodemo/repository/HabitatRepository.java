package com.zoo.cryptozoology.zoodemo.repository;

import com.zoo.cryptozoology.zoodemo.Habitat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long>, HabitatRepositoryCustom {

}
