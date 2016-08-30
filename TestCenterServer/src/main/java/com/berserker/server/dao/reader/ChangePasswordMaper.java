package com.berserker.server.dao.reader;

import com.berserker.server.entity.tools.ChangePasswordEntity;
import org.apache.ibatis.annotations.Param;

public interface ChangePasswordMaper {
    public int updatePassword(ChangePasswordEntity mobile);
}
