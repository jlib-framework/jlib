/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container;

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.traverser.InvalidTraversibleArgumentException;

/**
 * {@link InvalidContainerArgumentException} thrown when a {@link Container}
 * does not contain the specified Item to remove.
 *
 * @author Igor Akkerman
 */
public class ItemToRemoveNotContainedException
extends InvalidTraversibleArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 2921569537644842654L;

    /**
     * Creates a new {@link ItemToRemoveNotContainedException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param item
     *        Item to remove
     */
    public ItemToRemoveNotContainedException(@SuppressWarnings("TypeMayBeWeakened") final Container<?> container,
                                             final Object item) {
        super(container, message(item.toString()));
    }

    public ItemToRemoveNotContainedException(@SuppressWarnings("TypeMayBeWeakened") final Container<?> container,
                                             final Object item, final Exception cause) {
        super(container, message(item.toString()), cause);
    }
}
