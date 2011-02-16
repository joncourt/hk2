/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.jvnet.hk2.junit;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.io.FileFilter;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jvnet.hk2.component.HabitatFactory;
import org.jvnet.hk2.component.InhabitantsParserFactory;

/**
 * Provide options for tuning the behavior of the Hk2Runner.
 * 
 * @see Hk2Runner
 * 
 * @author Jeff Trent
 */
@Retention(RUNTIME)
@Target({TYPE})
@Inherited
public @interface Hk2RunnerOptions {

  /**
   * Flag indicating whether the habitat (and all injections)
   * are recreated after each <code>Test</code>.
   */
  boolean reinitializePerTest() default false;
  
  /**
   * Flag indicating whether the default RunLevelService is enabled by default
   */
  boolean enableDefaultRunLevelService() default true;
  
  /**
   * Flag indicating whether the standard RunLevel constraints are enabled by default
   */
  boolean enableRunLevelConstraints() default true;
  
  /**
   * Alternative Habitat Factory from the default 
   */
  Class<? extends HabitatFactory> habitatFactory() default HabitatFactory.class; 
  
  /**
   * Alternative Inhabitants Parser from the default 
   */
  Class<? extends InhabitantsParserFactory> inhabitantsParserFactory() default InhabitantsParserFactory.class; 

  /**
   * A filter that can be used to optimally select the set of jars (and directories) that contributes to habitat
   * production, filtering out the irrelevant ones.  Mostly intended as a performance optimization when used.
   * 
   * <p>
   * Note that while the declaration is generic enough to support any {@link FileFilter}, the implementation
   * also supports the use of full {@link ClassPathAdvisor} interface.
   */
  Class<? extends FileFilter> classpathFilter() default FileFilter.class;
  
}
