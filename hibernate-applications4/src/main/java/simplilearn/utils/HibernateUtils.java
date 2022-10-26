package simplilearn.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				//load hibernate.cfg.xml
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				
				  MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
	                
	                Metadata metadata = metadataSources.getMetadataBuilder().build();
	                
	                
	                sessionFactory = metadata.getSessionFactoryBuilder().build();
	            }catch ( Exception e) {
	                e.printStackTrace();
	                
	                if ( standardServiceRegistry != null ) {
	                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	                }
	            }
	        }
	        return sessionFactory;
	    }
	}


