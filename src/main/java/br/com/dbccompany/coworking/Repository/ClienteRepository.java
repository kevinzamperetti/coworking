package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Cliente findByCpf( String cpf );
//    Cliente findByContato( String contato );
}
