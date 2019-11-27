package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.CoworkingApplicationTests;
import br.com.dbccompany.coworking.Entity.*;
import br.com.dbccompany.coworking.Enum.TipoContratacao;
import br.com.dbccompany.coworking.Funcoes.Conversao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;


//@RunWith(SpringRunner.class)
//@DataJpaTest
public class ContratacaoServiceTest extends CoworkingApplicationTests {

    @Autowired
    ContratacaoService contratacaoService;

    @Test
    public void efetuarCalculoDaContratacaoOk() {
        Espaco espaco = new Espaco();
        espaco.setNome( "Sala Single" );
        espaco.setQtdPessoas( 1 );
        espaco.setValorString( "R$100,00" );

        Contratacao contratacao = new Contratacao();
        contratacao.setEspaco( espaco );
        contratacao.setQuantidade( 5 );
        contratacao.setTipoContratacao( TipoContratacao.DIARIA );


        Double result = contratacao.getQuantidade() * contratacao.getEspaco().getValor();
        String resultString = Conversao.converteValorParaReal( result );
        Assert.assertEquals( "R$ 500,00", resultString );
    }
}
