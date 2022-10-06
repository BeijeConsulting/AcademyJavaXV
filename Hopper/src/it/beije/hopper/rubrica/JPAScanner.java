package it.beije.hopper.rubrica;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapiti;

public class JPAScanner {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Contatto contatto = null;
		Recapiti recapiti = null;
		//SELECT c FROM Contatto as c WHERE id = X
		//recapiti = entityManager.find(Recapiti.class, 1);
		//contatto = entityManager.find(Contatto.class, 4);
		//System.out.println("contatto : " + contatto);
		//System.out.println("recap : " + recapiti);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		
		//SCANNER
				System.out.println("Premi 'I' per inserire, 'U' per modificare, 'D' per cancellare, 'S' per vedere il db,");
				
				Scanner modifiche = new Scanner(System.in);
				String st = modifiche.next();

	
				
				
				
		//INSERT
				if(st.equals("I")) {
					System.out.println("Vuoi inserire nuovo contatto o aggiungere a quello vecchio?");
					Scanner insert = new Scanner(System.in);
					String ins= insert.nextLine();
			if(ins.equals("N")) {	
		Contatto newContatto = new Contatto();
		Scanner contatt = new Scanner(System.in);
		
		System.out.print("cognome: ");
		String cognome= contatt.nextLine();
		newContatto.setCognome(cognome);
		
		System.out.print("nome: ");
		String nome= contatt.nextLine();
		newContatto.setNome(nome);
		
		System.out.print("email: ");
		String email= contatt.nextLine();
		newContatto.setEmail(email);
		
		System.out.print("telefono: ");
		String telefono= contatt.nextLine();
		newContatto.setTelefono(telefono);
		
		System.out.print("note: ");
		String note= contatt.nextLine();
		newContatto.setNote(note);
		
		System.out.println("contatto PRE : " + newContatto);
		
		entityManager.persist(newContatto);
				
		System.out.println("contatto POST : " + newContatto);
				
			}else if(ins.equals("V")) {
					Recapiti aggRecapito = new Recapiti();
					Scanner recapito = new Scanner(System.in);
					
					System.out.print("id: ");
					int id= Integer.parseInt(recapito.nextLine());
					aggRecapito.setRubrica_id(id);
					
					System.out.print("recapito: ");
					String r= recapito.nextLine();	
					aggRecapito.setRecapito(r);
					
					System.out.print("tipo: ");
					String tipo= recapito.nextLine();
					aggRecapito.setTipo(tipo);
					
					System.out.print("descrizione: ");
					String desc= recapito.nextLine();
					aggRecapito.setDescr(desc);
					
					entityManager.persist(aggRecapito);
				}
				}
				
				
				
				
				
		//UPDATE
//		System.out.println("modifico : " + contatto);
//		//contatto.setId(20);
//		contatto.setNote("queste sono le note");
//		contatto.setNome("Piero");
//		entityManager.persist(contatto);
//		System.out.println("contatto POST update : " + contatto);
		
				
				
				
				
//		//DELETE
//		entityManager.remove(contatto);

				
				
				
				
				
		//SELECT JPQL
		if(st.equals("S")) {
		//Query query = entityManager.createQuery("SELECT r FROM Recapiti as r Join Contatto as c ON r.rubrica_id=c.id WHERE c.id='"+id+"'");		
		//System.out.println(query.getResultList());

		Query query=entityManager.createQuery("SELECT c FROM Contatto c");
		List<Contatto> contatto1=query.getResultList();
		
		query=entityManager.createQuery("SELECT r FROM Recapiti r");
		List<Recapiti> recapito=query.getResultList();
		
		for(Contatto c:contatto1) {
			System.out.println(c.toString());
			for(Recapiti r:recapito)
				if(c.getId()==r.getRubrica_id()) {
					if(r.getTipo().equals("E"))
						System.out.print("Email aggiuntiva: "+r.getRecapito());
					else if(r.getTipo().equals("T"))
						System.out.print("Telefono aggiuntivo: "+r.getRecapito());
					System.out.println("");
				}
			}
		}

		
		//if (true) throw new RuntimeException();
		
		entityTransaction.commit();
		//entityTransaction.rollback();

		entityManager.close();
	}

}
