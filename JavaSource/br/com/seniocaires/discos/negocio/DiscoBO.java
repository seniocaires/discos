package br.com.seniocaires.discos.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.seniocaires.discos.entidade.Disco;
import br.com.seniocaires.sporon.excecao.ValidacaoException;
import br.com.seniocaires.sporon.persistencia.HibernateDAO;
import br.com.seniocaires.sporon.utilitario.util.ComparacaoUtil;
import br.com.seniocaires.sporon.utilitario.util.ConversaoUtil;

/**
 * Classe de negócio - Disco.
 * 
 * @author Senio Caires
 *
 */
public class DiscoBO {

	/* ==========================================================================
	 * 	CONSTANTE
	 * ==========================================================================
	 */
	
	private static final long serialVersionUID = 1L;
	
	private static final String SQL_DISCO = "SELECT disco FROM Disco disco WHERE ";
	
	/* ==========================================================================
	 * 	VARIÁVEL
	 * ==========================================================================
	 */
	
	private HibernateDAO<Disco> daoBase;

	/* ==========================================================================
	 * 	CONSTRUTOR
	 * ==========================================================================
	 */
	
	public DiscoBO() {}
	
	/**
	 * Construtor que já define o DAO.
	 * 
	 * @author Senio Caires
	 * @param daoBase
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DiscoBO(HibernateDAO daoBase) {
		this.daoBase = daoBase;
	}
	
	/* ==========================================================================
	 * 	MÉTODO
	 * ==========================================================================
	 */
	
	/**
	 * Atualiza o objeto.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	public void refresh(Disco disco){
		getDaoBase().refresh(disco);
	}
	
	/**
	 * Persiste o disco.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	public void salvar(Disco disco) throws ValidacaoException {
		
		validarSalvar(disco);
		
		if(disco.getId() == null)
			inserir(disco);
		else
			atualizar(disco);
	}
	
	/**
	 * Persiste o disco como registro novo.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	private void inserir(Disco disco) {
		getDaoBase().inserir(disco);
	}
	
	/**
	 * Atualiza os dados do disco já persistido.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	private void atualizar(Disco disco) {
		getDaoBase().atualizar(disco);
	}
	
	/**
	 * Retorna o disco que corresponde ao id passado como parâmetro.
	 * 
	 * @author Senio Caires
	 * @param idDisco
	 * @return disco
	 */
	public Disco carregar(Integer idDisco) {
		
		if(idDisco == null) return new Disco();
		
		Disco disco = getDaoBase().carregar(Disco.class, idDisco);
		
		return 	disco != null ? disco : new Disco();
	}

	/**
	 * Apaga o registro persistido.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	public void apagar(Disco disco) throws ValidacaoException {
		
		validarApagar(disco);
		
		if(disco != null && disco.getId() != null){
			
			Disco discoTemp = getDaoBase().carregar(Disco.class, disco.getId());
			
			if (discoTemp != null)
				getDaoBase().apagar(discoTemp);
		}
	}
	
	/**
	 * Retorna uma lista de discos.
	 * 
	 * @author Senio Caires
	 * @return lista de discos
	 */
	public List<Disco> getListaPorTitulo(String titulo) {
		
		List<Disco> list = getDaoBase().getLista(SQL_DISCO + " disco.titulo LIKE '" + ConversaoUtil.nuloParaVazio(titulo) + "%' ORDER BY disco.titulo");
		
		return 	list != null ? list : new ArrayList<Disco>();
	}
	
	/**
	 * Retorna uma lista de discos.
	 * 
	 * @author Senio Caires
	 * @return lista de discos
	 */
	public List<Disco> getListaPorArtista(String artista) {
		
		List<Disco> list = getDaoBase().getLista(SQL_DISCO + " disco.artista LIKE '" + ConversaoUtil.nuloParaVazio(artista) + "%' ORDER BY disco.artista");
		
		return 	list != null ? list : new ArrayList<Disco>();
	}
	
	/**
	 * Retorna uma lista de discos.
	 * 
	 * @author Senio Caires
	 * @return lista de discos
	 */
	public List<Disco> getListaPorGenero(String genero) {
		
		List<Disco> list = getDaoBase().getLista(SQL_DISCO + " disco.genero LIKE '" + ConversaoUtil.nuloParaVazio(genero) + "%' ORDER BY disco.genero");
		
		return 	list != null ? list : new ArrayList<Disco>();
	}
	
	/**
	 * Verifica se é possível persistir o disco.
	 * 
	 * @author Senio Caires
	 * @param disco
	 * @throws ValidacaoException
	 */
	private void validarSalvar(Disco disco) throws ValidacaoException {
		
		if(disco == null)
			throw new ValidacaoException("Não foi possível salvar. Registro vazio.");
		
		if(ComparacaoUtil.isVazio(disco.getTitulo()))
			throw new ValidacaoException("Não foi possível salvar. Preencha o título.");
		
		if(ComparacaoUtil.isVazio(disco.getArtista()))
			throw new ValidacaoException("Não foi possível salvar. Preencha o artista.");
	}
	
	/**
	 * Verifica se é possível apagar o disco.
	 * 
	 * @author Senio Caires
	 * @param disco
	 * @throws ValidacaoException
	 */
	private void validarApagar(Disco disco) throws ValidacaoException {}
	
	public HibernateDAO<Disco> getDaoBase() {
		return daoBase == null ? daoBase = new HibernateDAO<Disco>() : daoBase;
	}
}