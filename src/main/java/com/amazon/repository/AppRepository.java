package com.amazon.repository;

import com.amazon.entity.App;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {

    List<App> findByCategoria(int categoria);

}
