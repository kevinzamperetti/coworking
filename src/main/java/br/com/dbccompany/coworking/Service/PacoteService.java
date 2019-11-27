package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.EspacoXPacote;
import br.com.dbccompany.coworking.Entity.Pacote;
import br.com.dbccompany.coworking.Repository.EspacoXPacoteRepository;
import br.com.dbccompany.coworking.Repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Transactional( rollbackFor = Exception.class )
    public Pacote salvar(Pacote pacote ) {
        return pacoteRepository.save( pacote );
    }

    @Transactional( rollbackFor = Exception.class )
    public Pacote editar( Integer id, Pacote pacote ){
        pacote.setId( id );
        return pacoteRepository.save( pacote );
    }

    public List<Pacote> todosPacotes() {
        return (List<Pacote>) pacoteRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

}
