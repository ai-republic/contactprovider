import com.airepublic.contactprovider.api.IContactProvider;
import com.airepublic.contactprovider.email.EmailContactProvider;

/**
 * 
 */
/**
 * @author Torsten
 *
 */
module contactprovider.email {
    exports com.airepublic.contactprovider.email;

    provides IContactProvider with EmailContactProvider;

    requires transitive configuration.api;
    requires contactprovider.api;
    requires cdi.api;
}