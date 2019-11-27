package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Enum.TipoContratacao;
import br.com.dbccompany.coworking.Funcoes.Conversao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "contratacao")
@SequenceGenerator( allocationSize = 1, name = "CONTRATACOES_SEQ", sequenceName = "CONTRATACOES_SEQ" )
public class Contratacao extends AbstractEntity {

    @Id
    @Column( name = "id_contratacao" )
    @GeneratedValue( generator = "CONTRATACOES_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "fk_id_espaco" )
    private Espaco espaco;

    @ManyToOne
    @JoinColumn( name = "fk_id_cliente" )
    private Cliente cliente;

    @Enumerated( EnumType.STRING )
    @Column( name = "tipo_contratacao", nullable = false )
    private TipoContratacao tipoContratacao;

    @Column( name = "quantidade", nullable = false )
    private Integer quantidade;

    @Column( name = "desconto" )
    private Double desconto;

    @Transient
    private String descontoString = "";

    @Column( name = "prazo", nullable = false )
    private Double prazo;

    @OneToMany( mappedBy = "contratacao", cascade = CascadeType.ALL )
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(TipoContratacao tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getDescontoString() {
        return descontoString;
    }

    public void setDescontoString(String descontoString) {
        this.descontoString = descontoString;
        this.desconto = Conversao.converteRealParaValor( descontoString );
    }

    public Double getPrazo() {
        return prazo;
    }

    public void setPrazo(Double prazo) {
        this.prazo = prazo;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
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
