package hibernatejsf.factory;

import java.io.Closeable;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.facelets.ComponentConfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Matheus Silva de Almeida "almeida-matheus@hotmail.com.br".
 * @version 1.0
 * @since 17/07/2015 14:25:48
 */
public class SessionFactoryProvider{
	
	/**
	 * SessionFactory variable.
	 */	
	private static SessionFactory sessionFactory;
	
	/**
	 * This Method is responsible for SessionFactory built.
	 * @return Is SessionFactory built.
	 */	
	public static SessionFactory getSessionFactory(){
				
		if(sessionFactory == null){
			
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		}		
		return sessionFactory;
	}
	
}
