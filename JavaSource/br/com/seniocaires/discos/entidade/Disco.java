package br.com.seniocaires.discos.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.seniocaires.sporon.utilitario.util.ConversaoUtil;

/**
 * Classe de entidade para representar Discos
 * 
 * @author Senio Caires
 *
 */
@Entity
public class Disco implements Serializable {

	/* ==========================================================================
	 * 	CONSTANTE
	 * ==========================================================================
	 */
	
	private static final long serialVersionUID = -3159141785185578411L;

	/* ==========================================================================
	 * 	VARIÁVEL
	 * ==========================================================================
	 */
	
	private Integer id;
	private String titulo;
	private String genero;
	private String artista;
	private Integer quantidade;
	private BigDecimal preco;
	
	/* ==========================================================================
	 * 	CONSTRUTOR
	 * ==========================================================================
	 */
	
	public Disco() {}
	
	/* ==========================================================================
	 * 	GET / SET
	 * ==========================================================================
	 */
	
	/**
	 * Retorna o identificador.
	 * 
	 * @author Senio Caires
	 * @return id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	/**
	 * Altera o identidificador.
	 * 
	 * @author Senio Caires
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Retorna o título.
	 * 
	 * @author Senio Caires
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Altera o título.
	 * 
	 * @author Senio Caires
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Retorna o gênero.
	 * 
	 * @author Senio Caires
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Altera o gênero.
	 * 
	 * @author Senio Caires
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Retorna o artista.
	 * 
	 * @author Senio Caires
	 * @return artista
	 */
	public String getArtista() {
		return artista;
	}
	
	/**
	 * Altera o artista.
	 * 
	 * @author Senio Caires
	 * @param artista
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	/**
	 * Retorna a quantidade.
	 * 
	 * @author Senio Caires
	 * @return quantidade
	 */
	public Integer getQuantidade() {
		return quantidade == null ? quantidade = 0 : quantidade;
	}
	
	/**
	 * Altera a quantidade.
	 * 
	 * @author Senio Caires
	 * @param quantidade
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * Retorna o preço.
	 * 
	 * @author Senio Caires
	 * @return preco
	 */
	public BigDecimal getPreco() {
		return preco == null ? preco = BigDecimal.ZERO : preco;
	}
	
	/**
	 * Altera o preço.
	 * 
	 * @author Senio Caires
	 * @param preco
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	/* ==========================================================================
	 * 	OUTROS
	 * ==========================================================================
	 */
	
	/**
	 * Método para retornar o id no formato String.
	 * 
	 * @author Senio Caires
	 * @return codigo
	 */
	@Transient
	public String getCodigo() {
		return getId() == null ? "" : String.valueOf(getId());
	}
	
	/**
	 * Código não é alterável.
	 * 
	 * @author Senio Caires
	 * @param codigo
	 */
	@Transient
	public void setCodigo(String codigo) {
		
	}

	/* ==========================================================================
	 * 	DEFINIÇÃO
	 * ==========================================================================
	 */
	
	/**
	 * Retorna a representação em string. <br/>
	 * A representação não retornará valor nulo.
	 * 
	 * @author Senio Caires
	 * @return representacao
	 */
	@Override
	public String toString() {
		return ConversaoUtil.nuloParaVazio(getArtista()) + " - " + ConversaoUtil.nuloParaVazio(getTitulo());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disco other = (Disco) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}