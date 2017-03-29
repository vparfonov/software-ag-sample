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

import org.eclipse.che.ide.api.event.ActivePartChangedEvent;
import org.eclipse.che.ide.api.event.ActivePartChangedHandler;
import org.eclipse.che.ide.menu.PartMenu;
import org.eclipse.che.ide.part.PartStackPresenter;
import org.eclipse.che.ide.part.PartsComparator;
import org.eclipse.che.ide.part.widgets.TabItemFactory;

/**
 *
 */
@Singleton
public class SamplePresenter extends PartStackPresenter implements ActivePartChangedHandler {

    private final SampleView view;


    @Inject
    public SamplePresenter(EventBus eventBus,
                           PartMenu partMenu,
                           PartsComparator partsComparator,
                           PartStackEventHandler partStackEventHandler,
                           SampleView view,
                           TabItemFactory tabItemFactory) {
        super(eventBus, partMenu, partStackEventHandler, tabItemFactory, partsComparator, view, null);

        this.view = view;
        eventBus.addHandler(ActivePartChangedEvent.TYPE, this);
    }


    /** {@inheritDoc} */
    @Override
    public void onActivePartChanged(ActivePartChangedEvent event) {
        view.show();
    }

    /** {@inheritDoc} */
    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(view);
    }
}
