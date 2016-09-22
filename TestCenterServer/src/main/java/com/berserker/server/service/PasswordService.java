package com.berserker.server.service;

/**
 * @author klien
 */
public interface PasswordService {
    public String changePassword(String mobile, String password, String TargetDataSource);
}
