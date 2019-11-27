package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Pacote;
import br.com.dbccompany.coworking.Entity.Pagamento;
import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

}
