package invoicepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import invoicepackage.model.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
