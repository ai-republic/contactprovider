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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CONTACT_DETAIL")
public abstract class AbstractContactDetail<D> implements IContactDetail<D> {
	private static final long serialVersionUID = -6276251799151171469L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	@Column(length=255)
	private D detail;
	@Column(length=255)
	private ContactType type;
	
	public AbstractContactDetail() {
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public D getDetail() {
		return detail;
	}
	
	@Override
	public void setDetail(D detail) {
		this.detail = detail;
	}
	
	@Override
	public ContactType getType() {
		return type;
	}
	
	@Override
	public void setType(ContactType type) {
		this.type = type;
	}

}
