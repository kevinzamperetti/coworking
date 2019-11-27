package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.Entity.Acesso;
import br.com.dbccompany.coworking.Funcoes.Conversao;
import br.com.dbccompany.coworking.Repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    @Transactional( rollbackFor = Exception.class )
    public String salvar(Acesso acesso ) throws Exception {

        if ( acesso.getData() == null ) {
            acesso.setData( new Date( System.currentTimeMillis() ));
        }

        if ( acesso.getIsEntrada() ) {
            acesso.setIsEntrada( true );
            Double valorEntrada = acesso.getSaldoCliente().getQuantidade();
            if ( acesso.getSaldoCliente().getQuantidade() == 0 ) {
                throw new Exception( "ERRO-Saldo Insuficiente" );
            } else {
                acessoRepository.save( acesso );

                //Se fora da validade zerar quantidade
                if ( acesso.getSaldoCliente().getVencimento().before( acesso.getData() ) ) {
                    acesso.getSaldoCliente().setQuantidade( 0.0 );
                }
                return Conversao.converteValorParaReal( acesso.getSaldoCliente().getQuantidade() );
            }
        } else {  //saida
            return null;
        }
    }

    @Transactional( rollbackFor = Exception.class )
    public Acesso editar( Integer id, Acesso acesso ){
        acesso.setId( id );
        return acessoRepository.save( acesso );
    }

    public List<Acesso> todosAcessos() {
        return (List<Acesso>) acessoRepository.findAll(); // ou subescreve o método no dwarf e ai não precisa o cast
    }
}
