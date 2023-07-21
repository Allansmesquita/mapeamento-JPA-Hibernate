package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); // "persistenceUnitName" = valor inserido na lacuna name no persistence.xml linha 6:
																						//L6 - <persistence-unit name="exemplo-jpa" transaction-type="RESOURCE_LOCAL"> ==> EXEMPLO-JPA		 		
		EntityManager em = emf.createEntityManager();
	
		//O que é uma entidade monitorada? Aquela que acabou de ser inserida, ou aquela que foi recuperada do banco de dados por meio de uma consulta (em.find) como o exemplo abaixo:
		
		Pessoa p = em.find(Pessoa.class, 2); 
		em.getTransaction().begin(); //Sempre que for realizar uma operação que não seja uma simples consulta precisa colocar transação 
																		//(em.getTransaction().begin() e em.getTransaction().commit()).
		em.remove(p);
		em.getTransaction().commit();
		
		//System.out.println(p);
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	}

}
