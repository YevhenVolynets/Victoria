package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Amplua;

@Repository
public interface AmpluaRepository extends JpaRepository<Amplua, Integer>{

}
