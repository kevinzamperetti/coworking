package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Entity.EspacoXPacote;
import br.com.dbccompany.coworking.Entity.Pacote;
import br.com.dbccompany.coworking.Repository.EspacoRepository;
import br.com.dbccompany.coworking.Repository.EspacoXPacoteRepository;
import br.com.dbccompany.coworking.Repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspacoXPacoteService {

    @Autowired
    private EspacoXPacoteRepository espacoXPacoteRepository;

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private EspacoRepository espacoRepository;

    @Transactional( rollbackFor = Exception.class )
    public EspacoXPacote salvar(EspacoXPacote espacoXPacote ) {

        Pacote pacote = pacoteRepository.findById( espacoXPacote.getIdPacoteEspaco().getId() ).get();
        espacoXPacote.setIdPacoteEspaco( pacote );

        Espaco espaco = espacoRepository.findById( espacoXPacote.getIdEspaco().getId() ).get();
        espacoXPacote.setIdEspaco( espaco );

        Double valorCobrar = definirValorCobrarContrato( espacoXPacote, espaco.getValor() );

        return espacoXPacoteRepository.save( espacoXPacote );
    }

    @Transactional( rollbackFor = Exception.class )
    public EspacoXPacote editar( Integer id, EspacoXPacote espacoXPacote ){
        espacoXPacote.setId( id );
        return espacoXPacoteRepository.save( espacoXPacote );
    }

    public List<EspacoXPacote> todosEspacosXPacotes() {
        return (List<EspacoXPacote>) espacoXPacoteRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

    private Double definirValorCobrarContrato( EspacoXPacote espacoXPacote, Double valorEspaco ) {
        if ( espacoXPacote.getTipoContratacao().toString().equals("MINUTO") ) {
            return valorEspaco / 1440;
        } else if ( espacoXPacote.getTipoContratacao().toString().equals("HORA") ) {
            return valorEspaco / 24;
        } else if ( espacoXPacote.getTipoContratacao().toString().equals("TURNO") ) {
            return valorEspaco / ( 24 / 5 );
        } else if ( espacoXPacote.getTipoContratacao().toString().equals("DIARIA") ) {
            return valorEspaco * 1;
        } else if ( espacoXPacote.getTipoContratacao().toString().equals("SEMANA") ) {
            return valorEspaco / 4;
        } else if ( espacoXPacote.getTipoContratacao().toString().equals("MES") ) {
            return valorEspaco * 30;
        } else {
            return 0.0;
        }
    }
}
