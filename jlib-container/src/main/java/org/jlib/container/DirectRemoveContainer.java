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

package org.jlib.container;

import java.util.Collection;

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

/**
 * {@link RemoveContainer} allowing its Items to be removed by random access to
 * each specified Item.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public interface DirectRemoveContainer<Item>
extends Container<Item> {

    /**
     * Removes the specified Item from this {@link DirectRemoveContainer}.
     *
     * @param item
     *        {@link Item} to remove
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link DirectRemoveContainer} does not contain
     *         {@code Item}
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public void remove(Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Removes all Items contained by the specified {@link TraversableContainer} from this
     * {@link DirectRemoveContainer}.
     *
     * @param items
     *        {@link TraversableContainer} containing the Items to remove
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public void remove(TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link DirectRemoveContainer}.
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public void remove(Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link DirectRemoveContainer}.
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public void remove(Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;

    /**
     * Removes all specified Items from this {@link DirectRemoveContainer}
     * .
     *
     * @param items
     *        comma separated sequence of Items to remove
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void remove(Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException;
}
