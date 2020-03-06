package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
	//ÓÃ»§µÇÂ¼
	public BackendUser login(String userCode,String userPassword)throws Exception;
}
