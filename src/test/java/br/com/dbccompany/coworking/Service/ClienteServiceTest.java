package br.com.dbccompany.coworking.Service;

import br.com.dbccompany.coworking.CoworkingApplicationTests;
import br.com.dbccompany.coworking.Entity.Cliente;
import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Entity.TipoContato;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;


//@RunWith(SpringRunner.class)
//@DataJpaTest
public class ClienteServiceTest extends CoworkingApplicationTests {

    @Autowired
    ClienteService clienteService;

    @Autowired
    TipoContatoService tipoContatoService;

    @Test
    public void naoPermitirMesmoCpfParaMaisDeUmCliente() {

        Cliente clienteKevin = new Cliente();
        clienteKevin.setNome("Kevin");
        clienteKevin.setCpf("02738734073");
        clienteKevin.setDataNascimento( new Date( System.currentTimeMillis() ) );

        Cliente clienteJoao = new Cliente();
        clienteJoao.setNome("João");
        clienteJoao.setCpf("02738734073");
        clienteJoao.setDataNascimento( new Date( System.currentTimeMillis() ) );

        try {
            clienteService.salvar( clienteKevin );
            clienteService.salvar( clienteJoao );
        } catch ( Exception e ){
            Assert.assertEquals( "ERRO-CPF já cadastrado na base de dados para outro Cliente", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirCriarClienteSemEmailETelefone() throws Exception {

        TipoContato telefone = new TipoContato();
        telefone.setValor( "Telefone" );
        tipoContatoService.salvar( telefone );

        TipoContato email = new TipoContato();
        email.setValor( "Email" );
        tipoContatoService.salvar( email );

        TipoContato fax = new TipoContato();
        fax.setValor( "Fax" );
        tipoContatoService.salvar( fax );

//        Contato contatoTelefone = new Contato();
//        contatoTelefone.setTipoContato( telefone );
//        contatoTelefone.setValor(" 992504229 ");
//
//        Contato contatoEmail = new Contato();
//        contatoEmail.setTipoContato( email );
//        contatoEmail.setValor( "kevin.zamperetti92@gmail.com" );

        Contato contatoFax = new Contato();
        contatoFax.setTipoContato( fax );
        contatoFax.setValor( "33622894" );

        Cliente clienteKevin = new Cliente();
        clienteKevin.setNome("Kevin");
        clienteKevin.setCpf("1234");
        clienteKevin.setDataNascimento( new Date( System.currentTimeMillis() ) );
        clienteKevin.setContatos(Arrays.asList( contatoFax ) );

        try {
            clienteService.salvar( clienteKevin );
        } catch ( Exception e ){
            Assert.assertEquals( "ERRO-Cliente necessita de um Contato do tipo Email e Telefone cadastrados!", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirClienteSemContato() {

        Cliente clienteMaria = new Cliente();
        clienteMaria.setNome("Maria");
        clienteMaria.setCpf("02738734073");
        clienteMaria.setDataNascimento( new Date( System.currentTimeMillis() ) );

        try {
            clienteService.salvar( clienteMaria );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Cliente não possui nenhum Contato vinculado!!", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirClienteSemNome() {

        Cliente cliente = new Cliente();
        cliente.setCpf("02738734073");
        cliente.setDataNascimento( new Date( System.currentTimeMillis() ) );

        try {
            clienteService.salvar( cliente );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Faltou informar o Nome do Cliente", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirClienteSemCpf() {

        Cliente clientePedro = new Cliente();
        clientePedro.setNome("Pedro");
        clientePedro.setDataNascimento( new Date( System.currentTimeMillis() ) );

        try {
            clienteService.salvar( clientePedro );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Faltou informar o CPF do Cliente", e.getMessage() );
        }
    }

    @Test
    public void naoPermitirClienteSemDataDeNascimento() {

        Cliente clienteCarla = new Cliente();
        clienteCarla.setNome("Carla");
        clienteCarla.setCpf("02738734000");
        try {
            clienteService.salvar( clienteCarla );
        } catch ( Exception e ) {
            Assert.assertEquals( "ERRO-Faltou informar a Data de Nascimento do Cliente", e.getMessage() );
        }
    }


}
