package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Entity.ClienteXPacote;
import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Entity.TipoContato;
import br.com.dbccompany.coworking.Repository.ClienteRepository;
import br.com.dbccompany.coworking.Repository.ClienteXPacoteRepository;
import br.com.dbccompany.coworking.Repository.ContatoRepository;
import br.com.dbccompany.coworking.Repository.TipoContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TipoContatoRepository tipoContatoRepository;

    @Transactional( rollbackFor = Exception.class )
    public Contato salvar(Contato contato ) throws Exception {

        if ( contato.getValor() == null ) {
            throw new Exception("ERRO-Faltou informar o Valor Contato");
        }

        TipoContato tipoContato = tipoContatoRepository.findById( contato.getTipoContato().getId() ).get();
        contato.setTipoContato( tipoContato );

        Cliente cliente = clienteRepository.findById( contato.getCliente().getId() ).get();
        contato.setCliente( cliente );

        if(contato.getTipoContato() == null) {
            throw new Exception("ERRO-Tipo de Contato inválido!");
        }

        return contatoRepository.save( contato );
    }

    @Transactional( rollbackFor = Exception.class )
    public Contato editar( Integer id, Contato contato ){
        contato.setId( id );
        return contatoRepository.save( contato );
    }

    public List<Contato> todosContatos() {
        return (List<Contato>) contatoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

    public Contato buscarContatoPorValor( String valor ){
        return contatoRepository.findByValor( valor );
    }
}
