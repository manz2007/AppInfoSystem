package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	//���USER
	public DevUser getLoginUser(@Param("devCode")String devCode)throws Exception;
}
