/*
 *  [2012] - [2017] Codenvy, S.A.
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.onpremises.factory.deploy;

import com.codenvy.onpremises.factory.filter.RemoveIllegalCharactersFactoryURLFilter;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;

import org.eclipse.che.inject.DynaModule;

import javax.inject.Singleton;

import static com.codenvy.api.license.filter.SystemLicenseLoginFilter.ACCEPT_FAIR_SOURCE_LICENSE_PAGE_URL;
import static com.codenvy.api.license.filter.SystemLicenseLoginFilter.FAIR_SOURCE_LICENSE_IS_NOT_ACCEPTED_ERROR_PAGE_URL;
import static com.codenvy.api.license.filter.SystemLicenseLoginFilter.NO_USER_INTERACTION;

/**
 *  Servlet module composer for factory war.
 *  @author Sergii Kabashniuk
 */
@DynaModule
public class FactoryServletModule extends ServletModule {

    private static final String PASS_RESOURCES_REGEXP = "^(?!/resources/)/?.*$";

    @Override
    protected void configureServlets() {
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.onpremises.factory.filter.BrowserCheckerFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(RemoveIllegalCharactersFactoryURLFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.onpremises.factory.filter.FactoryParamsFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.auth.sso.client.LoginFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.api.license.filter.SystemLicenseLoginFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.onpremises.factory.filter.FactoryRetrieverFilter.class);
        filterRegex(PASS_RESOURCES_REGEXP).through(com.codenvy.onpremises.factory.filter.ReferrerCheckerFilter.class);

        bind(com.codahale.metrics.servlets.ThreadDumpServlet.class).in(Singleton.class);
        bind(com.codahale.metrics.servlets.PingServlet.class).in(Singleton.class);
        serve("/metrics/ping").with(com.codahale.metrics.servlets.PingServlet.class);
        serve("/metrics/threaddump").with(com.codahale.metrics.servlets.ThreadDumpServlet.class);

        serveRegex(PASS_RESOURCES_REGEXP).with(com.codenvy.onpremises.factory.FactoryServlet.class);

        bindConstant().annotatedWith(Names.named("page.creation.error")).to("/resources/error-factory-creation.html");
        bindConstant().annotatedWith(Names.named("page.invalid.factory")).to("/resources/error-invalid-factory-url.jsp");
        bindConstant().annotatedWith(Names.named("page.too.many.factories")).to("/resources/too-many-factories.html");

        install(new com.codenvy.auth.sso.client.deploy.SsoClientServletModule());

        bindConstant().annotatedWith(Names.named(NO_USER_INTERACTION)).to(false);
        bindConstant().annotatedWith(Names.named(ACCEPT_FAIR_SOURCE_LICENSE_PAGE_URL))
                      .to("/site/auth/accept-fair-source-license");
        bindConstant().annotatedWith(Names.named(FAIR_SOURCE_LICENSE_IS_NOT_ACCEPTED_ERROR_PAGE_URL))
                      .to("/site/error/fair-source-license-is-not-accepted-error");
    }
}
