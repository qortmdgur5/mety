package com.risingcraft.mety.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Integer> {

    List<Data> findAllByUserId(int userId);
}
