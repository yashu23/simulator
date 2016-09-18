package au.com.lucky5.data;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import au.com.lucky5.data.entity.Api;

public interface ApiRepository extends CrudRepository<Api, Serializable> {
}
