package br.com.seniocaires.discos.enumeracao;

/**
 * Classe Enum para definir os campos de pesquisa para Discos.
 * 
 * @author Senio Caires
 *
 */
public enum CampoPesquisaDisco {
	
	/* ==========================================================================
	 * 	DEFINI��O
	 * ==========================================================================
	 */
	
	TITULO("T�tulo"), GENERO("G�nero"), ARTISTA("Artista");
	
	/* ==========================================================================
	 * 	VARI�VEL
	 * ==========================================================================
	 */
	
	String descricao;
	
	/* ==========================================================================
	 * 	CONSTRUTOR
	 * ==========================================================================
	 */
	
	CampoPesquisaDisco(String descricao) {
		this.descricao = descricao;
	}

	/* ==========================================================================
	 * 	GET / SET
	 * ==========================================================================
	 */
	
	/**
	 * Retorna a descri��o
	 * 
	 * @author Senio Caires
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}
}
