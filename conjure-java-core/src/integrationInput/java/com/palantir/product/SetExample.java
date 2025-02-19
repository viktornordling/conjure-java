package com.palantir.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.palantir.conjure.java.api.errors.ErrorType;
import com.palantir.conjure.java.api.errors.ServiceException;
import com.palantir.conjure.java.lib.internal.ConjureCollections;
import com.palantir.logsafe.Preconditions;
import com.palantir.logsafe.SafeArg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nonnull;

@JsonDeserialize(builder = SetExample.Builder.class)
@Generated("com.palantir.conjure.java.types.BeanGenerator")
public final class SetExample {
    private final Set<String> items;

    private final Set<Double> doubleItems;

    private int memoizedHashCode;

    private SetExample(Set<String> items, Set<Double> doubleItems) {
        validateFields(items, doubleItems);
        this.items = Collections.unmodifiableSet(items);
        this.doubleItems = Collections.unmodifiableSet(doubleItems);
    }

    @JsonProperty("items")
    public Set<String> getItems() {
        return this.items;
    }

    @JsonProperty("doubleItems")
    public Set<Double> getDoubleItems() {
        return this.doubleItems;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof SetExample && equalTo((SetExample) other));
    }

    private boolean equalTo(SetExample other) {
        return this.items.equals(other.items) && this.doubleItems.equals(other.doubleItems);
    }

    @Override
    public int hashCode() {
        int result = memoizedHashCode;
        if (result == 0) {
            result = Objects.hash(this.items, this.doubleItems);
            memoizedHashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        return "SetExample{items: " + items + ", doubleItems: " + doubleItems + '}';
    }

    public static SetExample of(Set<String> items, Set<Double> doubleItems) {
        return builder().items(items).doubleItems(doubleItems).build();
    }

    private static void validateFields(Set<String> items, Set<Double> doubleItems) {
        List<String> missingFields = null;
        missingFields = addFieldIfMissing(missingFields, items, "items");
        missingFields = addFieldIfMissing(missingFields, doubleItems, "doubleItems");
        if (missingFields != null) {
            throw new ServiceException(
                    ErrorType.create(ErrorType.Code.INVALID_ARGUMENT, "Error:MissingField"),
                    SafeArg.of("missingFields", missingFields));
        }
    }

    private static List<String> addFieldIfMissing(List<String> prev, Object fieldValue, String fieldName) {
        List<String> missingFields = prev;
        if (fieldValue == null) {
            if (missingFields == null) {
                missingFields = new ArrayList<>(2);
            }
            missingFields.add(fieldName);
        }
        return missingFields;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Generated("com.palantir.conjure.java.types.BeanBuilderGenerator")
    public static final class Builder {
        private Set<String> items = new LinkedHashSet<>();

        private Set<Double> doubleItems = new LinkedHashSet<>();

        private Builder() {}

        public Builder from(SetExample other) {
            items(other.getItems());
            doubleItems(other.getDoubleItems());
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP, contentNulls = Nulls.FAIL)
        public Builder items(@Nonnull Iterable<String> items) {
            this.items.clear();
            ConjureCollections.addAll(this.items, Preconditions.checkNotNull(items, "items cannot be null"));
            return this;
        }

        public Builder addAllItems(@Nonnull Iterable<String> items) {
            ConjureCollections.addAll(this.items, Preconditions.checkNotNull(items, "items cannot be null"));
            return this;
        }

        public Builder items(String items) {
            this.items.add(items);
            return this;
        }

        @JsonSetter(value = "doubleItems", nulls = Nulls.SKIP, contentNulls = Nulls.FAIL)
        public Builder doubleItems(@Nonnull Iterable<Double> doubleItems) {
            this.doubleItems.clear();
            ConjureCollections.addAll(
                    this.doubleItems, Preconditions.checkNotNull(doubleItems, "doubleItems cannot be null"));
            return this;
        }

        public Builder addAllDoubleItems(@Nonnull Iterable<Double> doubleItems) {
            ConjureCollections.addAll(
                    this.doubleItems, Preconditions.checkNotNull(doubleItems, "doubleItems cannot be null"));
            return this;
        }

        public Builder doubleItems(double doubleItems) {
            this.doubleItems.add(doubleItems);
            return this;
        }

        public SetExample build() {
            return new SetExample(items, doubleItems);
        }
    }
}
