package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>{

	
}
