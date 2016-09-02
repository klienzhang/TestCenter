package com.berserker.server.dao.writer.tools;

import com.berserker.server.model.tools.ToolsMobileMgrModel;

/**
 * Created by klien on 16/9/1.
 */
public interface MobileMgrWriterMapper {
    int saveMobile(ToolsMobileMgrModel model);
    int updateMobile(ToolsMobileMgrModel model);
    int deleteMobiel(ToolsMobileMgrModel model);
}
