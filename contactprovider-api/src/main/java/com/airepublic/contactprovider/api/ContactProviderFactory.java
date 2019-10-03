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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airepublic.configuration.api.ConfigurationServiceException;
import com.airepublic.configuration.api.IConfigurationService;

/**
 * Factory producing {@link IContactProvider}s for the different {@link ContactType}s.
 * 
 * @author Torsten.Oltmanns@ai-republic.com
 */
@Singleton
public class ContactProviderFactory {
    private final static String CONFIG_PREFIX = "ContactProvider_";
    private final static Logger LOG = LoggerFactory.getLogger(ContactProviderFactory.class);
    private final Map<String, IContactProvider> contactServices = new HashMap<>();
    private IConfigurationService configurationService;


    /**
     * Initialized the configured {@link IContactProvider}s.
     */
    @PostConstruct
    public void initialize() {
    }


    /**
     * Gets the configured {@link IContactProvider} for the specified {@link ContactType}.
     * 
     * @param type the contact type
     * @return the contact provider
     */
    public IContactProvider getContactService(final ContactType type, final Locale locale) {
        String classname = null;
        final String countryCode = locale != null ? locale.getCountry() : null;

        try {
            IContactProvider provider = contactServices.get(type.name() + "_" + countryCode);

            if (provider == null) {
                final ContactProviderConfiguration conf = configurationService.getConfiguration(ContactProviderConfiguration.CONFIG_ID, countryCode, ContactProviderConfiguration.class);
                classname = conf.getClassesTypeMap().get(type);

                if (classname != null) {
                    provider = (IContactProvider) Class.forName(classname).getDeclaredConstructor().newInstance();
                    provider.initialize(configurationService, locale);

                    contactServices.put(type.name() + "_" + countryCode, provider);
                }
            }
            return provider;
        } catch (final ConfigurationServiceException e) {
            LOG.warn("Contact provider configuration could not be found for (" + CONFIG_PREFIX + type.name() + ") : ContactType=" + type + ", Locale=" + locale);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            LOG.warn("Class in Contact provider configuration could not be found (" + classname + ") : ContactType=" + type + ", Locale=" + locale);
        }

        return null;
    }
}
