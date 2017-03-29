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

import com.google.gwt.i18n.client.Messages;

/**
 */
public interface LocalizationConstant extends Messages {


    @Key("navigation.view.title")
    @DefaultMessage("Navigation Panel")
    String navigationTitle();

    @Key("information.view.title")
    @DefaultMessage("Information Panel")
    String informationTitle();

    @Key("button.sayHello")
    @DefaultMessage("Say Hello")
    String sayHello();

    @Key("message.hello")
    @DefaultMessage("Hello!!!")
    String hello();

    @Key("project.perspective")
    @DefaultMessage("Project Perspective")
    String projectPerspective();

    @Key("custom.perspective")
    @DefaultMessage("Custom Perspective")
    String customPerspective();



}
