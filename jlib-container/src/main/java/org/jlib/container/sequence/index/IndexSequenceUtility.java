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

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.container.Container;
import org.jlib.container.ObservedRemoveContainer;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.InvalidTraversibleStateException;

/**
 * {@link IndexSequence} utility.
 *
 * @author Igor Akkerman
 */
public final class IndexSequenceUtility {

    /** no visible constructor */
    private IndexSequenceUtility() {
    }

    /**
     * Asserts that the specified index is inside the valid bounds of the
     * specified {@link IndexSequence}.
     *
     * @param sequence
     *        verified {@link IndexSequence}
     *
     * @param index
     *        integer specifying the index to verify
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code index < sequence.getFirstIndex() || index > sequence.getLastIndex()}
     */
    public static void assertIndexValid(final IndexSequence<?> sequence, final int index)
    throws InvalidSequenceIndexException {

        if (index < sequence.getFirstIndex())
            throw new InvalidSequenceIndexException(sequence, message("index = {0} < {1} = firstIndex", index,
                                                                      sequence.getFirstIndex()));

        if (index > sequence.getLastIndex()) {
            throw new InvalidSequenceIndexException(sequence, message("index = {0} > {1} = lastIndex", index,
                                                                      sequence.getLastIndex()));
        }
    }

    /**
     * Asserts that the specified <em>from</em> and <em>to</em> indices are
     * valid, that is,
     * {@code sequence.getFirstIndex() <= fromIndex <= toIndex <= sequence.getLastIndex()}
     * .
     *
     * @param sequence
     *        verified {@link IndexSequence}
     *
     * @param fromIndex
     *        integer specifying the from index
     *
     * @param toIndex
     *        integer specifying the to index
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     *
     * @throws InvalidSequenceIndexRangeException
     *         if {@code fromIndex > toIndex}
     */
    public static void assertIndexRangeValid(final IndexSequence<?> sequence, final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexRangeException {
        final int firstIndex = sequence.getFirstIndex();

        if (fromIndex < firstIndex)
            throw new InvalidSequenceIndexException(sequence, fromIndex, "fromIndex == " + fromIndex + " < " +
                                                                         firstIndex + " == firstIndex");

        final int lastIndex = sequence.getLastIndex();

        if (toIndex > lastIndex)
            throw new InvalidSequenceIndexException(sequence, toIndex, "toIndex == " + toIndex + " < " + lastIndex +
                                                                       " == lastIndex");

        if (toIndex < fromIndex)
            throw new InvalidSequenceIndexRangeException(sequence, fromIndex, toIndex);
    }

    /**
     * Removes the specified Item from the specified {@link RemoveIndexSequence}
     * .
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param sequence
     *        {@link ObservedRemoveContainer} containing the Item
     *
     * @param itemIndex
     *        index of the Item to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversibleArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code itemIndex}
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public static <Item> void remove(final RemoveIndexSequence<Item> sequence, final int itemIndex,
                                     final ValueObserver<Item>... observers)
    throws InvalidTraversibleArgumentException, InvalidTraversibleStateException, RuntimeException {

        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    sequence.remove(itemIndex);
                }
                catch (InvalidTraversibleArgumentException | InvalidTraversibleStateException exception) {
                    throw new OperatorException(exception, "remove: {0}", itemIndex);
                }
            }
        },

                                sequence.get(itemIndex), observers);
    }
}
