package project.yata.service;

import project.yata.dto.AccountResponse;

/**
 * 회원관리 서비스
 *
 * @author JisuNa
 * @version 1.0
 * @since 20.10.18
 */
public interface AccountService {
    /**
     * 회원 조회
     *
     * @param email 조회 키워드
     * @return AccountResponse
     */
    AccountResponse getAccount(String email);
}
