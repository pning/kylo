package com.thinkbiganalytics.functions;

/*-
 * #%L
 * kylo-commons-util
 * %%
 * Copyright (C) 2017 - 2018 ThinkBig Analytics, a Teradata Company
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface QuadFunction<P1, P2, P3, P4, R> {

    R apply(P1 p1, P2 p2, P3 p3, P4 p4);

    default <V> QuadFunction<P1, P2, P3, P4, V> andThen(
        Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (P1 p1, P2 p2, P3 p3, P4 p4) -> after.apply(apply(p1, p2, p3, p4));
    }
}

