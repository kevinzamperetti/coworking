package br.com.dbccompany.coworking.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SaldoClienteId implements Serializable {

    @Column(name = "id_cliente" )
    private Integer idCliente;

    @Column(name = "id_espaco" )
    private Integer idEspaco;

    public SaldoClienteId() {
    }

    public SaldoClienteId( Integer idCliente, Integer idEspaco ) {
        this.idCliente = idCliente;
        this.idEspaco = idEspaco;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }
}

