/**
 * 
 */
/**
 * @author Torsten
 *
 */
module contactprovider.api {
    exports com.airepublic.contactprovider.detail;
    exports com.airepublic.contactprovider.api;

    requires configuration.api;
    requires exception;
    requires java.annotation;
    requires cdi.api;
    requires org.slf4j;
    requires java.persistence;

}