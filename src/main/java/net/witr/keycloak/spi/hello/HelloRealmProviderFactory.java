package net.witr.keycloak.spi.hello;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class HelloRealmProviderFactory implements RealmResourceProviderFactory {

    public static final String SERVICE_PROVIDER_FACTORY_ID = "witrdotnet";

    @Override
    public String getId() {
        return SERVICE_PROVIDER_FACTORY_ID;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public RealmResourceProvider create(KeycloakSession keycloakSession) {
        return new HelloRealmProvider(keycloakSession);
    }

    @Override
    public void init(Config.Scope scope) {
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
    }

    @Override
    public void close() {
    }
}