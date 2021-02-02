package com.zoo.cryptozoology.zoodemo.repository;

import com.zoo.cryptozoology.zoodemo.Habitat;

public interface HabitatRepositoryCustom {
    Habitat findByType(String type);
}
