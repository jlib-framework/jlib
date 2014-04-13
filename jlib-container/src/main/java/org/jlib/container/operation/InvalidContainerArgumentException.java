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

package org.jlib.container.operation;

import org.jlib.core.language.ParametrizedMessage;
import org.jlib.core.language.InvalidArgumentException;
import org.jlib.core.language.InvalidStateException;
import org.jlib.core.language.operation.ItemOperation;
import org.jlib.core.iterator.InvalidIteratorStateException;

import static org.jlib.core.language.ExceptionMessageUtility.message;

/**
 * {@link InvalidIteratorStateException} thrown when the traversed {@link ItemOperation} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidContainerArgumentException
extends InvalidArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    /*
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param operation
     *        traversed {@link ItemOperation}
     */
    public InvalidContainerArgumentException(final ItemOperation<?> container) {
        super(message().with(container));
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param container
     *        traversed {@link ItemOperation}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     */
    public InvalidContainerArgumentException(final ItemOperation<?> container, final Exception cause) {
        super(message().with(container), cause);
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param container
     *        traversed {@link ItemOperation}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param errorMessageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidContainerArgumentException(final ItemOperation<?> container, final ParametrizedMessage message) {
        super(message.with(container));
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param container
     *        traversed {@link ItemOperation}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidContainerArgumentException(final ItemOperation<?> container, final ParametrizedMessage message,
                                             final Exception cause) {
        super(message.with(container), cause);
    }
}
