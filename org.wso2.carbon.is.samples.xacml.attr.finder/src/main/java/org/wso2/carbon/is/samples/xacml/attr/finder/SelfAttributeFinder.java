package org.wso2.carbon.is.samples.xacml.attr.finder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.wso2.carbon.identity.entitlement.pip.AbstractPIPAttributeFinder;

public class SelfAttributeFinder extends AbstractPIPAttributeFinder {

	private final String MY_ACCOUNT_CLAIM = "http://wso2.org/claims/myaccount";
	private Set<String> supportedAttributes = new HashSet<String>();
	private Map<String, String> subjectToAccountMap = new HashMap<String, String>();

	@Override
	public String getModuleName() {
		return "org.wso2.carbon.is.samples.xacml.attr.finder.SelfAttributeFinder";
	}

	@Override
	public Set<String> getSupportedAttributes() {
		return supportedAttributes;
	}

	@Override
	public void init(Properties props) throws Exception {
		supportedAttributes.add(MY_ACCOUNT_CLAIM);
		subjectToAccountMap.put("peter", "3333");
		subjectToAccountMap.put("alex", "1111");
		subjectToAccountMap.put("john", "2222");
	}

	@Override
	public Set<String> getAttributeValues(String subjectId, String resourceId, String actionId, String environmentId,
			String attributeId, String issuer) throws Exception {
		Set<String> results = new HashSet<String>();

		if (resourceId != null) {
			String accountNumber = resourceId.substring(resourceId.lastIndexOf("/") + 1);
			System.out.println("Account Number: " + accountNumber);
			String myAccountNumber = subjectToAccountMap.get(subjectId.toLowerCase());

			if (myAccountNumber != null && myAccountNumber.equals(accountNumber)) {
				results.add("true");
			} else {
				results.add("false");
			}
		} else {
			results.add("false");
		}

		return results;
	}
}
