package br.com.dbccompany.coworking.Entity;

import br.com.dbccompany.coworking.Enum.TipoContratacao;

import javax.persistence.*;

@Entity
@Table( name = "espacos_pacotes")
@SequenceGenerator( allocationSize = 1, name = "ESPACOS_PACOTES_SEQ", sequenceName = "ESPACOS_PACOTES_SEQ" )
public class EspacoXPacote extends AbstractEntity {

    @Id
    @Column( name = "id_espaco_pacote")
    @GeneratedValue( generator = "ESPACOS_PACOTES_SEQ", strategy = GenerationType.SEQUENCE )
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "fk_id_espaco" )
    private Espaco idEspaco;

    @ManyToOne
    @JoinColumn( name = "fk_id_pacote" )
    private Pacote idPacoteEspaco;

    @Enumerated( EnumType.STRING )
    @Column( name = "tipo_contratacao", nullable = false )
    private TipoContratacao tipoContratacao;

    @Column( name = "quantidade", nullable = false )
    private Double quantidade;

    @Column( name = "prazo", nullable = false )
    private Double prazo;

    public Espaco getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Espaco idEspaco) {
        this.idEspaco = idEspaco;
    }

    public Pacote getIdPacoteEspaco() {
        return idPacoteEspaco;
    }

    public void setIdPacoteEspaco(Pacote idPacoteEspaco) {
        this.idPacoteEspaco = idPacoteEspaco;
    }

    public TipoContratacao getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(TipoContratacao tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrazo() {
        return prazo;
    }

    public void setPrazo(Double prazo) {
        this.prazo = prazo;
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
