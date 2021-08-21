package br.com.franzoso.Enums;

public enum Curso {

	ADMINISTRACAO("Administração"),
	INFORMATICA("Informática"),
	LOGISTICA("Logística"),
	PROGRAMAÇÃO("Programação"),
	ENFERMAGEM("Enfermagem");
	
	private String curso;
	
	private Curso(String curso) {
		this.curso = curso;
	}
	
	
}
