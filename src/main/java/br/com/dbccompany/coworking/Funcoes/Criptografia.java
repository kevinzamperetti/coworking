package br.com.dbccompany.coworking.Funcoes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public String criptografarSenhaMD5( String senha ) throws NoSuchAlgorithmException {
        if ( senha == null || senha.length() < 6 ) {
            return null;
        } else {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update( senha.getBytes(),0, senha.length() );
            return new BigInteger( 1, m.digest() ).toString( 16 );
        }
    }
}
