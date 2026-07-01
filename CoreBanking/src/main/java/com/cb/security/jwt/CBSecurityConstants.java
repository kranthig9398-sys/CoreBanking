package com.cb.security.jwt;


	public final class CBSecurityConstants {

	    private CBSecurityConstants() {}

	    public static final String[] PUBLIC_URLS = {
	            "/gbm/hello",
	            "/jwttoken/logintest",
	            "/jwttoken/validateToken",
	            "/cbuser/hello",
	            "/cb/common/api/menus",
	            "/cb/common/dynamic/module/menus",
	            "/cb/common/dynamic/state/menus/list",
	            "/cb/common/dynamic/statecode/sub/menus/list",
	            "/cb/common/transaction/search/**",
	            "/cb/common/transaction/details/**",
	            "/cb/common/transaction/process",
	            "/cb/cbuser/validateuser",
	            "/cb/common/dynamic/statecode/get/menus/list/**",
	            "/cb/common/modules/groups/**",
	            "/cb/common/get/anoncement/list",
	            "/cb/cbuser/user/profile/monitoring",
	            "/cb/cbuser/user/profile/validate/**",
	            "/cb/common/bodeod/api/test/eod",
	            "/cb/common/bodeod/api/test/access",
	            "/cb/common/bodeod/api/test/success",
	            "/cb/common/bodeod/api/test/bod",
	            "/cb/common/bodeod/module/api/validate/bodeod",
	            "/cb/common/bodeod/module/api/validate/bodeod",
	            "/cb/common/bodeod/module/api/perform/bodeod/entry",
	            "/cb/common/bodeod/module/api/perform/update/eod/entry"
	    };
	}