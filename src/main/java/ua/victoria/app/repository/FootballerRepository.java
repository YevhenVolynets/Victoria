package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Footballer;
@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer>{

}
