package com.berserker.server.dao.reader.tools;

import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MobileMgrReaderMapper {
    List<ToolsMobileMgrModel> getMobileList(@Param("leader_id") int leader_id);
    List<ToolsLeaderList> getLeaderList();
}
