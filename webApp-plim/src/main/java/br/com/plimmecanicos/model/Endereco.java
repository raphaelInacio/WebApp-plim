package br.com.plimmecanicos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id @ GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	 /** Atributo nome. */
    private String nome;
    
    /** Atributo numero. */
    private String numero;
    
    /** Atributo complemento. */
    private String complemento;
    
    /** Atributo bairro. */
    private String bairro;
    
    /** Atributo cidade. */
    private String cidade;
    
    /** Atributo estado. */
    private String estado;
    
    /** Atributo cep. */
    private Long CEP;

    /**
     * Obtém o atributo nome.
     *
     * @return o atributo nome.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o valor do atributo nome.
     *
     * @param nome o novo valor do atributo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o atributo numero.
     *
     * @return o atributo numero.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o valor do atributo numero.
     *
     * @param numero o novo valor do atributo numero.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtém o atributo complemento.
     *
     * @return o atributo complemento.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o valor do atributo complemento.
     *
     * @param complemento o novo valor do atributo complemento.
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Obtém o atributo bairro.
     *
     * @return o atributo bairro.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o valor do atributo bairro.
     *
     * @param bairro o novo valor do atributo bairro.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém o atributo cidade.
     *
     * @return o atributo cidade.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o valor do atributo cidade.
     *
     * @param cidade o novo valor do atributo cidade.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Obtém o atributo estado.
     *
     * @return o atributo estado.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o valor do atributo estado.
     *
     * @param estado o novo valor do atributo estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtém o atributo CEP.
     *
     * @return o atributo CEP.
     */
    public Long getCEP() {
        return CEP;
    }

    /**
     * Define o valor do atributo CEP.
     *
     * @param cEP o novo valor do atributo CEP.
     */
    public void setCEP(Long CEP) {
        this.CEP = CEP;
    }
}
