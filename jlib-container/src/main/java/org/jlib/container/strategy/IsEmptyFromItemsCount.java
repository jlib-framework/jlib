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

package org.jlib.container.strategy;

import org.jlib.core.traverser.InvalidTraversableStateException;

import org.jlib.container.GetCount;
import org.jlib.container.IsEmpty;

public class IsEmptyFromItemsCount<Item> implements IsEmpty<Item> {

    private final GetCount<Item> delegateContainer;

    public IsEmptyFromItemsCount(final GetCount<Item> getCount) {
        super();

        this.delegateContainer = getCount;
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversableStateException {
        return delegateContainer.getCount() == 0;
    }
}
