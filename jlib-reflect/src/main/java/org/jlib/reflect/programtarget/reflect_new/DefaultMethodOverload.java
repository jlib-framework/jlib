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

package org.jlib.reflect.programtarget.reflect_new;

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.InvalidMethodReturnTypeException;

public abstract class DefaultMethodOverload<ReturnValue>
implements MethodOverload<ReturnValue> {

    private final Class<?> enclosingClass;
    private final String methodName;
    private final Class<ReturnValue> returnValueType;

    protected DefaultMethodOverload(final Class<?> enclosingClass, final String methodName,
                                    final Class<ReturnValue> returnValueType) {
        this.enclosingClass = enclosingClass;
        this.returnValueType = returnValueType;
        this.methodName = methodName;
    }

    protected  void assertMethodReturnsValidType(final Method method)
    throws InvalidMethodReturnTypeException {
        assertMethodReturnsType(method, returnValueType);
    }

    private void assertMethodReturnsType(final Method method, final Class<?> expectedReturnValueType)
    throws InvalidMethodReturnTypeException {
        if (! expectedReturnValueType.isAssignableFrom(method.getReturnType()))
            throw new InvalidMethodReturnTypeException(method);
    }

    protected Class<?> getEnclosingClass() {
        return enclosingClass;
    }

    protected String getMethodName() {
        return methodName;
    }

    protected Class<ReturnValue> getReturnValueType() {
        return returnValueType;
    }
}
