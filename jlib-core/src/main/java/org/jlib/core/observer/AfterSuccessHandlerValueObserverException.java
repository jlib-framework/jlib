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

package org.jlib.core.observer;

import org.jlib.core.language.ExceptionMessage;

/**
 * {@link ValueObserverException} thrown during a
 * {@link ValueObserver#before(Object)} operation.
 *
 * @author Igor Akkerman
 */
public abstract class AfterSuccessHandlerValueObserverException
extends ValueObserverException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3230285545341500553L;

    /**
     * Creates a new {@link AfterSuccessHandlerValueObserverException}.
     *
     * @param value
     *        Item removed from {@code operation}
     *
     * @param messageTemplate
     *        {@link String} specifying the message template; {1} references
     *        {@code value}
     *
     * @param cause
     *        {@link Exception} that caused this
     *        {@link AfterSuccessHandlerValueObserverException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected AfterSuccessHandlerValueObserverException(final Object value, final ExceptionMessage message,
                                                        final Exception cause) {
        super(value, message, cause);
    }
}
