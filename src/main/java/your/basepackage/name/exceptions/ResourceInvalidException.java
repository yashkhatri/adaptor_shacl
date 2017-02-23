package your.basepackage.name.exceptions;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

/**
 * Base class for all application exceptions.
 */
public final class ResourceInvalidException extends Exception {
	private static final long serialVersionUID = -5933150329026674184L;
	
	String message;
	Model model;
	Resource report;
	public ResourceInvalidException(String message) {
		super(message);
		this.message = message;
	}

	public ResourceInvalidException(Model model) {
	this.model = model;
	}
	
	public ResourceInvalidException(Resource report) {
	this.report = report;
	}

	public void setReport(Resource report) {
		this.report = report;
	}

	public Resource getReport() {
		return report;
	}
	
	public Model getModel() {
		return model;
	}
	

	@Override
	public String toString() {
		return "ResourceInvalidException [message=" + message + "]";
	}

}