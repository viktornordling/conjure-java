package com.palantir.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.palantir.conjure.java.api.errors.ErrorType;
import com.palantir.conjure.java.api.errors.ServiceException;
import com.palantir.logsafe.Preconditions;
import com.palantir.logsafe.SafeArg;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;

@JsonDeserialize(builder = AnyExample.Builder.class)
@Generated("com.palantir.conjure.java.types.BeanGenerator")
public final class AnyExample {
    private final Object any;

    private AnyExample(Object any) {
        validateFields(any);
        this.any = any;
    }

    @JsonProperty("any")
    public Object getAny() {
        return this.any;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof AnyExample && equalTo((AnyExample) other));
    }

    private boolean equalTo(AnyExample other) {
        return this.any.equals(other.any);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.any);
    }

    @Override
    public String toString() {
        return "AnyExample{any: " + any + '}';
    }

    public static AnyExample of(Object any) {
        return builder().any(any).build();
    }

    private static void validateFields(Object any) {
        List<String> missingFields = null;
        missingFields = addFieldIfMissing(missingFields, any, "any");
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
                missingFields = new ArrayList<>(1);
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
        private Object any;

        private Builder() {}

        public Builder from(AnyExample other) {
            any(other.getAny());
            return this;
        }

        @JsonSetter("any")
        public Builder any(@Nonnull Object any) {
            this.any = Preconditions.checkNotNull(any, "any cannot be null");
            return this;
        }

        public AnyExample build() {
            return new AnyExample(any);
        }
    }
}
