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
package org.eclipse.che.plugin.sample.perspective.ide;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 */
@Singleton
public class NavigationPresenter extends BasePresenter {

    private LocalizationConstant localizationConstant;
    private NavigationView view;

    @Inject
    public NavigationPresenter(LocalizationConstant localizationConstant, NavigationView view){
        this.localizationConstant = localizationConstant;
        this.view = view;
    }

    @Override
    public String getTitle() {
        return localizationConstant.navigationTitle();
    }

    @Override
    public SVGResource getTitleImage() {
        return (CustomPerspectiveResources.INSTANCE.icon());
    }

    @Override
    public IsWidget getView() {
        return view;
    }

    @Override
    public String getTitleToolTip() {
        return localizationConstant.navigationTitle();
    }

    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(view);
    }
}
