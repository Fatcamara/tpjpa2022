package jpa;

import jpa.DAO.EtdDAO;
import jpa.DAO.ProfDAO;
import jpa.DAO.RdvDAO;
import jpa.DAO.UserDAO;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
//import javax.persistence.PersistenceContext;

public class JpaTest {


	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		//tx.begin();

		 /**manager.persist( new ProfJPA("lArgo"));
		 manager.persist(new ProfJPA("Algo"));
		 manager.persist (new ProfJPA("Reseaux"));
		 manager.persist(new EtdJPA( 2026,"informatique"));
		 manager.persist(new EtdJPA(2028,"informatique"));**/

	//why en comment, ils st ds la bdd??????

		/**try {
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		EtdDAO dao = new EtdDAO();
		EtdJPA etd = new EtdJPA();
		etd.setName("Mani");
		dao.save(etd);

		ProfDAO dao1 = new ProfDAO();
		ProfJPA etd1 = new ProfJPA();
		etd1.setName("Kalou");
		dao1.save(etd1);

		EtdDAO dao2 = new EtdDAO();
		EtdJPA etd2 = new EtdJPA();
		etd2.setName("Mora");
		dao2.save(etd2);

		EtdDAO dao3 = new EtdDAO();
		EtdJPA etd3 = new EtdJPA();
		etd3.setName("Makhira");
		dao3.save(etd3);

		UserDAO dao4 = new UserDAO();
		UserJPA etd4 = new UserJPA();
		etd4.setName("Makourra");
		dao4.save(etd4);

		UserDAO dao5 = new UserDAO();
		UserJPA etd5 = new UserJPA();
		etd5.setName("Mama");
		dao5.save(etd5);

		UserDAO dao6 = new UserDAO();
		UserJPA etd6 = new UserJPA();
		etd6.setName("Tata");
		dao6.save(etd6);

		UserDAO dao8 = new UserDAO();
		UserJPA etd8 = new UserJPA();
		etd8.setName("Tatata");
		etd8.setEmail("camaratata@yahh");
		dao8.save(etd8);

		ProfDAO dao7 = new ProfDAO();
		ProfJPA pro7 = new ProfJPA();
		pro7.setName("Oumar");
		dao7.save(pro7);

		/**RdvDAO daor = new RdvDAO();
		RdvJPA rdv = new RdvJPA();
		Date date = new Date();
		SimpleDateFormat Datee = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = Datee.format(date);
		rdv.setDatee("02/09/2022");
		daor.save(rdv);*/

		//daor.save(St);
		/**Calendar calendarDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendarDate.set(Calendar.YEAR, 2017);
		calendarDate.set(Calendar.MONTH, 10);
		calendarDate.set(Calendar.DAY_OF_MONTH, 15);
		//temporalValues.setCalendarDate(calendarDate);
        // Revoir apres
		//rdv.setTime(18:00);
		 daor.save(rdv);*/

	 ProfDAO pdao = new ProfDAO();
		/**CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ProfJPA> queryy = builder.createQuery(ProfJPA.class);
		Root<ProfJPA> i = queryy.from(ProfJPA.class);
		queryy.select(i);
		List<ProfJPA> professeurs = manager.createQuery(queryy).getResultList();

	    	for (ProfJPA b : professeurs)  {

			System.out.println(b.getName());
			System.out.println(b.getEmail());
			System.out.println(b.getMatiere());

		}*/
		for (ProfJPA b : pdao.getallProf())  {

			System.out.println(b.getName());
			System.out.println(b.getEmail());
			System.out.println(b.getMatiere());

//(professeurs: i )
//Why on ne rend pas persistant nos objets lorsqu'on passe le DAO????
//au dela de 3 enreg il n'affiche pas le nom=null, ceux en comment apparaissent,why?????
//but DAO, pas de dpendance du code métier avec du code hibernate(usage des objt,pas d'elmt hibernate, decouplage des couches).
//why ils vont tous ds user table????
	//tx.commit();

	/**	manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();*/
	}
}
}
