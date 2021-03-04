package sit.int204.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practice.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
