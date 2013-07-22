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

package org.jlib.core.traverser;

import org.jlib.core.language.ExceptionMessage;

/**
 * {@link InvalidTraverserStateException} thrown when the traversed
 * {@link Traversible} claims a state error.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidTraverserStateException
extends InvalidTraversibleStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1706750148627927636L;

    public InvalidTraverserStateException(final Traversible<?> traversible) {
        super(traversible);
    }

    public InvalidTraverserStateException(final Traversible<?> traversible, final ExceptionMessage message) {
        super(traversible, message);
    }

    /**
     * Creates a new {@link InvalidTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param cause
     *        {@link Exception} that caused this
     *        {@link InvalidTraversibleStateException}
     */
    public InvalidTraverserStateException(final Traversible<?> traversible, final Exception cause) {
        super(traversible, cause);
    }

    public InvalidTraverserStateException(final Traversible<?> traversible, final ExceptionMessage message,
                                          final Exception cause) {
        super(traversible, message, cause);
    }
}
