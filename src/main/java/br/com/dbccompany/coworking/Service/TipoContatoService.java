package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Entity.TipoContato;
import br.com.dbccompany.coworking.Repository.ContatoRepository;
import br.com.dbccompany.coworking.Repository.PagamentoRepository;
import br.com.dbccompany.coworking.Repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoContatoService {

    @Autowired
    private TipoContatoRepository tipoContatoRepository;

    @Transactional( rollbackFor = Exception.class )
    public TipoContato salvar(TipoContato tipoContato ) throws Exception {

        if ( tipoContato.getValor() == null ) {
            throw new Exception("ERRO-Faltou informar o Valor do Tipo de Contato");
        }

        return tipoContatoRepository.save( tipoContato );
    }

    @Transactional( rollbackFor = Exception.class )
    public TipoContato editar( Integer id, TipoContato tipoContato ){
        tipoContato.setId( id );
        return tipoContatoRepository.save( tipoContato );
    }

    public List<TipoContato> todosTipoContatos() {
        return (List<TipoContato>) tipoContatoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
