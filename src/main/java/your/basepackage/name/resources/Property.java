/*******************************************************************************
 * Copyright (c) 2012, 2013 IBM Corporation.
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
 *	   Samuel Padgett		- support allowed and default values other than string
 *******************************************************************************/
package your.basepackage.name.resources;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import com.github.jsonldjava.core.RDFDataset.Literal;

@OslcNamespace(ShaclConstants.SHACL_CORE_NAMESPACE)
@OslcName("property")
@OslcResourceShape(title = "SHACL Property Resource Shape", describes = ShaclConstants.TYPE_PROPERTY)
public final class Property extends AbstractResource {

	private URI predicate;
	private ValueType dataType;
	private BigInteger minCount;
	private BigInteger maxCount;
	
	private Literal minExclusive;
	private Literal maxExclusive;
	private Literal minInclusive;
	private Literal maxInclusive;
	private BigInteger minLength;
	private BigInteger maxLength;
	private Literal pattern;
	private List<Literal> languageIn;
	private Boolean uniqueLang;
	private URI equals;
	
	public Property() {
		super();
	}

	public Property(final URI predicate,
			final ValueType dataType, final BigInteger minCount, final BigInteger maxCount) {
		this();

		this.predicate = predicate;
		this.dataType = dataType;
		this.minCount = minCount;
		this.maxCount = maxCount;
	}

