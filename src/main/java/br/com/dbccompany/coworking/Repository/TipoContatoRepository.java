package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.SaldoCliente;
import br.com.dbccompany.coworking.Entity.TipoContato;
import org.springframework.data.repository.CrudRepository;

public interface TipoContatoRepository extends CrudRepository<TipoContato, Integer> {

}
