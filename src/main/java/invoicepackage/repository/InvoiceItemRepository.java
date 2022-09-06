package invoicepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import invoicepackage.model.*;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {

}
