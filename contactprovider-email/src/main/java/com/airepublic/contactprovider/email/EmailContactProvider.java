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
package com.airepublic.contactprovider.email;

import java.util.Locale;

import javax.inject.Singleton;

import com.airepublic.configuration.api.IConfigurationService;
import com.airepublic.contactprovider.api.IContactProvider;

/**
 * The email implementation for the {@link IContactProvider} interface.
 * 
 * @author Torsten.Oltmanns@ai-republic.com
 */
@Singleton
public class EmailContactProvider implements IContactProvider {

    /**
     * Constructor.
     */
    public EmailContactProvider() {
    }


    @Override
    public void initialize(final IConfigurationService configurationService, final Locale locale) {
        // TODO: read email server settings from configuration service
    }

}
