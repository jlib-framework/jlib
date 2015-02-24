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

package org.jlib.core.reflection.reflector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.reflection.reflector.Reflectors.useClassNamed;
import static org.jlib.core.reflection.reflector.SuperTypeValidator.instanceOf;
import org.junit.Test;

public class ReflectorTest {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void staticRun()
    throws Exception {
        final Number value = useClassNamed("java.lang.Integer") /*
          */.assertType(Number.class)
            .assertSubtypeOf(Integer.class)
            .useStaticMethod("valueOf")
            .withReturnType(Number.class)
            .withArgumentTypes(int.class)
            .invoke(42)
            .assertReturned(instanceOf(Integer.class))
            .assertReturned(Integer.valueOf(42))
            .get();

        assertThat(value).isEqualTo(Integer.valueOf(42));
    }
}

