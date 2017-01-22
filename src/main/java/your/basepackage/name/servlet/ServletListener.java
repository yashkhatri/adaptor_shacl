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
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package your.basepackage.name.servlet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import your.basepackage.name.SampleAdaptorManager;

// Start of user code imports
// End of user code

public class ServletListener implements ServletContextListener  {
    private static String servletBase = null;
    private static String servicesBase = null;

    private static final String SERVICES_PATH = "/services";

    private static final String PROPERTY_SCHEME = ServletListener.class.getPackage().getName() + ".scheme";
    private static final String PROPERTY_PORT = ServletListener.class.getPackage().getName() + ".port";
    private static final Logger LOGGER = Logger.getLogger(ServletListener.class.getName());
    private static final String HOST = getHost();

    // Start of user code class_attributes
	// End of user code

    // Start of user code class_methods
	// End of user code

    public ServletListener() {
        super();
    }

    private static String getHost() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (final UnknownHostException exception) {
            return "localhost";
        }
    }

    public static String getServletBase() {
        return servletBase;
    }

    public static String getServicesBase() {
        return servicesBase;
    }

    private static String generateBasePath(final ServletContextEvent servletContextEvent)
    {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        String scheme = System.getProperty(PROPERTY_SCHEME);
        if (scheme == null)
        {
            scheme = servletContext.getInitParameter(PROPERTY_SCHEME);
        }

        String port = System.getProperty(PROPERTY_PORT);
        if (port == null)
        {
            port = servletContext.getInitParameter(PROPERTY_PORT);
        }

        System.out.println(scheme + "://" + HOST + ":" + port + servletContext.getContextPath());

        return scheme + "://" + HOST + ":" + port + servletContext.getContextPath();
    }

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent)
    {
        // Start of user code contextInitialized_init
		// End of user code

        String basePath=generateBasePath(servletContextEvent);
        servletBase = basePath;
        servicesBase = basePath + SERVICES_PATH;

        LOGGER.log(Level.INFO, "servletListner contextInitialized.");

        // Establish connection to data backbone etc ...
        SampleAdaptorManager.contextInitializeServletListener(servletContextEvent);

        // Start of user code contextInitialized_final
		// End of user code
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        // Start of user code contextDestroyed_init
		// End of user code

        // Shutdown connections to data backbone etc...
        SampleAdaptorManager.contextDestroyServletListener(servletContextEvent);

        // Start of user code contextDestroyed_final
		// End of user code
    }

}

