package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.*;

public interface UserCreditService extends Base<UserCredit> {
	public List<Object> queryByUserId(int startRow,int pageSize,int userid) throws Exception;
	public List<Object> queryByBaid(int startRow,int pageSize,int baid) throws Exception;
	public List<Object> queryByUserId(int userid) throws Exception;
	public int getCountByUserId(int id) throws Exception;
	public List<Object> queryByBaid(int baid) throws Exception;
	public int getCountByBaid(int baid) throws Exception;
	public UserCredit queryByUserIdStatus(int userid ,int status) throws Exception ;//状态就是1、最近一周，2、最近1个月，3、最近6个月，0总共
}
