package main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import main.model.Product;

public class HibernateUtil {
	private static HibernateUtil instance;
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(main.model.Client.class);
		config.addAnnotatedClass(main.model.Driver.class);
		config.addAnnotatedClass(main.model.Vehicle.class);
		config.addAnnotatedClass(main.model.Doctor.class);
		config.addAnnotatedClass(main.model.Patient.class);
		config.addAnnotatedClass(main.model.Visit.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		sessionFactory = config.buildSessionFactory();
	}

	public static HibernateUtil instance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	public Session openTransaction() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		return session;
	}

	public void commitTransaction(Session session) {
		session.getTransaction().commit();
	}
}
