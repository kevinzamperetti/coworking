package br.com.dbccompany.coworking;

import br.com.dbccompany.coworking.Funcoes.Conversao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoworkingApplication {

	public static void main(String[] args) {

//		Conversao converter = new Conversao();
//		System.out.println( "Double: " + converter.converteRealParaValor( "R$ 100,50" ) );
//		System.out.println( "String: " + converter.converteValorParaReal( 100.50 ) );

		SpringApplication.run(CoworkingApplication.class, args);
	}

}