	@OslcDescription("predicate of a property")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "predicate")
	@OslcReadOnly
	@OslcName("predicate")
	public URI getPredicate() {
		return predicate;
	}

	public void setPredicate(URI predicate) {
		this.predicate = predicate;
	}

	@OslcAllowedValue({OslcConstants.XML_NAMESPACE + "boolean",
		OslcConstants.XML_NAMESPACE + "dateTime",
		OslcConstants.XML_NAMESPACE + "decimal",
		OslcConstants.XML_NAMESPACE + "double",
		OslcConstants.XML_NAMESPACE + "float",
		OslcConstants.XML_NAMESPACE + "integer",
		OslcConstants.XML_NAMESPACE + "string",
		OslcConstants.RDF_NAMESPACE + "XMLLiteral",
		ShaclConstants.SHACL_CORE_NAMESPACE + "Resource",
		ShaclConstants.SHACL_CORE_NAMESPACE + "LocalResource",
		ShaclConstants.SHACL_CORE_NAMESPACE + "AnyResource"})
	@OslcDescription("See list of allowed values for sh:datatype")
	@OslcOccurs(Occurs.ExactlyOne)
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "datatype")
	@OslcReadOnly
	@OslcName("datatype")
	@OslcTitle("Data Type")
	public URI getDataType() {
		if (dataType != null) {
			try {
				return new URI(dataType.toString());
			} catch (final URISyntaxException exception) {
				// This should never happen since we control the possible values of the ValueType enum.
				throw new RuntimeException(exception);
			}
		}

		return null;
	}

	@OslcDescription("Specifies the min count")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "minCount")
	@OslcReadOnly
	@OslcTitle("Min Count")
	@OslcValueType(ValueType.Integer)
	public BigInteger getMinCount() {
		return minCount;
	}

	@OslcDescription("Specifies the max count")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "maxCount")
	@OslcReadOnly
	@OslcTitle("Max Count")
	@OslcValueType(ValueType.Integer)
	public BigInteger getMaxCount() {
		return maxCount;
	}

	@OslcDescription("Specifies the range: Min Exclusive")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "minExclusive")
	@OslcValueType(ValueType.XMLLiteral)
	@OslcTitle("Range Min Exclusive")
	public Literal getMinExclusive() {
		return minExclusive;
	}

	@OslcDescription("Specifies the range: Max Exclusive")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "maxExclusive")
	@OslcValueType(ValueType.XMLLiteral)
	@OslcTitle("Range Max Exclusive")
	public Literal getMaxExclusive() {
		return maxExclusive;
	}

	@OslcDescription("Specifies the range: Min Inclusive")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "minInclusive")
	@OslcValueType(ValueType.XMLLiteral)
	@OslcTitle("Range Min Inclusive")
	public Literal getMinInclusive() {
		return minInclusive;
	}

	@OslcDescription("Specifies the range: Max Inclusive")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "maxInclusive")
	@OslcValueType(ValueType.XMLLiteral)
	@OslcTitle("Range Max Inclusive")
	public Literal getMaxInclusive() {
		return maxInclusive;
	}

	@OslcDescription("Specifies the minimum string length of each value node that satisfies the condition.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "minLength")
	@OslcValueType(ValueType.Integer)
	@OslcTitle("Minimum Length")
	public BigInteger getMinLength() {
		return minLength;
	}

	@OslcDescription("Specifies the maximum string length of each value node that satisfies the condition.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "maxLength")
	@OslcValueType(ValueType.Integer)
	@OslcTitle("Maximum Length")
	public BigInteger getMaxLength() {
		return maxLength;
	}

	@OslcDescription("Specifies a regular expression that each value node matches to satisfy the condition.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "pattern")
	@OslcValueType(ValueType.String)
	@OslcTitle("Pattern")
	public Literal getPattern() {
		return pattern;
	}

	@OslcDescription("Specifies the allowed language tags for each value node limited by a given list of language tags.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "languageIn")
	@OslcValueType(ValueType.String)
	@OslcTitle("LanguageIn")
	public List<Literal> getLanguageIn() {
		return languageIn;
	}

	@OslcDescription("Specifies that no pair of value nodes may use the same language tag if set true.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "uniqueLang")
	@OslcValueType(ValueType.Boolean)
	@OslcTitle("UniqueLang")
	public Boolean getUniqueLang() {
		return uniqueLang;
	}

	@OslcDescription("Specifies the condition that the set of all value nodes is equal to the set of objects of the triples that have the focus node as subject and the value of sh:equals as predicate.")
	@OslcPropertyDefinition(ShaclConstants.SHACL_CORE_NAMESPACE + "equals")
	@OslcTitle("Equals")
	public URI getEquals() {
		return equals;
	}

	public void setMinExclusive(Literal minExclusive) {
		this.minExclusive = minExclusive;
	}

	public void setMaxExclusive(Literal maxExclusive) {
		this.maxExclusive = maxExclusive;
	}

	public void setMinInclusive(Literal minInclusive) {
		this.minInclusive = minInclusive;
	}

	public void setMaxInclusive(Literal maxInclusive) {
		this.maxInclusive = maxInclusive;
	}

	public void setMinLength(BigInteger minLength) {
		this.minLength = minLength;
	}

	public void setMaxLength(BigInteger maxLength) {
		this.maxLength = maxLength;
	}

	public void setPattern(Literal pattern) {
		this.pattern = pattern;
	}

	public void setLanguageIn(List<Literal> languageIn) {
		this.languageIn = languageIn;
	}

	public void setUniqueLang(Boolean uniqueLang) {
		this.uniqueLang = uniqueLang;
	}

	public void setEquals(URI equals) {
		this.equals = equals;
	}

	public void setDataType(ValueType dataType) {
		this.dataType = dataType;
	}
	
	public void setMinCount(BigInteger minCount) {
		this.minCount = minCount;
	}

	public void setMaxCount(BigInteger maxCount) {
		this.maxCount = maxCount;
	}

	@Override
	public String toString() {
		return "Property [predicate=" + predicate + ", dataType=" + dataType + ", minCount=" + minCount + ", maxCount="
				+ maxCount + ", minExclusive=" + minExclusive + ", maxExclusive=" + maxExclusive + ", minInclusive="
				+ minInclusive + ", maxInclusive=" + maxInclusive + ", minLength=" + minLength + ", maxLength="
				+ maxLength + ", pattern=" + pattern + ", languageIn=" + languageIn + ", uniqueLang=" + uniqueLang
				+ ", equals=" + equals + "]";
	}


}
