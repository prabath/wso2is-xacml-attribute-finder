# XACML Attribute Finder for WSO2 Identity Server

1. Build and copy target/org.wso2.carbon.is.samples.xacml.attr.finder-1.0.0.jar to wso2is-5.8.0/repository/components/lib
2. Edit the file wso2is-5.8.0/repository/conf/identity/entitlement.properties and add the following.
PIP.AttributeDesignators.Designator.3=org.wso2.carbon.is.samples.xacml.attr.finder.SelfAttributeFinder
