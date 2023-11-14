package hcmute.springbootdemo.Service;

import java.util.List;
import java.util.Optional;

import hcmute.springbootdemo.Entity.Brand;

public interface IBrandService {

	void delete(Brand entity);

	void deleteById(Integer id);

	long count();

	Optional<Brand> findById(Integer id);

	List<Brand> findAll();

	<S extends Brand> S save(S entity);

}
