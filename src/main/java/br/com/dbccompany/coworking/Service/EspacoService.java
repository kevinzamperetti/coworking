package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Funcoes.Conversao;
import br.com.dbccompany.coworking.Repository.ContratacaoRepository;
import br.com.dbccompany.coworking.Repository.EspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository espacoRepository;

    @Transactional( rollbackFor = Exception.class )
    public Espaco salvar(Espaco espaco ) throws Exception {

        validarCamposObrigatorios( espaco );

        return espacoRepository.save( espaco );
    }

    @Transactional( rollbackFor = Exception.class )
    public Espaco editar( Integer id, Espaco espaco ){
        espaco.setId( id );
        return espacoRepository.save( espaco );
    }

    public List<Espaco> todosEspacos() {
        return (List<Espaco>) espacoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }

    private void validarCamposObrigatorios( Espaco espaco )throws Exception {

        if ( espacoRepository.findByNome( espaco.getNome() ) != null ) {
            throw new Exception( "ERRO-Nome já cadastrado na base de dados para outro Espaço" );
        }

        if ( espaco.getQtdPessoas() == null ) {
            throw new Exception("ERRO-Faltou informar a Quantidade de Pessoas do Espaço");
        }

        if ( espaco.getValor() == null ) {
            throw new Exception("ERRO-Faltou informar o Valor do Espaço");
        }
    }
}
