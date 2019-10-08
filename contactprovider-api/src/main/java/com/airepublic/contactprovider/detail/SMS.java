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
package com.airepublic.contactprovider.detail;

import javax.persistence.Entity;

import com.airepublic.contactprovider.api.AbstractContactDetail;
import com.airepublic.contactprovider.api.ContactType;
import com.airepublic.contactprovider.api.IContactDetail;

/**
 * Implementation of {@link IContactDetail} for SMS contact type.
 * 
 * @author Torsten.Oltmanns@ai-republic.com
 */
@Entity
public class SMS extends AbstractContactDetail<Long>{
	private static final long serialVersionUID = -1749985821367439258L;
	
	/**
	 * Constructor.
	 */
	public SMS() {
		setType(ContactType.SMS);
	}
}
