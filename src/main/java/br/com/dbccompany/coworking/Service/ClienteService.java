package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.*;
import br.com.dbccompany.coworking.Repository.AcessoRepository;
import br.com.dbccompany.coworking.Repository.ClienteRepository;
import br.com.dbccompany.coworking.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoContatoService tipoContatoService;

    @Autowired
    private ContatoRepository contatoRepository;


    @Autowired
    private ContatoService contatoService;

    @Transactional( rollbackFor = Exception.class )
    public Cliente salvar( Cliente cliente ) throws Exception {

        validarCamposObrigatorios( cliente );

        return clienteRepository.save( cliente );
    }

    @Transactional( rollbackFor = Exception.class )
    public Cliente editar( Integer id, Cliente cliente ){
        cliente.setId( id );
        return clienteRepository.save( cliente );
    }

    public List<Cliente> todosClientes() {
        return (List<Cliente>) clienteRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

    private void validarCamposObrigatorios( Cliente cliente )throws Exception {
        if ( clienteRepository.findByCpf( cliente.getCpf() ) != null ) {
            throw new Exception( "ERRO-CPF já cadastrado na base de dados para outro Cliente" );
        }

        if ( cliente.getNome() == null ) {
            throw new Exception("ERRO-Faltou informar o Nome do Cliente");
        }

        if ( cliente.getCpf() == null ) {
            throw new Exception("ERRO-Faltou informar o CPF do Cliente");
        }

        if ( cliente.getDataNascimento() == null ) {
            throw new Exception("ERRO-Faltou informar a Data de Nascimento do Cliente");
        }

        if ( cliente.getContatos() == null ) {
            throw new Exception("ERRO-Cliente não possui nenhum Contato vinculado");
        }

        for( Contato contato : cliente.getContatos() ) {
            System.out.println("Contato: " + contato.getTipoContato().getValor().toUpperCase() );

            if ( !contato.getTipoContato().getValor().toUpperCase().equals("EMAIL") ||
                    !contato.getTipoContato().getValor().toUpperCase().equals("TELEFONE") ) {
                throw new Exception("ERRO-Cliente necessita de um Contato do tipo Email e Telefone cadastrados!");
            }
        }
    }
}
