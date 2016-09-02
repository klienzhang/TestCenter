package com.berserker.server.service;

import com.berserker.server.entity.tools.ChangePasswordEntity;

/**
 * @author klien
 */
public interface PasswordService {
    public String changePassword(String mobile, String password, String TargetDataSource);
}
