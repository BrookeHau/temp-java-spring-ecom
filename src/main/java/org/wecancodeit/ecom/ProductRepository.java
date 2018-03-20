package org.wecancodeit.ecom;

import org.springframework.data.repository.CrudRepository;

//<Product, Long> implies products is an entity; therefore class must be an entity
public interface ProductRepository extends CrudRepository<Product, Long> {

}
