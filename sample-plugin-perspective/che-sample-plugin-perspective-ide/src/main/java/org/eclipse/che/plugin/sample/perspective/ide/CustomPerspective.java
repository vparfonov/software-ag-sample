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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

import org.eclipse.che.ide.api.parts.PartStack;
import org.eclipse.che.ide.workspace.PartStackPresenterFactory;
import org.eclipse.che.ide.workspace.PartStackViewFactory;
import org.eclipse.che.ide.workspace.WorkBenchControllerFactory;
import org.eclipse.che.ide.workspace.perspectives.general.AbstractPerspective;
import org.eclipse.che.ide.workspace.perspectives.general.PerspectiveViewImpl;
import org.eclipse.che.providers.DynaProvider;

import javax.validation.constraints.NotNull;

import static org.eclipse.che.ide.api.parts.PartStackType.EDITING;
import static org.eclipse.che.ide.api.parts.PartStackType.INFORMATION;
import static org.eclipse.che.ide.api.parts.PartStackType.NAVIGATION;

/**
 *
 */
@Singleton
public class CustomPerspective extends AbstractPerspective {

    public final static String MY_PERSPECTIVE_ID = "My Perspective";

    @Inject
    public CustomPerspective(PerspectiveViewImpl view,
                             PartStackViewFactory partViewFactory,
                             SamplePresenter samplePresenter,
                             NavigationPresenter navigationPresenter,
                             InformationPresenter informationPresenter,
                             WorkBenchControllerFactory controllerFactory,
                             PartStackPresenterFactory stackPresenterFactory,
                             EventBus eventBus,
                             DynaProvider dynaProvider) {
        super(MY_PERSPECTIVE_ID, view, stackPresenterFactory, partViewFactory, controllerFactory, eventBus, dynaProvider);
        //central panel
        partStacks.put(EDITING, samplePresenter);

        addPart(navigationPresenter, NAVIGATION);
        addPart(informationPresenter, INFORMATION);
        PartStack navigation = getPartStack(NAVIGATION);
        PartStack editing = getPartStack(EDITING);
        PartStack information = getPartStack(INFORMATION);

        if (navigation == null || editing == null) {
            return;
        }

        navigation.go(view.getNavigationPanel());
        editing.go(view.getEditorPanel());
        information.go(view.getInformationPanel());
        openActivePart(EDITING);
        openActivePart(NAVIGATION);

    }

    @Override
    public String getPerspectiveId() {
        return MY_PERSPECTIVE_ID;
    }

    @Override
    public String getPerspectiveName() {
        return MY_PERSPECTIVE_ID;
    }

    /** {@inheritDoc} */
    @Override
    public void go(@NotNull AcceptsOneWidget container) {
        container.setWidget(view);
    }

}
