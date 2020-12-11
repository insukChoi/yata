package project.yata.common.constant;

import lombok.Getter;

@Getter
public enum Security {
    ACCESS("access"),
    REFRESH("refresh");

    private final String type;

    private Security(String type){
        this.type = type;
    }
}
