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

import java.io.Serializable;


/**
 * Defines a way to contact somebody.
 * 
 * @author Torsten.Oltmanns@ai-republic.com
 */
public interface IContactDetail<D> extends Serializable {
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	String getId();
	
	/**
	 * Sets the id.
	 * 
	 * @param id the id
	 */
	void setId(String id);
	
	/**
	 * Gets the type of contact.
	 * 
	 * @return the type
	 */
	ContactType getType();
	
	/**
	 * Sets the type of contact.
	 * 
	 * @param type the type
	 */
	void setType(ContactType type);
	
	/**
	 * Gets the contact detail, i.e. phone number, email address, etc.
	 * 
	 * @return the contact detail
	 */
	D getDetail();
	
	/**
	 * Sets the contact detail, i.e. phone number, email address, etc.
	 * 
	 * @param detail the contact detail
	 */
	void setDetail(D detail);
}
