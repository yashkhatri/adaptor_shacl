package your.basepackage.name;

import es.weso.rdf.PrefixMap;
import es.weso.rdf.jena.RDFAsJenaModel;
import es.weso.schema.Result;
import es.weso.schema.Schema;
import es.weso.schema.Schemas;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.jena.rdf.model.Model;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.provider.jena.JenaModelHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Option;
import scala.util.Try;
import your.basepackage.name.resources.AResource;

public class Validator {
	public static final Option<String> OPTION_NONE = Option.apply(null);
	private final static Logger log = LoggerFactory.getLogger(Validator.class);

	public static CharSequence streamAsCharSequence(final InputStream inputStream) throws IOException {
		return IOUtils.toString(inputStream, Charset.forName("UTF-8"));
	}
	
	public static CharSequence load(final String resourcePath, final String msg) throws IOException {
		InputStream schemaStream = Validator.class.getResourceAsStream(resourcePath);
		CharSequence streamAsCharSequence;
		try {
			streamAsCharSequence = streamAsCharSequence(schemaStream);
		} catch (IOException e) {
			log.error(msg, e);
			throw e;
		}
		return streamAsCharSequence;
	}

	public static RDFAsJenaModel getJenaModel(String fileName) {
		RDFAsJenaModel rdf = null;
	    try {
			CharSequence charSequence = Validator.load(fileName, "Error reading data from stream");
			Try<RDFAsJenaModel> rdfTry = RDFAsJenaModel.fromChars(charSequence, "TURTLE", OPTION_NONE);

			if (rdfTry.isSuccess()) {
				rdf = rdfTry.get();
			}
	    } catch (IOException e) {
	    	log.error("Error invoking validator", e);
	    }
	    return rdf;
	}

	public static Schema getSchema(String fileName) {
		Schema schema = null;
	    try {
			CharSequence charSequence = Validator.load(fileName, "Error reading schema from stream");
			Try<Schema> schemaTry = Schemas.fromString(charSequence, "TURTLE", "SHACLex", OPTION_NONE);

			if (schemaTry.isSuccess()) {
				schema = schemaTry.get();
			}
	    } catch (IOException e) {
	    	log.error("Error invoking validator", e);
	    }
	    return schema;
	}

	public static Result validate(final RDFAsJenaModel rdf, final Schema schema) {
		PrefixMap nodeMap = rdf.getPrefixMap();
		PrefixMap shapesMap = schema.pm();
		Result r = schema.validate(rdf, "TargetDecls", OPTION_NONE, OPTION_NONE, nodeMap, shapesMap);
		//log.info(r.show());
		return r;
	}
	
	public static Result validate(AbstractResource aResource, Schema schema) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, DatatypeConfigurationException, OslcCoreApplicationException {
		Model resourceAsModel = JenaModelHelper.createJenaModel(new Object[]{aResource});
		RDFAsJenaModel resourceAsRDFReader = new RDFAsJenaModel(resourceAsModel); 
		return Validator.validate(resourceAsRDFReader, schema);
	}

}
