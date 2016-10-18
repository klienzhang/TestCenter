package com.berserker.server.dao.reader.tools;

import com.berserker.server.vo.tools.MobileDeviceModel;
import com.berserker.server.vo.tools.ToolsLeaderList;
import com.berserker.server.vo.tools.ToolsMobileMgrModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MobileMgrReaderMapper {
    List<MobileDeviceModel> getMobileDeviceList(@Param("brandId") int branchId, @Param("typeId") int typeId);
    List<ToolsLeaderList> getLeaderList();
    ToolsMobileMgrModel getMobileInfo(@Param("id") int id);
    List<ToolsMobileMgrModel> getMobileList(ToolsMobileMgrModel mobileMgrModel);
}
