package br.com.seniocaires.discos.negocio;

public class FabricaNegocio {

	private static FabricaNegocio instancia;
	
	private DiscoBO discoBO;
	
	private FabricaNegocio() {}

	/**
	 * Retorna o objeto de negócio dos discos.
	 * 
	 * @author Senio Caires
	 * @return discoBO
	 */
	public DiscoBO getDiscoBO() {
		return discoBO == null ? discoBO = new DiscoBO() : discoBO;
	}
	
	/**
	 * Retorna a instância da fábrica de negócio.
	 * 
	 * @author Senio Caires
	 * @return fabricaNegocio
	 */
	public static FabricaNegocio getInstancia() {
		return instancia == null ? instancia = new FabricaNegocio() : instancia;
	}
}