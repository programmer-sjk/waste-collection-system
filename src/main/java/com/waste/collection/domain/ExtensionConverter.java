package com.waste.collection.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ExtensionConverter implements AttributeConverter<ThumbnailExtension, String> {
    @Override
    public String convertToDatabaseColumn(ThumbnailExtension extension) {
        return extension.name().toLowerCase();
    }

    @Override
    public ThumbnailExtension convertToEntityAttribute(String dbData) {
        return ThumbnailExtension.of(dbData.toUpperCase());
    }
}
