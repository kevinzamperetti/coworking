package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Funcoes.Conversao;
import br.com.dbccompany.coworking.Repository.ClienteRepository;
import br.com.dbccompany.coworking.Repository.ContatoRepository;
import br.com.dbccompany.coworking.Repository.ContratacaoRepository;
import br.com.dbccompany.coworking.Repository.EspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContratacaoService {

    @Autowired
    private ContratacaoRepository contratacaoRepository;

    @Autowired
    private EspacoRepository espacoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional( rollbackFor = Exception.class )
    public String salvar( Contratacao contratacao ) {

        Espaco espaco = espacoRepository.findById( contratacao.getEspaco().getId() ).get();
        contratacao.setEspaco( espaco );

        Cliente cliente = clienteRepository.findById( contratacao.getCliente().getId() ).get();
        contratacao.setCliente( cliente );

        Integer quantidadeContratacao = contratacao.getQuantidade();
        Double descontoContratacao = contratacao.getDesconto();

        //Double valorCobrar = valorEspaco * quantidadeContratacao;
        Double valorCobrar = definirValorCobrarContrato( contratacao, espaco.getValor() );

        contratacaoRepository.save( contratacao );

        return Conversao.converteValorParaReal( valorCobrar * quantidadeContratacao -  descontoContratacao );
    }

    @Transactional( rollbackFor = Exception.class )
    public Contratacao editar( Integer id, Contratacao contratacao ){
        contratacao.setId( id );
        return contratacaoRepository.save( contratacao );
    }

    public List<Contratacao> todasContratacoes() {
        return (List<Contratacao>) contratacaoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

    private Double definirValorCobrarContrato( Contratacao contratacao, Double valorEspaco ) {

        if ( contratacao.getTipoContratacao().toString().equals("MINUTO") ) {
            return valorEspaco / 1440;
        } else if ( contratacao.getTipoContratacao().toString().equals("HORA") ) {
            return valorEspaco / 24;
        } else if ( contratacao.getTipoContratacao().toString().equals("TURNO") ) {
            return valorEspaco / ( 24 / 5 );
        } else if ( contratacao.getTipoContratacao().toString().equals("DIARIA") ) {
            return valorEspaco * 1;
        } else if ( contratacao.getTipoContratacao().toString().equals("SEMANA") ) {
            return valorEspaco / 4;
        } else if ( contratacao.getTipoContratacao().toString().equals("MES") ) {
            return valorEspaco * 30;
        } else {
            return 0.0;
        }
    }
}
