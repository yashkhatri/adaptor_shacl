/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *	
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *	   Russell Boykin		- initial API and implementation
 *	   Alberto Giammaria	- initial API and implementation
 *	   Chris Peters			- initial API and implementation
 *	   Gianluca Bernardini	- initial API and implementation
 *******************************************************************************/
package your.basepackage.name.resources;

import java.net.URI;
import java.util.TreeMap;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

@OslcNamespace(ShaclConstants.SHACL_CORE_NAMESPACE)
@OslcName("Shape")
@OslcResourceShape(title = "Shacl Resource Shape", describes = ShaclConstants.TYPE_SHACL_SHAPE)
public final class Shape extends AbstractResource {
	private URI targetClass = null;
	private final TreeMap<URI, Property> properties = new TreeMap<URI, Property>();


	public Shape() {
		super();
	}

	public Shape(final URI about) {
		super(about);
	}

	public void addtargetClass(final URI targetClass) {
		this.targetClass = targetClass;
	}

	@OslcDescription("Type or types of resource described by this shape")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "targetClass")
	@OslcReadOnly
	@OslcTitle("targetClass")
	public URI getTargetClass() {
		return targetClass;
	}
	
	public void setTargetClass(final URI targetClass) {
		if (targetClass != null) {
			this.targetClass = targetClass;
		}
	}
	public void addProperty(final Property property) {
		this.properties.put(property.getPredicate(), property);
	}
	
	//Bugzilla 392780
	public Property getShaclProperty(URI definition) {
		return properties.get(definition);
	}

	@OslcDescription("The properties that are allowed or required by this shape")
	@OslcName("property")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "property")
	@OslcRange(ShaclConstants.TYPE_PROPERTY)
	@OslcReadOnly
//	@OslcRepresentation(Representation.Inline)
	@OslcTitle("Properties")
//	@OslcValueShape(ShaclConstants.PATH_SHACL_SHAPE + "/" + OslcConstants.PATH_PROPERTY)
	@OslcValueType(ValueType.LocalResource)
	public Property[] getShaclProperties() {
		return properties.values().toArray(new Property[properties.size()]);
	}

	public void setShaclProperties(final Property[] properties) {
		this.properties.clear();
		if (properties != null) {
			for(Property prop :properties) {
				this.properties.put(prop.getPredicate(), prop);
			}
		}
	}

	@Override
	public String toString() {
		return "Shape [targetClass=" + targetClass + ", properties=" + properties + "]";
	}

}
