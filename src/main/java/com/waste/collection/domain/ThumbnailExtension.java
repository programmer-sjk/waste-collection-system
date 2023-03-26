package com.waste.collection.domain;

import java.util.Arrays;

public enum ThumbnailExtension {
    JPG, JPEG, PNG, SVG;

    public static ThumbnailExtension of(String name) {
        return Arrays.stream(values())
                .filter(v -> v.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정의되지 않은 확장자입니다."));
    }
}
