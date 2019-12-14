package com.gestor;

import javax.persistence.*;
@Entity
public class GestorModel {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;
    
    @Column(name = "matricula", length = 10, nullable = false)
    private String matricula;
    
    @Column(name = "dataDeNascimento", length = 10, nullable = false)
    private String dataDeNascimento;

	@Column(name = "setor", length = 20, nullable = false)
    private String setor;
    
    
    GestorModel() {
    }
    
    GestorModel(String nome, String matricula, String dataDeNascimento, String setor){
        this.nome = nome;
        this.matricula = matricula;
        this.dataDeNascimento = dataDeNascimento;
        this.setor = setor;
    }
    
    GestorModel(long id, String nome, String matricula, String dataDeNascimento, String setor){
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataDeNascimento = dataDeNascimento;
        this.setor = setor;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
    
    @Override
    public String toString() {
        return "GestorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", setor='" + setor + '\'' +
                '}';
    }
}
