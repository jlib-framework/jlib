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

package org.jlib.core.text.placeholderreplacer;

/**
 * Routine replacing placeholders in a {@link CharSequence} template by specified arguments.
 * Each {@link PlaceholderReplacer} implementation defines the individual format of
 * the template and its placeholders.
 *
 * @author Igor Akkerman
 */
public interface PlaceholderReplacer {

    /**
     * Replaces placeholders in a {@link CharSequence} tenplate by the specified arguments.
     *
     * @param template
     *        {@link CharSequence} specifying the template containing the placeholders
     *
     * @param arguments
     *        {@link CharSequence} specifying the arguments applied on {@code template};
     *        the arguments are passed to the replacing routine in the correct
     *        order without any transformation
     *
     * @return final {@link String}
     */
    public String replacePlaceholders(CharSequence template, Object... arguments);
}
