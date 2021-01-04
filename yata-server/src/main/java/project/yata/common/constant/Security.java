package project.yata.common.constant;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Security {
    ACCESS("access"),
    REFRESH("refresh");

    private final String type;
}
