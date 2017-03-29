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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

import org.vectomatic.dom.svg.ui.SVGResource;

/**
 */
public interface CustomPerspectiveResources extends ClientBundle {

    /**
     * Singleton instance.
     */
    CustomPerspectiveResources INSTANCE = GWT.create(CustomPerspectiveResources.class);

    /**
     * Declares an icon.
     *
     * @return the icon
     */
    @Source("icons/my.svg")
    SVGResource icon();
}
