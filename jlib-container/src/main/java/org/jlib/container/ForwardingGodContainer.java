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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.ItemsSupplier.ItemsSupplier;

/**
 * Skeletal implementation of a {@link TraversableContainer}. A concrete TraversableContainer
 * implementation needs only to extend this class and implement the
 * {@link TraversableContainer#iterator()} method. Other methods may be overridden for
 * efficiency reasons.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public class ForwardingGodContainer<Item>
extends AbstractObject
implements GodContainer<Item> {

    private final GodContainer<Item> disabledGodContainer = new GodContainer<Item>() {

        @Override
        public boolean contains(final ItemsSupplier<Item> items)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public int getCount()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public boolean isEmpty()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Iterator<Item> iterator() {
            throw new ForbiddenCastException(this);
        }

        @SafeVarargs
        @Override
        public final void remove(final ItemsSupplier<Item> items, final ValueObserver<Item>... observers)
        throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
               ValueObserverException {
            throw new ForbiddenCastException(this);
        }

        @SafeVarargs
        @Override
        public final void removeAll(final ValueObserver<Item>... observers)
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @SafeVarargs
        @Override
        public final void retain(final ItemsSupplier<Item> items, final ValueObserver<Item>... observers)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void remove(final ItemsSupplier<Item> items)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void removeAll()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void retain(final ItemsSupplier<Item> items)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Item[] toArray()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public List<Item> toRandomAccessList()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public List<Item> toSequentialList()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Set<Item> toSet()
        throws InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public Traverser<Item> createTraverser() {
            throw new ForbiddenCastException(this);
        }

        @Override
        public boolean contains(final Item item)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }

        @Override
        public void remove(final Item item)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            throw new ForbiddenCastException(this);
        }
    };

    private ToArray<Item> delegateToArray = disabledGodContainer;

    private ToSequentialList<Item> delegateToSequentialList = disabledGodContainer;

    private ObservedRetain<Item> delegateObservedRetain = disabledGodContainer;

    private ToSet<Item> delegateToSet = disabledGodContainer;

    private IsEmpty<Item> delegateIsEmpty = disabledGodContainer;

    private Retain<Item> delegateRetain = disabledGodContainer;

    private ObservedRemoveAll<Item> delegateObservedRemoveAll = disabledGodContainer;

    private RemoveAll<Item> delegateRemoveAll = disabledGodContainer;

    private ToRandomAccessList<Item> delegateToRandomAccessList = disabledGodContainer;

    private GetCount<Item> delegateGetCount = disabledGodContainer;

    private RemoveSingle<Item> delegateRemoveSingle = disabledGodContainer;

    private RemoveMany<Item> delegateRemoveMany = disabledGodContainer;

    private ObservedRemoveMany<Item> delegateObservedRemoveMany = disabledGodContainer;

    private ContainsSingle<Item> delegateContainsSingle = disabledGodContainer;

    private ContainsMany<Item> delegateContainsMany = disabledGodContainer;

    private Traversable<Item> delegateTraversable = disabledGodContainer;

    private Iterable<Item> delegateIterable = disabledGodContainer;

    public ForwardingGodContainer() {
        super();
    }

    @Override
    public void removeAll()
    throws InvalidTraversableStateException {
        delegateRemoveAll.removeAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        delegateObservedRemoveAll.removeAll(observers);
    }

    @Override
    public void retain(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRetain.retain(items);
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversableStateException {
        return delegateIsEmpty.isEmpty();
    }

    @Override
    public Set<Item> toSet()
    throws InvalidTraversableStateException {
        return delegateToSet.toSet();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ItemsSupplier<Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRetain.retain(items, observers);
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidTraversableStateException {
        return delegateToSequentialList.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidTraversableStateException {
        return delegateToArray.toArray();
    }

    @Override
    public int getCount()
    throws InvalidTraversableStateException {
        return delegateGetCount.getCount();
    }

    @Override
    public List<Item> toRandomAccessList()
    throws InvalidTraversableStateException {
        return delegateToRandomAccessList.toRandomAccessList();
    }

    @Override
    public boolean contains(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsMany.contains(items);
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public void remove(final ItemsSupplier<Item> items, final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException {
        delegateObservedRemoveMany.remove(items, observers);
    }

    @Override
    public void remove(final ItemsSupplier<Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveMany.remove(items);
    }

    @Override
    public void remove(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveSingle.remove(item);
    }

    @Override
    public boolean contains(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsSingle.contains(item);
    }

    @Override
    public Traverser<Item> createTraverser() {
        return delegateTraversable.createTraverser();
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateIterable.iterator();
    }

    public void setDelegateToArray(final ToArray<Item> delegateToArray) {
        this.delegateToArray = delegateToArray;
    }

    public void setDelegateToSequentialList(final ToSequentialList<Item> delegateToSequentialList) {
        this.delegateToSequentialList = delegateToSequentialList;
    }

    public void setDelegateObservedRetain(final ObservedRetain<Item> delegateObservedRetain) {
        this.delegateObservedRetain = delegateObservedRetain;
    }

    public void setDelegateToSet(final ToSet<Item> delegateToSet) {
        this.delegateToSet = delegateToSet;
    }

    public void setDelegateIsEmpty(final IsEmpty<Item> delegateIsEmpty) {
        this.delegateIsEmpty = delegateIsEmpty;
    }

    public void setDelegateRetain(final Retain<Item> delegateRetain) {
        this.delegateRetain = delegateRetain;
    }

    public void setDelegateObservedRemoveAll(final ObservedRemoveAll<Item> delegateObservedRemoveAll) {
        this.delegateObservedRemoveAll = delegateObservedRemoveAll;
    }

    public void setDelegateRemoveAll(final RemoveAll<Item> delegateRemoveAll) {
        this.delegateRemoveAll = delegateRemoveAll;
    }

    public void setDelegateToRandomAccessList(final ToRandomAccessList<Item> delegateToRandomAccessList) {
        this.delegateToRandomAccessList = delegateToRandomAccessList;
    }

    public void setDelegateGetCount(final GetCount<Item> delegateGetCount) {
        this.delegateGetCount = delegateGetCount;
    }

    public void setDelegateRemoveMany(final RemoveMany<Item> delegateRemoveMany) {
        this.delegateRemoveMany = delegateRemoveMany;
    }

    public void setDelegateObservedRemoveMany(final ObservedRemoveMany<Item> delegateObservedRemoveMany) {
        this.delegateObservedRemoveMany = delegateObservedRemoveMany;
    }

    public void setDelegateContainsMany(final ContainsMany<Item> delegateContainsMany) {
        this.delegateContainsMany = delegateContainsMany;
    }

    public void setDelegateTraversable(final Traversable<Item> delegateTraversable) {
        this.delegateTraversable = delegateTraversable;
    }

    public void setDelegateIterable(final Iterable<Item> delegateIterable) {
        this.delegateIterable = delegateIterable;
    }

    public void setDelegateRemoveSingle(final RemoveSingle<Item> delegateRemoveSingle) {
        this.delegateRemoveSingle = delegateRemoveSingle;
    }

    public void setDelegateContainsSingle(final ContainsSingle<Item> delegateContainsSingle) {
        this.delegateContainsSingle = delegateContainsSingle;
    }
}
