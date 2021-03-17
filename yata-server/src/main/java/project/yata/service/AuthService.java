package project.yata.service;

import project.yata.dto.AccountRequest;
import project.yata.dto.AccountResponse;
import project.yata.dto.LoginResponse;

/**
 * 회원인증 서비스
 *
 * @author JisuNa
 * @version 1.0
 * @since 2020.08.25
 */
public interface AuthService {
    /**
     * 이메일 중복체크
     *
     * @param email 이메일 주소
     */
    void checkDuplicateEmail(String email);

    /**
     * 회원가입
     *
     * @param joinRequest 회원가입 정보
     * @return {@link AccountResponse}
     */
    AccountResponse join(AccountRequest joinRequest);

    /**
     * 로그인
     *
     * @param email    이메일 주소
     * @param password 비밀번호
     * @return JWT
     */
    LoginResponse login(String email, String password);
}
