package project.yata.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Code {
    SUCCESS("0000", "정상처리"),
    ERROR0001("0001", "필수값 누락"),
    ERROR0002("0002", "중복");

    final String code;
    final String message;
}
