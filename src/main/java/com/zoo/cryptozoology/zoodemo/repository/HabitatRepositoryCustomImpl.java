package com.zoo.cryptozoology.zoodemo.repository;

import com.zoo.cryptozoology.zoodemo.Habitat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class HabitatRepositoryCustomImpl implements HabitatRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Habitat findByType(String type) {

//        Query query = entityManager.createNativeQuery("select * from Habitat h where h.type like ?",Habitat.class);
//        query.setParameter(1,type);
//        return (Habitat) query.getResultList().get(0);
        return new Habitat("forest","walkinggggg");

    }
}
