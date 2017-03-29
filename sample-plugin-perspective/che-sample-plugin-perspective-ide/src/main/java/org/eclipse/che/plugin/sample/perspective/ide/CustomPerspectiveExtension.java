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

import com.google.inject.Inject;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.extension.Extension;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_RIGHT_TOOLBAR;

/**
 */
@Extension(title = "Custom Perspective Extension")
public class CustomPerspectiveExtension {

    /**
     * Constructor.
     *
     * @param actionManager the {@link ActionManager} that is used to register the action
     * @param switchPerspectiveAction action for switching between perspectives
     */
    @Inject
    public CustomPerspectiveExtension(ActionManager actionManager){
        // add actions on right part of toolbar
        final DefaultActionGroup rightToolbarGroup = (DefaultActionGroup)actionManager.getAction(GROUP_RIGHT_TOOLBAR);
    }
}
