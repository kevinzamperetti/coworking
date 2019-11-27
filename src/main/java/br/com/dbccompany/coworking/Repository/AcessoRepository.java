package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Acesso;
import org.springframework.data.repository.CrudRepository;

public interface AcessoRepository extends CrudRepository<Acesso, Integer> {

    Acesso findByIsEntrada( boolean isEntrada );
}
