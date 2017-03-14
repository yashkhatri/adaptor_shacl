package your.basepackage.name.resources;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.jena.rdf.model.Resource;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.topbraid.shacl.util.ModelPrinter;

import es.weso.schema.Result;
import es.weso.schema.Schema;
import your.basepackage.name.Validator;

public class Tester {

	public static void main(String[] args) {
		
		  AResource aResource = null;
	        
	        // Start of user code getAResource
	    try {
	      aResource = new AResource();
	      aResource.setAbout(new URI("http://www.sampledomain.org/sam#AResource"));
	      aResource.setAStringProperty("sas");
	      aResource.setAnIntegerProperty(1234);
	      aResource.addASetOfDates(new Date());
	      Link aReferenceProperty = new Link();
	      aReferenceProperty.setValue(new URI("http://www.sampledomain.org/sam#AnotherResource"));
		  aResource.setAReferenceProperty(aReferenceProperty );
		  
		  Schema schema = Validator.getSchema("/aResource-Shape.ttl");
			Result r = Validator.validate(aResource, schema);
			System.out.println(r.errors());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

		
		

	}

	 public static AResource getAResource() 
	    {
	        AResource aResource = null;
	        
	        // Start of user code getAResource
	    try {
	      aResource = new AResource();
	      aResource.setAbout(new URI("http://www.sampledomain.org/sam#AResource"));
	      aResource.setAStringProperty("Yash");
	      aResource.setAnIntegerProperty(1234);
	      aResource.addASetOfDates(new Date());
	      Link aReferenceProperty = new Link();
	      aReferenceProperty.setValue(new URI("http://www.sampledomain.org/sam#AnotherResource"));
		  aResource.setAReferenceProperty(aReferenceProperty );
	    } catch (URISyntaxException e) {
	      e.printStackTrace();
	    }
	    
			Shape shaclShape = null;
			try {
				shaclShape = ShaclShapeFactory.createShaclShape(AResource.class);
				System.out.println("INITIATED");
				if (shaclShape != null) {
					Resource report = Validator.validate(aResource, shaclShape, true);
					System.out.println(ModelPrinter.get().print(report.getModel()));


				}
			} catch (OslcCoreApplicationException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// End of user code
			return aResource;
		}
}
