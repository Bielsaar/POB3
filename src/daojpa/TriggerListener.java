package daojpa;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;

import modelo.*;

public class TriggerListener{
	
	
	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		System.out.println(" @PrePersist... " + obj.getClass().getSimpleName());
	}
		
	@PostLoad
	public void exibirmsg2(Object obj) {
		System.out.println(" @PostLoad... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao v = (Visualizacao)obj;
			System.out.println("   idade = "+  v.getIdade() );
			int idade = calcularIdade( v );
			v.setIdade(idade);
			System.out.println("   idade calculada em dias=" + " "+ idade );
		}
	}	
	
	//============================================================
	public int calcularIdade(Visualizacao v) {
		LocalDate hoje = LocalDate.now();
		Period per = Period.between(v.getDatahora(), hoje);
		int idade = per.getDays();
		return idade;
	}
}
