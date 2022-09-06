package invoicepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import invoicepackage.model.*;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
