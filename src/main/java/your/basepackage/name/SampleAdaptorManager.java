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
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse
 *     .org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package your.basepackage.name;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;

import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Option;
import your.basepackage.name.servlet.ServiceProviderCatalogSingleton;
import your.basepackage.name.ServiceProviderInfo;
import your.basepackage.name.resources.AResource;

// Start of user code imports

import es.weso.shacl.Validator;
import scala.util.Success;
import scala.util.Try;
import es.weso.schema.Schema;
import es.weso.rdf.jena.RDFAsJenaModel;
import java.io.File;
import es.weso.schema.Schemas;
import es.weso.schema.Result;
import es.weso.rdf.PrefixMap;

// End of user code

// Start of user code pre_class_code
// End of user code

public class SampleAdaptorManager {

  // Start of user code class_attributes
  private final static Logger log = LoggerFactory.getLogger(SampleAdaptorManager.class);
  // End of user code

  // Start of user code class_methods
  private static CharSequence fileAsCharSequence(final File file) throws IOException {
    return new String(Files.readAllBytes(file.toPath()));
  }

  private static CharSequence streamAsCharSequence(final InputStream inputStream)
    throws IOException {
    return IOUtils.toString(inputStream, Charset.forName("UTF-8"));
  }
  // End of user code

  public static void contextInitializeServletListener(
    final ServletContextEvent servletContextEvent) {
    // TODO Implement code to establish connection to data backbone etc ...

    // Start of user code contextInitializeServletListener
    // End of user code
  }

  public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) {
    // TODO Implement code to shutdown connections to data backbone etc...

    // Start of user code contextDestroyed
    // End of user code
  }

  public static ServiceProviderInfo[] getServiceProviderInfos(
    HttpServletRequest httpServletRequest) {
    ServiceProviderInfo[] serviceProviderInfos = {};
    // TODO Implement code to return the set of ServiceProviders

    // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
    ServiceProviderInfo x = new ServiceProviderInfo();
    x.name = "1";
    x.serviceProviderId = "1";
    serviceProviderInfos = new ServiceProviderInfo[1];
    serviceProviderInfos[0] = x;

    Option<String> none = Option.<String>apply(null);
//			String modelPath = "/Users/andrew/kth/tempcode/shaclex/examples/shacl/good1-d.ttl";
//			File file = new File(modelPath);
    InputStream rdfStream = SampleAdaptorManager.class.getResourceAsStream("/good1-d.ttl");
//            Try<RDFAsJenaModel> rdf_try = RDFAsJenaModel.fromChars(fileAsCharSequence(file),
//				"TURTLE", none);
    Try<RDFAsJenaModel> rdf_try = null;
    CharSequence rdfstreamAsCharSequence = null;
    try {
      rdfstreamAsCharSequence = streamAsCharSequence(rdfStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    rdf_try = RDFAsJenaModel.fromChars(rdfstreamAsCharSequence, "TURTLE", none);

//			String schemaPath = "/Users/andrew/kth/tempcode/shaclex/examples/shacl/good1-s.ttl";
//			File fileSchema = new File(schemaPath);
    InputStream schemaStream = SampleAdaptorManager.class.getResourceAsStream("/good1-s.ttl");
    CharSequence streamAsCharSequence = null;
    try {
      streamAsCharSequence = streamAsCharSequence(schemaStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    validate_v55(none, rdf_try, streamAsCharSequence);

//    validate_v54(rdfstreamAsCharSequence, streamAsCharSequence);

    // End of user code
    return serviceProviderInfos;
  }

  private static void validate_v55(final Option<String> none, final Try<RDFAsJenaModel> rdf_try,
    final CharSequence streamAsCharSequence) {
    Try<Schema> schema_try = Schemas.fromString(streamAsCharSequence, "TURTLE", "ShaClex", none);

    String trigger = "TargetDecls";

    if (rdf_try.isSuccess() && schema_try.isSuccess()) {
      RDFAsJenaModel rdf = rdf_try.get();
      Schema schema = schema_try.get();

      PrefixMap nodeMap = rdf.getPrefixMap();
      PrefixMap shapesMap = schema.pm();

      Result r = schema.validate(rdf, trigger, none, none, nodeMap, shapesMap);

      log.info(r.show());
    }
  }

  private static void validate_v54(final CharSequence rdfstreamAsCharSequence,
    final CharSequence streamAsCharSequence) {
//    Option<String> base = Option.apply(null);
//    List<String> emptyErrors = new ArrayList<>();
//    Try<Schema> t = Schemas.fromString(streamAsCharSequence, "TURTLE", "SHACLex", base);
//    if (t.isSuccess()) {
//      Schema s = t.get();
//      Try<String> tstr = s.serialize("TURTLE");
//      if (tstr.isSuccess()) {
//        Try<RDFAsJenaModel> trdf = RDFAsJenaModel.fromChars(rdfstreamAsCharSequence, "TURTLE",
//          base);
//        if (trdf.isSuccess()) {
//          Result r = s.validate(trdf.get());
//          String strResult = r.serialize("TURTLE");
//          log.debug(strResult);
//        }
//      }
//    }
}

  public static List<AResource> queryAResources(HttpServletRequest httpServletRequest,
    final String serviceProviderId, String where, int page, int limit) {
    List<AResource> resources = null;
    // TODO Implement code to return a set of resources

    // Start of user code queryAResources
    // End of user code
    return resources;
  }

  public static AResource createAResource(HttpServletRequest httpServletRequest,
    final AResource aResource, final String serviceProviderId) {
    AResource newResource = null;
    // TODO Implement code to create a resource

    // Start of user code createAResource
    newResource = aResource;
    // End of user code
    return newResource;
  }

  public static AResource getAResource(HttpServletRequest httpServletRequest,
    final String serviceProviderId, final String aResourceId) {
    AResource aResource = null;
    // TODO Implement code to return a resource

    // Start of user code getAResource
    try {
      aResource = new AResource();
      aResource.setAbout(AResource.constructURI("1", "1"));
      //aResource.setAProperty("111");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    // End of user code
    return aResource;
  }

  public static String getETagFromAResource(final AResource aResource) {
    String eTag = null;
    // TODO Implement code to return an ETag for a particular resource
    // Start of user code getETagFromAResource
    // End of user code
    return eTag;
  }
}
