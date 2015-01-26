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

package org.jlib.object_spi.apachecommons;

import org.apache.commons.lang3.builder.ToStringStyle;

import static org.jlib.object_spi.apachecommons.ApacheCommonsObjectMethodForwarder.TO_STRING_STYLE_NAME_PROPERTY_NAME;
import org.junit.After;
import org.junit.Before;

public class IdentifierOrClassNamePropertyToStringStyleSupplierTest {

    public static class MyStyle
    extends ToStringStyle {

        private static final long serialVersionUID = - 1306981006542884518L;
    }

    public static class SomethingWithDefaultConstructor {

    }

    public static class SomethingWithoutDefaultConstructor {

        @SuppressWarnings("UnusedParameters")
        public SomethingWithoutDefaultConstructor(final Object object) {}
    }

    @Before
    @After
    public void clearProperty() {
        System.clearProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME);
    }

    // createToStringStyleInstance

//    @Test
//    public void styleClassNameShouldCreateStyleClass() {
//        assertThat(createToStringStyleInstance(MyStyle.class.getName())).hasSameClassAs(new MyStyle());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void withDefaultConstructorClassNameShouldThrowException() {
//        createToStringStyleInstance(SomethingWithDefaultConstructor.class.getName());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void withoutDefaultConstructorClassNameShouldThrowException() {
//        createToStringStyleInstance(SomethingWithoutDefaultConstructor.class.getName());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void notExistingClassNameShouldThrowException() {
//        createToStringStyleInstance("org.jlib.i.do.not.Exist");
//    }
//
//    // ---
//
//    // fetchToStringStyle
//
//    @Test
//    public void unsetPropertyShouldCreateDefaultStyleClass() {
//        assertThat(fetchToStringStyle()).isSameAs(DEFAULT_STYLE);
//    }
//
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void emptyPropertyShouldThrowException() {
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, "");
//
//        fetchToStringStyle();
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void blankPropertyShouldThrowException() {
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, " ");
//
//        fetchToStringStyle();
//    }
//
//    @Test
//    public void classNamePropertyShouldCallCreateInstanceMethod()
//    throws Exception {
//        // given
//        mockStatic(IdentifierOrClassNamePropertyToStringStyleSupplier.class);
//
////        spy(ToStringStyleUtility.class);
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, "some.Class");
////        when(ToStringStyleUtility.class, "createToStringStyleInstance", "some.Class").thenReturn(new MyStyle());
////        when(ToStringStyleUtility.class,
////             method(ToStringStyleUtility.class, "createToStringStyleInstance", String.class)).withArguments(
////                                                                                                           "some
//// .Class")
////                                                                                             .thenReturn(new
//// MyStyle());
//
//        doReturn(new MyStyle()).when(IdentifierOrClassNamePropertyToStringStyleSupplier.class);
//
//        // when
//        fetchToStringStyle();
//
//        // then
//        verify(IdentifierOrClassNamePropertyToStringStyleSupplier.class).invoke("createToStringStyleInstance",
//                                                                                "some.Class");
//        verifyStatic();
////        createToStringStyleInstance("some.Class");
//    }
}
