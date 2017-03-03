/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *  
 *  Contributors:
 *  
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package your.basepackage.name;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.servlet.ServletContextEvent;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.apache.jena.rdf.model.Resource;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;

import your.basepackage.name.servlet.ServiceProviderCatalogSingleton;
import your.basepackage.name.ServiceProviderInfo;
import your.basepackage.name.resources.AResource;
import your.basepackage.name.resources.AnotherResource;
import your.basepackage.name.resources.ShaclShapeFactory;
import your.basepackage.name.resources.Shape;

// Start of user code imports
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.topbraid.shacl.util.ModelPrinter;

import es.weso.schema.Schema;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import es.weso.rdf.jena.RDFAsJenaModel;
import es.weso.schema.Result;
//End of user code

// Start of user code pre_class_code
// End of user code

public class SampleAdaptorManager {

    // Start of user code class_attributes
  private final static Logger log = LoggerFactory.getLogger(SampleAdaptorManager.class);
  // End of user code
    
    
    // Start of user code class_methods
  // End of user code

    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
        
        // Start of user code contextInitializeServletListener
    // End of user code
    }

    public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
    {
        
        // Start of user code contextDestroyed
    // End of user code
    }

    public static ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        ServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
	    ServiceProviderInfo x = new ServiceProviderInfo();
	    x.name = "1";
	    x.serviceProviderId = "1";
	    serviceProviderInfos = new ServiceProviderInfo[1];
	    serviceProviderInfos[0] = x;

	    try {
	    	Schema schema = Validator.getSchema("/aResource-Shape.ttl");
	    	if (schema != null) {
		    	RDFAsJenaModel rdf = Validator.getJenaModel("/aResource.ttl");
		    	if (rdf != null) {
		    	    Result r = Validator.validate(rdf, schema);
		    		if (!r.isValid())
		    			log.info(r.show());
		    		else
		    			log.info("Resource is Valid");
		    	}
	    	}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

    // End of user code
        return serviceProviderInfos;
    }

    public static List<AResource> queryAResources(HttpServletRequest httpServletRequest, final String serviceProviderId, String where, int page, int limit)
    {
        List<AResource> resources = null;
        
        // Start of user code queryAResources
    // End of user code
        return resources;
    }
    public static AResource createAResource(HttpServletRequest httpServletRequest, final AResource aResource, final String serviceProviderId)
    {
        AResource newResource = null;
        
        // Start of user code createAResource
    newResource = aResource;

    try {
    	Schema schema = Validator.getSchema("/aResource-Shape.ttl");
    	if (schema != null) {
	    		Result r = Validator.validate(aResource, schema);
	    		if (!r.isValid())
	    			log.info(r.show());
	    		else
	    			log.info("Resource is Valid");
	    	}
    } catch (Exception e) {
        e.printStackTrace();
    }

    // End of user code
        return newResource;
    }


    public static AResource getAResource(HttpServletRequest httpServletRequest, final String serviceProviderId, final String aResourceId)
    {
        AResource aResource = null;
        
        // Start of user code getAResource
    try {
      aResource = new AResource();
      aResource.setAbout(AResource.constructURI("1", "1"));
      aResource.setAStringProperty("1asdas11");
      aResource.setAnIntegerProperty(1234);
      aResource.addASetOfDates(new Date());
      aResource.addASetOfDates(new Date());
      Link aReferenceProperty = new Link();
      aReferenceProperty.setValue(new URI("http://www.sampledomain.org/sam#AnotherResource"));
	aResource.setAReferenceProperty(aReferenceProperty );
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
//
//    try {
//    	Schema schema = Validator.getSchema("/aResource-Shape.ttl");
//    	if (schema != null) {
//	    		Result r = Validator.validate(aResource, schema);
//	    		if (!r.isValid())
//	    			log.info(r.show());
//	    		else
//	    			log.info("Resource is Valid");
//	    	}
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
    
	try {
			Result r = aResource.validate();
    		if (!r.isValid())
    			log.info(r.show());
    		else
    			log.info("Resource is Valid");

	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    // End of user code
        return aResource;
    }




    public static String getETagFromAResource(final AResource aResource)
    {
        String eTag = null;
        // Start of user code getETagFromAResource
    // End of user code
        return eTag;
    }
}
