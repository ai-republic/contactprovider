/**
   Copyright 2015 Torsten Oltmanns, ai-republic GmbH, Germany

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.airepublic.contactprovider.api;

import java.util.HashMap;
import java.util.Map;

import com.airepublic.configuration.api.AbstractConfiguration;
import com.airepublic.configuration.api.ConfigurationServiceException;

/**
 * Configuration mapping {@link ContactType} to {@link IContactProvider} classes.
 *  
 * @author Torsten.Oltmanns@ai-republic.com
 */
public class ContactProviderConfiguration extends AbstractConfiguration {
	private static final long serialVersionUID = -1104845935281011750L;
	public final static String CONFIG_ID = ContactProviderConfiguration.class.getSimpleName();
	private Map<ContactType, String> classesTypeMap = new HashMap<ContactType, String>();
	
	/**
	 * Constructor.
	 */
	public ContactProviderConfiguration() {
	}

	@Override
	public void resetToDefault() throws ConfigurationServiceException {
		classesTypeMap = new HashMap<ContactType, String>();
		classesTypeMap.put(ContactType.EMAIL, "com.airepublic.service.contact.provider.EmailContactProvider");
	}

	/**
	 * @return the classesTypeMap
	 */
	public Map<ContactType, String> getClassesTypeMap() {
		return classesTypeMap;
	}

	/**
	 * @param classesTypeMap the classesTypeMap to set
	 */
	public void setClassesTypeMap(Map<ContactType, String> classesTypeMap) {
		this.classesTypeMap = classesTypeMap;
	}
}
