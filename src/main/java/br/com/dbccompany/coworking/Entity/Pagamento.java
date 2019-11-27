package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Enum.TipoPagamento;

import javax.persistence.*;

@Entity
@Table( name = "pagamentos")
@SequenceGenerator( allocationSize = 1, name = "PAGAMENTOS_SEQ", sequenceName = "PAGAMENTOS_SEQ" )
public class Pagamento extends AbstractEntity {

    @Id
    @Column( name = "id_pagamento" )
    @GeneratedValue( generator = "PAGAMENTOS_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "fk_id_clientes_pacotes" )
    private ClienteXPacote clienteXPacote;

    @ManyToOne
    @JoinColumn( name = "fk_id_contratacao" )
    private Contratacao contratacao;

    @Enumerated( EnumType.STRING )
    @Column( name = "tipo_pagamento", nullable = false )
    private TipoPagamento tipoPagamento;

    public ClienteXPacote getClienteXPacote() {
        return clienteXPacote;
    }

    public void setClienteXPacote(ClienteXPacote clienteXPacote) {
        this.clienteXPacote = clienteXPacote;
    }

    public Contratacao getContratacao() {
        return contratacao;
    }

    public void setContratacao(Contratacao contratacao) {
        this.contratacao = contratacao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}