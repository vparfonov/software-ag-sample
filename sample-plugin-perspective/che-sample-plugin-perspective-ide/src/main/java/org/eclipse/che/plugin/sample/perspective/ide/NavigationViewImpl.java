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

import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

/**
 *
 */
public class NavigationViewImpl extends BaseView<NavigationView.ActionDelegate> implements NavigationView {

    /**
     *
     * @param resources the {@link PartStackUIResources}
     */
    @Inject
    public NavigationViewImpl(PartStackUIResources resources){
        super(resources);
        Label label = new Label("Navigation part :: Hello World!");
        setContentWidget(label);
    }
}
