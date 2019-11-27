package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.ClienteXPacote;
import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Entity.Pacote;
import br.com.dbccompany.coworking.Entity.Pagamento;
import br.com.dbccompany.coworking.Repository.ClienteXPacoteRepository;
import br.com.dbccompany.coworking.Repository.ContratacaoRepository;
import br.com.dbccompany.coworking.Repository.PacoteRepository;
import br.com.dbccompany.coworking.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    @Autowired
    private ClienteXPacoteRepository clienteXPacoteRepository;

    @Transactional( rollbackFor = Exception.class )
    public Pagamento salvar(Pagamento pagamento ) {

        Contratacao contratacao = contratacaoRepository.findById( pagamento.getContratacao().getId() ).get();
        pagamento.setContratacao( contratacao );

        ClienteXPacote clienteXPacote = clienteXPacoteRepository.findById( pagamento.getClienteXPacote().getId() ).get();
        pagamento.setClienteXPacote( clienteXPacote );

        return pagamentoRepository.save( pagamento );
    }

    @Transactional( rollbackFor = Exception.class )
    public Pagamento editar( Integer id, Pagamento pagamento ){
        pagamento.setId( id );
        return pagamentoRepository.save( pagamento );
    }

    public List<Pagamento> todosPagamentos() {
        return (List<Pagamento>) pagamentoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
