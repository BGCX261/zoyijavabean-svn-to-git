/**
 * 
 */
package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.Group;

/**
 * @author dhibmclub
 * 
 */
public interface GroupService extends Base<Group> {

	public int getCount() throws Exception;
	public Group login(String email,String pwd) throws Exception;//��֯��¼
	public Group getGroupStar() throws Exception;//�õ�һ�������ŵ�Group��������������
	public Group getNewGroup() throws Exception; 
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception;
	public String queryPicById(int id) throws Exception;//�õ�һ����֯��Logo
	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception;//���ղ�����������
	public int getApplyUserCount(int groupId) throws Exception;//�����֯�ŵõ��������֯��Userinfo������
	public List<Object> queryApplyUserByGroupId(int startRow, int pageSize,
			int id) throws Exception;//�����֯�ŵõ��������֯��Userinfo
	public String refuseApplyGroupUser(int userId, int groupId) throws Exception;// �ܾ������Ϊ��֯��Ա���˵�����
	public String acceptApplyGroupUser(int uid, int id) throws Exception;// ���������Ϊ��֯��Ա���˵�����;
	public String modifyGroupPwd(int groupId,String pwd) throws Exception;
	public Group queryGroupByEmail(String email) throws Exception;//���鲻������null
	public boolean isRightPwd(String email,String codePwd) throws Exception;
	public String getCodePwd(String email) throws Exception; 
	public Group queryGroupByBAId(String baid) throws Exception;
	public boolean isGroup(String username) throws Exception;
	public Group queryByUsername(String username) throws Exception;

}