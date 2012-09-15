/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import org.jlib.core.ValueNotAccessibleException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.OperatorException;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.core.array.ArrayUtility.traversible;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.IllegalSequenceTraverserStateException;
import org.jlib.container.sequence.NoSequenceItemToReplaceException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.FillupArraySequence;

import static org.jlib.container.sequence.SequenceUtility.concatenated;

/**
 * Default implementation of a {@link IndexSequenceTraverser} and
 * {@link ObservedReplaceIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultReplaceIndexSequenceTraverser<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends DefaultIndexSequenceTraverser<Item, Sequenze>
implements ObservedReplaceIndexSequenceTraverser<Item> {

    /** replace {@link ValueObserver} items */
    private final AppendSequence<ValueObserver<Item>> traverserReplaceObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ObservedReplaceIndexSequence} beginning at its
     * first index.
     * 
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ReplaceIndexSequence} beginning the traversal at
     * the specified index.
     * 
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code newItem} prevents the operation from
     *         being performed
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs performing the operation
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public final void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        traverserReplaceObservers.append(replaceObserver);
    }

    @Override
    public final void replace(final Item newItem)
    throws NoSequenceItemToReplaceException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        try {
            getSequence().replace(getLastAccessedItemIndex(), newItem);
        }
        catch (final ValueNotAccessibleException exception) {
            throw new NoSequenceItemToReplaceException(getSequence(), exception);
        }
    }

    @Override
    @SafeVarargs
    public final void replace(final Item newItem, final ValueObserver<Item>... operationObservers)
    throws NoSequenceItemToReplaceException, IllegalSequenceArgumentException, IllegalSequenceStateException,
    RuntimeException {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    replace(newItem);
                }
                catch (IllegalSequenceArgumentException | IllegalSequenceTraverserStateException exception) {
                    throw new OperatorException("replace: {0}", exception, newItem);
                }
            }

        },

        newItem, concatenated(traverserReplaceObservers, traversible(operationObservers)).toArray());
    }
}
