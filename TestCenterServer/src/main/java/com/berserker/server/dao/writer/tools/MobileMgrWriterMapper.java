package com.berserker.server.dao.writer.tools;

import com.berserker.server.vo.tools.ToolsMobileMgrModel;
import org.apache.ibatis.annotations.Param;

/**
 * Created by klien on 16/9/1.
 */
public interface MobileMgrWriterMapper {
    int saveMobile(ToolsMobileMgrModel model);
    int updateMobile(ToolsMobileMgrModel model);
    int deleteMobile(@Param("id") int id, @Param("mobile") String mobile);
}
