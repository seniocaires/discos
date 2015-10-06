package br.com.seniocaires.discos.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.seniocaires.discos.entidade.Disco;
import br.com.seniocaires.discos.enumeracao.CampoPesquisaDisco;
import br.com.seniocaires.discos.negocio.FabricaNegocio;
import br.com.seniocaires.sporon.excecao.ValidacaoException;
import br.com.seniocaires.sporon.managedbean.ManagedBeanGenerico;
import br.com.seniocaires.sporon.utilitario.helper.JSFHelper;

/**
 * Managed Bean para Módulo
 * 
 * @author Senio Caires
 *
 */
public class DiscoMB extends ManagedBeanGenerico {
	
	/* ==========================================================================
	 * 	VARIÁVEL
	 * ==========================================================================
	 */
	
	private Disco disco;
	
	private List<SelectItem> campoPesquisaList;
	
	/* ==========================================================================
	 * 	CONSTRUTOR
	 * ==========================================================================
	 */
	
	public DiscoMB() {
		
		setPaginaPesquisa("discoPesquisa");
		setPaginaEdicao("discoEdicao");
		setPaginaAtual(getPaginaPesquisa());
	}
	
	/* ==========================================================================
	 * 	GET / SET
	 * ==========================================================================
	 */
	
	/**
	 * Retorna o disco.
	 * 
	 * @author Senio Caires
	 * @return disco
	 */
	public Disco getDisco() {
		return disco == null ? disco = new Disco() : disco;
	}

	/**
	 * Altera o disco.
	 * 
	 * @author Senio Caires
	 * @param disco
	 */
	public void setDisco(Disco disco) {
		this.disco = disco;
	}
	
	/* ==========================================================================
	 * 	SELECT LIST
	 * ==========================================================================
	 */
	
	/**
	 * Retorna o campoPesquisaSelectList.
	 * 
	 * @author Senio Caires
	 * @return campoPesquisaSelectList
	 */
	public List<SelectItem> getCampoPesquisaList() {
		
		if(campoPesquisaList == null) {
			
			campoPesquisaList = new ArrayList<SelectItem>();
			
			campoPesquisaList.add(new SelectItem(CampoPesquisaDisco.TITULO.getDescricao(), CampoPesquisaDisco.TITULO.getDescricao()));
			campoPesquisaList.add(new SelectItem(CampoPesquisaDisco.GENERO.getDescricao(), CampoPesquisaDisco.GENERO.getDescricao()));
			campoPesquisaList.add(new SelectItem(CampoPesquisaDisco.ARTISTA.getDescricao(), CampoPesquisaDisco.ARTISTA.getDescricao()));
		}
		
		return campoPesquisaList;
	}

	/* ==========================================================================
	 * 	AÇÕES
	 * ==========================================================================
	 */
	
	/**
	 * Cria um novo disco e retorna a navigation rule da página de edição.
	 * 
	 * @author Senio Caires
	 * @return navigation rule
	 */
	public String novo() {
		
		disco = new Disco();
		
		return getPaginaAtual(getPaginaEdicao());
	}
	
	/**
	 * Prepara um disco para edição e retorna a navigation rule da página de edição.
	 * 
	 * @author Senio Caires
	 * @return navigation rule
	 */
	public String editar() {
		
		disco = (Disco) getRegistrosDataList().getRowData();
		
		FabricaNegocio.getInstancia().getDiscoBO().refresh(disco);
		
		return getPaginaAtual(getPaginaEdicao());
	}
	
	/**
	 * Insere/atualiza o disco no banco de dados.
	 * 
	 * @author Senio Caires
	 */
	public void salvar() {
		
		try {

			FabricaNegocio.getInstancia().getDiscoBO().salvar(disco);
			
			pesquisar();
		
		} catch (ValidacaoException e) {
			JSFHelper.addGlobalMessageError(e.getMessage());
		}
	}
	
	/**
	 * Exclui o disco do banco de dados.
	 * 
	 * @author Senio Caires
	 */
	public void excluir() {
		
		try {
			FabricaNegocio.getInstancia().getDiscoBO().apagar(disco);
		
			pesquisar();
			
			novo();
			
		} catch (ValidacaoException e) {
			JSFHelper.addGlobalMessageError(e.getMessage());
		}
	}
	
	/**
	 * Executa a pesquisa padrão.
	 * 
	 * @author Senio Caires
	 */
	public void pesquisar() {

		if(CampoPesquisaDisco.TITULO.getDescricao().equals(getCampoPesquisa()))
			registrosDataList = new ListDataModel(FabricaNegocio.getInstancia().getDiscoBO().getListaPorTitulo(getDescricaoPesquisa()));
		
		if(CampoPesquisaDisco.GENERO.getDescricao().equals(getCampoPesquisa()))
			registrosDataList = new ListDataModel(FabricaNegocio.getInstancia().getDiscoBO().getListaPorGenero(getDescricaoPesquisa()));
		
		if(CampoPesquisaDisco.ARTISTA.getDescricao().equals(getCampoPesquisa()))
			registrosDataList = new ListDataModel(FabricaNegocio.getInstancia().getDiscoBO().getListaPorArtista(getDescricaoPesquisa()));
	}
}