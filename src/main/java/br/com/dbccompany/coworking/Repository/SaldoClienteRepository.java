package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Entity.SaldoCliente;
import org.springframework.data.repository.CrudRepository;

public interface SaldoClienteRepository extends CrudRepository<SaldoCliente, Integer> {

}
