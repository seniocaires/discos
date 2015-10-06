package br.com.seniocaires.discos.bandodedados;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Classe para gerar o banco de dados a partir da configuração e anotações do hibernate.
 * 
 * @author Senio Caires
 *
 */
public class GeraBanco {

	public static void main(String[] args) {
		
		/*
		 * Cria uma configuração
		 * Configuration é um objeto que vai ler o hibernate.cfg.xml e 
		 * digerir as anotações (AnnotationConfiguration)
		 */
		Configuration configuracao = new AnnotationConfiguration();
		
		configuracao.configure("br/com/seniocaires/discos/recurso/hibernate.cfg.xml");
		
		/*
		 * SchemaExport é o responsável para criar o schema e executá-lo.
		 * O primeiro boolean indica se quer imprimir o schema, e o segundo
		 * se ele deve ser executado (ou se é apenas teste). Isto é, dada uma 
		 * configuração, a classe SchemaExport é capaz de gerar o código DDL de 
		 * criação de tabelas em determinado banco. 
		 */
		SchemaExport schema = new SchemaExport(configuracao);
		
		schema.create(true, true);

	}

}