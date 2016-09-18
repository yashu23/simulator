package au.com.lucky5.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.com.lucky5.data.entity.RequestResponse;

@Repository
public interface RequestResponseRepository extends CrudRepository<RequestResponse, Serializable> {
	@Query("select distinct u.avc from #{#entityName} u")
	List<String> findDistinctAVC();
}
