package com.berserker.server.service.page;

import com.berserker.server.model.page.QuickLinkModel;
import com.berserker.server.model.page.SideBarModel;
import com.berserker.server.model.page.TopBarModel;

/**
 * @author klien
 */
public interface PageComponentService {
    QuickLinkModel getQuickLinkElements();
    TopBarModel getTopBarElements();
    SideBarModel getSideBarElements();
}
