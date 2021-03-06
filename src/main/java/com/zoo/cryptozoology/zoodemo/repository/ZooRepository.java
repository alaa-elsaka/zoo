package com.zoo.cryptozoology.zoodemo.repository;

import com.zoo.cryptozoology.zoodemo.Animal;
import com.zoo.cryptozoology.zoodemo.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Animal, Long> {

    Habitat findByType(String walking);
}
