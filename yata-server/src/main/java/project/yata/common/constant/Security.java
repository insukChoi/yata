package project.yata.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Security {
    ACCESS("access"),
    REFRESH("refresh");

    private final String type;
}
