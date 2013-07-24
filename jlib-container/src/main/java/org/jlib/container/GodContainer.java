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
implements JdkAwareContainer<Item>,
           TraversableContainer<Item>,
           ContainsContainer<Item>,
           RemoveContainer<Item>,
           DirectRemoveContainer<Item>,
           RemoveAllContainer<Item>,
           ObservedRemoveContainer<Item>,
           ObservedDirectRemoveContainer<Item>,
           ObservedRemoveAllContainer<Item> {

    private JdkAwareContainer<Item> delegateJdkAwareContainer = /*
     */ DisabledJdkAwareContainer.getInstance();

    private TraversableContainer<Item> delegateTraversableContainer = /*
     */ DisabledTraversableContainer.getInstance();

    private ContainsContainer<Item> delegateContainsContainer = /*
     */ DisabledContainsContainer.getInstance();

    private RemoveContainer<Item> delegateRemoveContainer = /*
     */ DisabledRemoveContainer.getInstance();

    private DirectRemoveContainer<Item> delegateDirectRemoveContainer = /*
     */ DisabledDirectRemoveContainer.getInstance();

    private RemoveAllContainer<Item> delegateRemoveAllContainer = /*
     */ DisabledRemoveAllContainer.getInstance();

    private ObservedRemoveContainer<Item> delegateObservedRemoveContainer = /*
     */ DisabledObservedRemoveContainer.getInstance();

    private ObservedDirectRemoveContainer<Item> delegateObservedDirectRemoveContainer = /*
     */ DisabledObservedDirectRemoveContainer.getInstance();

    private ObservedRemoveAllContainer<Item> delegateObservedRemoveAllContainer = /*
     */ DisabledObservedRemoveAllContainer.getInstance();

    public GodContainer() {
        super();
    }

    public JdkAwareContainer<Item> getDelegateJdkAwareContainer() {
        return delegateJdkAwareContainer;
    }

    public void setDelegateJdkAwareContainer(final JdkAwareContainer<Item> delegateJdkAwareContainer) {
        this.delegateJdkAwareContainer = delegateJdkAwareContainer;
    }

    public TraversableContainer<Item> getDelegateTraversableContainer() {
        return delegateTraversableContainer;
    }

    public void setDelegateTraversableContainer(final TraversableContainer<Item> delegateTraversableContainer) {
        this.delegateTraversableContainer = delegateTraversableContainer;
    }

    public ContainsContainer<Item> getDelegateContainsContainer() {
        return delegateContainsContainer;
    }

    public void setDelegateContainsContainer(final ContainsContainer<Item> delegateContainsContainer) {
        this.delegateContainsContainer = delegateContainsContainer;
    }

    public RemoveContainer<Item> getDelegateRemoveContainer() {
        return delegateRemoveContainer;
    }

    public void setDelegateRemoveContainer(final RemoveContainer<Item> delegateRemoveContainer) {
        this.delegateRemoveContainer = delegateRemoveContainer;
    }

    public DirectRemoveContainer<Item> getDelegateDirectRemoveContainer() {
        return delegateDirectRemoveContainer;
    }

    public void setDelegateDirectRemoveContainer(final DirectRemoveContainer<Item> delegateDirectRemoveContainer) {
        this.delegateDirectRemoveContainer = delegateDirectRemoveContainer;
    }

    public RemoveAllContainer<Item> getDelegateRemoveAllContainer() {
        return delegateRemoveAllContainer;
    }

    public void setDelegateRemoveAllContainer(final RemoveAllContainer<Item> delegateRemoveAllContainer) {
        this.delegateRemoveAllContainer = delegateRemoveAllContainer;
    }

    public ObservedRemoveContainer<Item> getDelegateObservedRemoveContainer() {
        return delegateObservedRemoveContainer;
    }

    public void setDelegateObservedRemoveContainer(
                                                  final ObservedRemoveContainer<Item> delegateObservedRemoveContainer) {
        this.delegateObservedRemoveContainer = delegateObservedRemoveContainer;
    }

    public ObservedDirectRemoveContainer<Item> getDelegateObservedDirectRemoveContainer() {
        return delegateObservedDirectRemoveContainer;
    }

    public void setDelegateObservedDirectRemoveContainer(
                                                        final ObservedDirectRemoveContainer<Item> delegateObservedDirectRemoveContainer) {
        this.delegateObservedDirectRemoveContainer = delegateObservedDirectRemoveContainer;
    }

    public ObservedRemoveAllContainer<Item> getDelegateObservedRemoveAllContainer() {
        return delegateObservedRemoveAllContainer;
    }

    public void setDelegateObservedRemoveAllContainer(
                                                     final ObservedRemoveAllContainer<Item> delegateObservedRemoveAllContainer) {
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
    public boolean contains(final Item item)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(item);
    }

    @Override
    public boolean contains(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        return delegateContainsContainer.contains(items);
    }

    @Override
    public List<Item> toList()
    throws InvalidTraversableStateException {
        return delegateJdkAwareContainer.toList();
    }

    @Override
    public List<Item> toSequentialList()
    throws InvalidTraversableStateException {
        return delegateJdkAwareContainer.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws InvalidTraversableStateException {
        return delegateJdkAwareContainer.toArray();
    }

    @Override
    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
        return delegateTraversableContainer.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Iterable<Item> collection) {
        return delegateJdkAwareContainer.containsEqualItems(collection);
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
        delegateObservedDirectRemoveContainer.remove(item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedDirectRemoveContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedDirectRemoveContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedDirectRemoveContainer.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedDirectRemoveContainer.remove(observers, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        delegateObservedRemoveContainer.retain(observers, items);
    }

    @Override
    public void removeAll()
    throws InvalidTraversableStateException {
        delegateRemoveAllContainer.removeAll();
    }

    @Override
    public void remove(final Item item)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateDirectRemoveContainer.remove(item);
    }

    @Override
    public void remove(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateDirectRemoveContainer.remove(items);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateDirectRemoveContainer.remove(items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateDirectRemoveContainer.remove(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateDirectRemoveContainer.remove(items);
    }

    @Override
    public void retain(final Traversable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveContainer.retain(items);
    }

    @Override
    public void retain(final TraversableContainer<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveContainer.retain(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveContainer.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        delegateRemoveContainer.retain(items);
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
