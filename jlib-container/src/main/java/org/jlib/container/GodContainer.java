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
import java.util.Iterator;
import java.util.List;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

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
public class GodContainer<Item>
extends AbstractObject
implements ToRandomAccessList<Item>,
           ContainsItemsByCollection<Item>,
           RetainItemsByTraversable<Item>,
           RemoveItemByItem<Item>,
           RemoveAllItems<Item>,
           ObservedRetainByTraversable<Item>,
           ObservedRemoveByItem<Item>,
           ObservedRemoveAll<Item>,ItemOperationStrategy<Item>,Traversable<Item>,
           Iterable<Item> {

    private ToRandomAccessList<Item> delegateToRandomAccessListContainer = /*
     */ DisabledToRandomAccessList.getInstance();

    private GetItemsCount<Item> delegateGetItemsCount = /*
     */ DisabledItemsCountContainer.getInstance();

    private ContainsItemsByCollection<Item> delegateContainsContainer = /*
     */ DisabledContainsItem.getInstance();

    private RetainItemsByTraversable<Item> delegateRetainItemsByTraversable = /*
     */ DisabledRetainItemsByTraversable.getInstance();

    private RemoveItemByItem<Item> delegateRemoveByItemContainer = /*
     */ DisabledRemoveItemByItem.getInstance();

    private RemoveAllItems<Item> delegateRemoveAllItems = /*
     */ DisabledRemoveAllItems.getInstance();

    private ObservedRetainByTraversable<Item> delegateObservedRetainByTraversableContainer = /*
     */ DisabledObservedRetainByTraversable.getInstance();

    private ObservedRemoveByItem<Item> delegateObservedRemoveByItemContainer = /*
     */ DisabledObservedRemoveByItem.getInstance();

    private ObservedRemoveAll<Item> delegateObservedRemoveAllContainer = /*
     */ DisabledObservedRemoveAll.getInstance();

    public GodContainer() {
        super();
    }

    public ToRandomAccessList<Item> getDelegateToRandomAccessListContainer() {
        return delegateToRandomAccessListContainer;
    }

    public void setDelegateToRandomAccessListContainer(
                                                      final ToRandomAccessList<Item> delegateToRandomAccessListContainer) {
        this.delegateToRandomAccessListContainer = delegateToRandomAccessListContainer;
    }

    public TraversableContainer<Item> getDelegateTraversableContainer() {
        return delegateTraversableContainer;
    }

    public void setDelegateTraversableContainer(final TraversableContainer<Item> delegateTraversableContainer) {
        this.delegateTraversableContainer = delegateTraversableContainer;
    }

    public ContainsItemsByArray<Item> getDelegateContainsContainer() {
        return delegateContainsContainer;
    }

    public void setDelegateContainsContainer(final ContainsItemsByCollection<Item> delegateContainsContainer) {
        this.delegateContainsContainer = delegateContainsContainer;
    }

    public RetainItemsByTraversable<Item> getDelegateRetainItemsByTraversable() {
        return delegateRetainItemsByTraversable;
    }

    public void setDelegateRetainItemsByTraversable(
                                                   final RetainItemsByTraversable<Item> delegateRetainItemsByTraversable) {
        this.delegateRetainItemsByTraversable = delegateRetainItemsByTraversable;
    }

    public RemoveItemByItem<Item> getDelegateRemoveByItemContainer() {
        return delegateRemoveByItemContainer;
    }

    public void setDelegateRemoveByItemContainer(final RemoveItemByItem<Item> delegateRemoveByItemContainer) {
        this.delegateRemoveByItemContainer = delegateRemoveByItemContainer;
    }

    public RemoveAllItems<Item> getDelegateRemoveAllItems() {
        return delegateRemoveAllItems;
    }

    public void setDelegateRemoveAllItems(final RemoveAllItems<Item> delegateRemoveAllItems) {
        this.delegateRemoveAllItems = delegateRemoveAllItems;
    }

    public ObservedRetainByTraversable<Item> getDelegateObservedRetainByTraversableContainer() {
        return delegateObservedRetainByTraversableContainer;
    }

    public void setDelegateObservedRetainByTraversableContainer(
                                                               final ObservedRetainByTraversable<Item> delegateObservedRetainByTraversableContainer) {
        this.delegateObservedRetainByTraversableContainer = delegateObservedRetainByTraversableContainer;
    }

    public ObservedRemoveByItem<Item> getDelegateObservedRemoveByItemContainer() {
        return delegateObservedRemoveByItemContainer;
    }

    public void setDelegateObservedRemoveByItemContainer(
                                                        final ObservedRemoveByItem<Item> delegateObservedRemoveByItemContainer) {
        this.delegateObservedRemoveByItemContainer = delegateObservedRemoveByItemContainer;
    }

    public ObservedRemoveAll<Item> getDelegateObservedRemoveAllContainer() {
        return delegateObservedRemoveAllContainer;
    }

    public void setDelegateObservedRemoveAllContainer(
                                                     final ObservedRemoveAll<Item> delegateObservedRemoveAllContainer) {
        this.delegateObservedRemoveAllContainer = delegateObservedRemoveAllContainer;
    }

    @Override
    public int getItemsCount()
    throws InvalidTraversableStateException {
        return delegateTraversableContainer.getItemsCount();
    }

    @Override
    public boolean isEmpty()
    throws InvalidTraversableStateException {
        return delegateTraversableContainer.isEmpty();
    }

    @Override
    public boolean hasMatchingProperties(final TraversableContainer<Item> otherContainer) {
        return delegateTraversableContainer.hasMatchingProperties(otherContainer);
    }

    @Override
    public boolean containsItem(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.containsItem(item);
    }

    @Override
    public boolean contains(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.containsItems(items);
    }

    @Override
    public boolean containsItems(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.containsItems(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.containsItems(items);
    }

    @Override
    public List<Item> toRandomAccessList()
    throws InvalidTraversableStateException {
        return delegateToRandomAccessListContainer.toRandomAccessList();
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidTraversableStateException {
        return delegateToRandomAccessListContainer.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidTraversableStateException {
        return delegateToRandomAccessListContainer.toArray();
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
        return delegateTraversableContainer.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Iterable<Item> collection) {
        return delegateToRandomAccessListContainer.containsEqualItems(collection);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        delegateObservedRemoveAllContainer.removeAll(observers);
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveByItemContainer.remove(observers, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRetainByTraversableContainer.retainItems(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRetainByTraversableContainer.retainItems(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRetainByTraversableContainer.retainItems(observers, items);
    }

    @Override
    public void removeAllItems()
    throws InvalidTraversableStateException {
        delegateRemoveAllItems.removeAllItems();
    }

    @Override
    public void removeItem(final Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.removeItem(item);
    }

    @Override
    public void removeItems(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.removeItems(items);
    }

    @Override
    public void removeItems(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.removeItems(items);
    }

    @Override
    public void removeItems(final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.removeItems(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeItems(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveByItemContainer.removeItems(items);
    }

    @Override
    public void retainItems(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRetainItemsByTraversable.retainItems(items);
    }

    @Override
    public void retain(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRetainItemsByTraversable.retainItems(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRetainItemsByTraversable.retainItems(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRetainItemsByTraversable.retainItems(items);
    }

    @Override
    public Traverser<Item> createTraverser() {
        return delegateTraversableContainer.createTraverser();
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateTraversableContainer.iterator();
    }
}
