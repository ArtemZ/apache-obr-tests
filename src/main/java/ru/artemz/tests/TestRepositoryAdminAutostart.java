package ru.artemz.tests;
import org.apache.felix.bundlerepository.RepositoryAdmin;
import org.apache.felix.main.AutoProcessor;
import org.osgi.framework.*;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
class TestRepositoryAdminAutostart {
	public static void main(String[] args) throws Exception {
		Framework framework = null;
		BundleContext bundleContext;
		RepositoryAdmin repositoryAdmin;
		Map config = new HashMap();
		config.put( "felix.auto.start.2", "file:///home/artemz/Documents/multicabinet/base-bundles/org.apache.felix.bundlerepository-2.0.2.jar" );
		FrameworkFactory frameworkFactory = (FrameworkFactory) ServiceLoader.load(FrameworkFactory.class).iterator().next();
        	framework = frameworkFactory.newFramework(config);
        	try {
            	framework.init();
	
        	    AutoProcessor.process(config,framework.getBundleContext());
	
        	    framework.start();
	        } catch (BundleException e){
        	    e.printStackTrace();
       		//TODO: log exceptions
       		}
        	bundleContext = framework.getBundleContext();	
	}
}
