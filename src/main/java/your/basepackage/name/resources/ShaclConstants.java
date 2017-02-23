package your.basepackage.name.resources;

public interface ShaclConstants {


	public static final String SHACL_CORE_NAMESPACE		= "http://www.w3.org/ns/shacl#";
	public static final String SHACL_CORE_NAMESPACE_PREFIX = "sh";
	
	public static final String EXAMPLEORG_CORE_NAMESPACE		= "http://example.org/";
	public static final String EXAMPLEORG_CORE_NAMESPACE_PREFIX = "ex";

	public static final String XML_NAMESPACE			= "http://www.w3.org/2001/XMLSchema#";
	public static final String XML_NAMESPACE_PREFIX	    = "xsd";

	//check if below properties are needed or not
	public static final String TYPE_ALLOWED_VALUES			 = SHACL_CORE_NAMESPACE + "AllowedValues";
	public static final String TYPE_COMPACT					 = SHACL_CORE_NAMESPACE + "Compact";
	public static final String TYPE_CREATION_FACTORY		 = SHACL_CORE_NAMESPACE + "CreationFactory";
	public static final String TYPE_DIALOG					 = SHACL_CORE_NAMESPACE + "Dialog";
	public static final String TYPE_ERROR					 = SHACL_CORE_NAMESPACE + "Error";
	public static final String TYPE_EXTENDED_ERROR			 = SHACL_CORE_NAMESPACE + "ExtendedError";
	public static final String TYPE_O_AUTH_CONFIGURATION	 = SHACL_CORE_NAMESPACE + "OAuthConfiguration";
	public static final String TYPE_PREFIX_DEFINITION		 = SHACL_CORE_NAMESPACE + "PrefixDefinition";
	public static final String TYPE_PREVIEW					 = SHACL_CORE_NAMESPACE + "Preview";
	public static final String TYPE_PROPERTY				 = SHACL_CORE_NAMESPACE + "Property";
	public static final String TYPE_PUBLISHER				 = SHACL_CORE_NAMESPACE + "Publisher";
	public static final String TYPE_QUERY_CAPABILITY		 = SHACL_CORE_NAMESPACE + "QueryCapability";
	public static final String TYPE_SHACL_SHAPE			     = SHACL_CORE_NAMESPACE + "Shape";
	public static final String TYPE_RESPONSE_INFO			 = SHACL_CORE_NAMESPACE + "ResponseInfo";
	public static final String TYPE_SERVICE					 = SHACL_CORE_NAMESPACE + "Service";
	public static final String TYPE_SERVICE_PROVIDER		 = SHACL_CORE_NAMESPACE + "ServiceProvider";
	public static final String TYPE_SERVICE_PROVIDER_CATALOG = SHACL_CORE_NAMESPACE + "ServiceProviderCatalog";

	public static final String PATH_SHACL_SHAPE = "shaclShape";

}
