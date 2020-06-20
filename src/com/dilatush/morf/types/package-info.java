/**
 * <p>Morf's type definitions fully describe arbitrary data structures as they appear from Java code, as well as from any number of other forms the
 * data structure can be morphed into.  The data structure may be as simple as a single value (much like an {@code int} variable in Java).  More
 * complex structures add type definition depth through maps, arrays, or ordered maps (much more on these concepts below).</p>
 * <p>While Morf's type definitions <i>can</i> be built programatically (that is, through code), the author's expectation is that generally Morf's
 * type definitions will be "compiled" from a "source code" string.  That string could be a Java string constant, read from a file, or even
 * constructed via code.</p>
 * <p>For example, imagine a very simple data structure to contain a contact name and address.  In Morf's type definition "language", that might
 * look like this:</p>
 * <pre>{@code
 * Contact[
 *    FirstName: String
 *    LastName: String
 *    Street1: String
 *    Street2: String
 *    City: String
 *    State: String
 *    Zip: String
 * ]
 * }</pre>
 *
 * @author Tom Dilatush  tom@dilatush.com
 */
package com.dilatush.morf.types;