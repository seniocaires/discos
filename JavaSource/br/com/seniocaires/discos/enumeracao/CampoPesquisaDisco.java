package br.com.seniocaires.discos.enumeracao;

/**
 * Classe Enum para definir os campos de pesquisa para Discos.
 * 
 * @author Senio Caires
 *
 */
public enum CampoPesquisaDisco {
	
	/* ==========================================================================
	 * 	DEFINIÇÃO
	 * ==========================================================================
	 */
	
	TITULO("Título"), GENERO("Gênero"), ARTISTA("Artista");
	
	/* ==========================================================================
	 * 	VARIÁVEL
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
	 * Retorna a descrição
	 * 
	 * @author Senio Caires
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}
}
