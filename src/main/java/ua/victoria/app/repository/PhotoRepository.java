package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
	@Query("SELECT p FROM Photo p WHERE p.tags LIKE '%:tag%' ")
	List<Photo> findPhotoByTag(@Param("tag") String tag);

}
