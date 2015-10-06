package br.com.seniocaires.discos.bandodedados;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Classe para gerar o banco de dados a partir da configura��o e anota��es do hibernate.
 * 
 * @author Senio Caires
 *
 */
public class GeraBanco {

	public static void main(String[] args) {
		
		/*
		 * Cria uma configura��o
		 * Configuration � um objeto que vai ler o hibernate.cfg.xml e 
		 * digerir as anota��es (AnnotationConfiguration)
		 */
		Configuration configuracao = new AnnotationConfiguration();
		
		configuracao.configure("br/com/seniocaires/discos/recurso/hibernate.cfg.xml");
		
		/*
		 * SchemaExport � o respons�vel para criar o schema e execut�-lo.
		 * O primeiro boolean indica se quer imprimir o schema, e o segundo
		 * se ele deve ser executado (ou se � apenas teste). Isto �, dada uma 
		 * configura��o, a classe SchemaExport � capaz de gerar o c�digo DDL de 
		 * cria��o de tabelas em determinado banco. 
		 */
		SchemaExport schema = new SchemaExport(configuracao);
		
		schema.create(true, true);

	}

}