package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
	//�û���¼
	public BackendUser login(String userCode,String userPassword)throws Exception;
}
