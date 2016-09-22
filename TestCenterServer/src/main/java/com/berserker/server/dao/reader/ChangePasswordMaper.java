package com.berserker.server.dao.reader;

import com.berserker.server.model.tools.ChangePasswordEntity;

public interface ChangePasswordMaper {
    public int updatePassword(ChangePasswordEntity mobile);
}
