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
package org.eclipse.che.plugin.sample.perspective.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMapBinder;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.parts.Perspective;
import org.eclipse.che.plugin.sample.perspective.ide.NavigationView;
import org.eclipse.che.plugin.sample.perspective.ide.NavigationViewImpl;
import org.eclipse.che.plugin.sample.perspective.ide.SampleView;
import org.eclipse.che.plugin.sample.perspective.ide.SampleViewImpl;
import org.eclipse.che.plugin.sample.perspective.ide.InformationView;
import org.eclipse.che.plugin.sample.perspective.ide.InformationViewImpl;
import org.eclipse.che.plugin.sample.perspective.ide.CustomPerspective;

import static org.eclipse.che.plugin.sample.perspective.ide.CustomPerspective.MY_PERSPECTIVE_ID;

/**
 * Gin module binding the {@link NavigationView} to the {@link NavigationViewImpl} implementation class.
 *
 * @author Edgar Mueller
 */
@ExtensionGinModule
public class CustomPerspectiveGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(NavigationView.class).to(NavigationViewImpl.class);
        bind(InformationView.class).to(InformationViewImpl.class);
        bind(SampleView.class).to(SampleViewImpl.class);
        GinMapBinder.newMapBinder(binder(), String.class, Perspective.class)
                    .addBinding(MY_PERSPECTIVE_ID)
                    .to(CustomPerspective.class);
    }

}
