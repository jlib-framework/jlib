/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.core.language;

import org.jlib.object_spi.Equals;
import org.jlib.object_spi.HashCode;
import org.jlib.object_spi.ToString;
import org.jlib.object_spi.apachecommons.ApacheCommonsStrategies;

/**
 * Abstract {@link Object} implementing {@link #toString()}, {@link #equals(Object)} and {@link #hashCode()} using
 * the correspondent reflective builders provided by
 * <a href="http://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a>.
 *
 * @author Igor Akkerman
 */
public abstract class AbstractObject {

    /**
     * Creates a new {@link AbstractObject}.
     */
    protected AbstractObject() {}

    @Override
    public String toString() {
        return getToStringStrategy().toString(this);
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return getEqualsStrategy().areEqual(this, otherObject);
    }

    @Override
    public int hashCode() {
        return getHashCodeStrategy().hashCode(this);
    }

    protected <Obj> Equals<Obj> getEqualsStrategy() {
        return ApacheCommonsStrategies.reflectionEquals(getExcludedFieldNames());
    }

    protected <Obj> HashCode<Obj> getHashCodeStrategy() {
        return ApacheCommonsStrategies.reflectionHashCode(getExcludedFieldNames());
    }

    protected <Obj> ToString<Obj> getToStringStrategy() {
        return ApacheCommonsStrategies.reflectionToString();
    }

    /**
     * <p>
     * Reuturns the names of the fields excluded from the operations in {@link #equals(Object)} and {@link #hashCode()}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} returns an empty array. It may be overridden to specify
     * a set of excluded fields.
     * </p>
     *
     *
     * @return array of {@link String}s specifying the names of the excluded fields
     */
    @SuppressWarnings("SameReturnValue")
    protected String[] getExcludedFieldNames() {
        return new String[0];
    }
}
