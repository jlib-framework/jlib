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

package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.SoleItemNotRemoveableException;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;

/**
 * {@link SubReplaceInsertIndexSequence} view of the Items stored in a base
 * {@link ObservedReplaceInsertRemoveIndexSequence} in the specified index
 * range. The Items in this {@link SubReplaceInsertIndexSequence} will have the
 * same index as they had in the base
 * {@link ObservedReplaceInsertRemoveIndexSequence} .
 *
 * @param <Item>
 *        type of the items held in the
 *        {@link SubReplaceInsertRemoveIndexSequence}
 *
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceInsertIndexSequence}
 *
 * @author Igor Akkerman
 */
public class SubReplaceInsertRemoveIndexSequence /*
              */<Item, /*
              */  BaseSequence extends ObservedReplaceIndexSequence<Item> & ObservedInsertIndexSequence<Item> & ObservedRemoveIndexSequence<Item>>
extends SubReplaceInsertIndexSequence<Item, BaseSequence>
implements ObservedReplaceIndexSequence<Item>,
           ObservedInsertIndexSequence<Item>,
           InsertRemoveIndexSequence<Item> {

    /**
     * Creates a new {@link SubReplaceInsertRemoveIndexSequence}.
     *
     * @param baseSequence
     *        base {@link ReplaceInsertIndexSequence}
     *
     * @param firstIndex
     *        integer specifying the index of the first Item
     *
     * @param lastIndex
     *        integer specifying the index of the last Item
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code firstIndex < baseSequence.getFirstIndex() || lastIndex > baseSequence.getLastIndex()}
     *
     * @throws InvalidSequenceIndexException
     *         if {@code firstIndex > lastIndex}
     */
    public SubReplaceInsertRemoveIndexSequence(final BaseSequence baseSequence, final int firstIndex,
                                               final int lastIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
        super(baseSequence, firstIndex, lastIndex);
    }

    @Override
    public SubReplaceInsertRemoveIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
        return new SubReplaceInsertRemoveIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser() {
        return new DefaultReplaceInsertRemoveIndexSequenceTraverser<>(this);
    }

    @Override
    public ObservedReplaceInsertRemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws InvalidSequenceIndexException {
        return new DefaultReplaceInsertRemoveIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    public void remove(final int index) {
        IndexSequenceUtility.ensureIndexValid(this, index);

        getBaseSequence().remove(index);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final int index, final ValueObserver<Item>... observers) {
        IndexSequenceUtility.ensureIndexValid(this, index);

        getBaseSequence().remove(index, observers);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        ContainerUtility.retain(this, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        ContainerUtility.retain(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        ContainerUtility.retain(this, items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, ValueObserverException {
        ContainerUtility.retain(this, observers, items);
    }

    @Override
    public void removeFirstItem()
    throws InvalidTraversibleStateException {
        remove(getFirstIndex());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeFirstItem(final ValueObserver<Item>... observers)
    throws ValueObserverException {
        remove(getFirstIndex(), observers);
    }

    @Override
    public void removeLastItem()
    throws InvalidTraversibleStateException {
        remove(getLastIndex());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeLastItem(final ValueObserver<Item>... observers)
    throws SoleItemNotRemoveableException {
        remove(getLastIndex());
    }
}
