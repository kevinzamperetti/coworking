package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Entity.ClienteXPacote;
import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Repository.ClienteRepository;
import br.com.dbccompany.coworking.Repository.ClienteXPacoteRepository;
import br.com.dbccompany.coworking.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteXPacoteService {

    @Autowired
    private ClienteXPacoteRepository clienteXPacoteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional( rollbackFor = Exception.class )
    public ClienteXPacote salvar(ClienteXPacote clienteXPacote ) {

        Cliente cliente = clienteRepository.findById( clienteXPacote.getIdCliente().getId() ).get();
        clienteXPacote.setIdCliente( cliente );

        //FALTA GRAVAR O PAGAMENTO

        return clienteXPacoteRepository.save( clienteXPacote );
    }

    @Transactional( rollbackFor = Exception.class )
    public ClienteXPacote editar( Integer id, ClienteXPacote clienteXPacote ){
        clienteXPacote.setId( id );
        return clienteXPacoteRepository.save( clienteXPacote );
    }

    public List<ClienteXPacote> todosClientesXPacotes() {
        return (List<ClienteXPacote>) clienteXPacoteRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
