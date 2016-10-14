package com.berserker.server.dao.writer.tools;

import org.apache.ibatis.annotations.Param;

public interface UpdatePasswordMapper {
    int updatePassword(@Param("mobile") String mobile, @Param("password") String password);
}
