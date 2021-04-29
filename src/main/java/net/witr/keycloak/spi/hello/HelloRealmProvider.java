package net.witr.keycloak.spi.hello;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.services.resource.RealmResourceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class HelloRealmProvider implements RealmResourceProvider {

    private KeycloakSession session;

    public HelloRealmProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return this;
    }

    @GET
    @Path("/hello")
    @Produces("text/plain; charset=utf-8")
    public String get() {
        String name = session.getContext().getRealm().getName();
        RealmModel realm = session.getContext().getRealm();
        int realmUsersCount = session.users().getUsersCount(realm);
        return "Hello from realm " + name + ". I count " + realmUsersCount + " user(s).";
    }

    @Override
    public void close() {
    }
}
