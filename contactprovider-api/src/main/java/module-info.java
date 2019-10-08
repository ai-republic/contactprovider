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

    requires com.airepublic.logging.java;
    requires configuration.api;
    requires exception;
    requires jakarta.inject;
    requires java.annotation;
    requires java.persistence;

}