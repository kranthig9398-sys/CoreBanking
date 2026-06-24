package com.cb.common.service.interfaces;

import com.cb.common.dto.CBMenusFInalResponseDTO;

public interface CBMenuCommonStateModuleServiceInterface {
	CBMenusFInalResponseDTO getCommonStateModuleMenus(int stateCode, int loginLevel);
}
