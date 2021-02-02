package com.zoo.cryptozoology.zoodemo.repository;

import com.zoo.cryptozoology.zoodemo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Animal, Long> {
}
