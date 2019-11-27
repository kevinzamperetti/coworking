package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.CoworkingApplicationTests;
import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Entity.Espaco;
import br.com.dbccompany.coworking.Entity.TipoContato;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;


//@RunWith(SpringRunner.class)
//@DataJpaTest
public class EspacoServiceTest extends CoworkingApplicationTests {

    @Autowired
    EspacoService espacoService;

    @Test
    public void naoPermitirMesmoNomeParaMaisDeUmEspaco() {

        Espaco espaco1 = new Espaco();
        espaco1.setNome( "Coworking Gravataí" );
        espaco1.setQtdPessoas( 100 );
        espaco1.setValorString( "R$ 1.000,00" );

        Espaco espaco2 = new Espaco();
        espaco2.setNome( "Coworking Gravataí" );
        espaco2.setQtdPessoas( 200 );
        espaco2.setValorString( "R$ 2.500,00" );

        try {
            espacoService.salvar( espaco1 );
            espacoService.salvar( espaco2 );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Nome já cadastrado na base de dados para outro Espaço", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirEspacoSemQtdPessoas() {

        Espaco espaco3 = new Espaco();
        espaco3.setNome( "Coworking Gravataí 3" );
        espaco3.setValorString( "R$ 1.000,00" );

        try {
            espacoService.salvar( espaco3 );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Faltou informar a Quantidade de Pessoas do Espaço", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirEspacoSemValor() {

        Espaco espaco4 = new Espaco();
        espaco4.setNome( "Coworking Gravataí 4" );
        espaco4.setQtdPessoas( 100 );

        try {
            espacoService.salvar( espaco4 );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Faltou informar o Valor do Espaço", e.getMessage() );
        }
    }

}
