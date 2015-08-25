<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>众益网</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>

<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><h:outputLink value="index.php">首页</h:outputLink></li>
		<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
		<li><a class="current" href="#">我的公益</a></li>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页 -&gt; 我的公益（组织）</div>
	<table width="960" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="180" valign="top">
			<div style="width: 170px; height: 5px"></div>
			<table class="table3" width="170" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink
						value="http://localhost/cq/home/cp.php?ac=event&tagid=#{sessionScope.zoyiId}">我要发布</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink
						value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiGroup.userinfo.id}&do=event&view=me">活动管理</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiGroup.userinfo.id}&do=event&view=me">
						我的活动</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="http://localhost/cq/home/space.php?do=event&view=recommend">
						推荐活动</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="http://localhost/cq/home/space.php?do=event&view=city">
						同城活动</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="http://localhost/cq/home/space.php?do=event&view=all">
						全部活动</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">排行管理</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="group_soft_list.php">
						<f:param value="#{sessionScope.zoyiId}" name="gid"></f:param>
					我的排行榜</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="user_soft_list.php">个人排行榜</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="user_group_list.php">公益组织排行榜</h:outputLink></div>
					</td>
				</tr>
				<!-- 
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink
						value="group_manage_activityUserCredit.php">信用管理</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">成员管理</h:outputLink></div>
					</td>
				</tr>
				
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">益币管理</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink value="#">益币明细</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink value="#">益币充值</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink value="#">益币借贷</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="http://localhost/cq/home/space.php?do=pm">站内消息</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink value="#">收件箱</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink value="#">发件箱</h:outputLink></div>
					</td>
				</tr> -->
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink
						value="announcement_list.php">公告通知</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">我的公益圈</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="http://localhost/cq/home/space.php?do=friend">好友</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav2">— <h:outputLink
						value="user_group_list.php">公益组织</h:outputLink></div>
					</td>
				</tr>
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">咨询求助</h:outputLink></div>
					</td>
				</tr>
			</table>
			<div style="margin: 5px auto"><img src="images/ad4.jpg" /></div>
			</td>
			<td valign="top">
			<div id="tishi2">
			<table align="left">
				<h:form id="modifygroupForm">
					<tr>
						<td><h:outputLabel value="组织名：" /><h:inputText
							value="#{groupBean.group.groupName}" /></td>

						<td><h:outputLabel value="组织性质：" /><h:inputText
							value="#{groupBean.group.nature}" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="电话：" /><h:inputText
							value="#{groupBean.group.phone}" /></td>

						<td><h:outputLabel value="省份：" /><h:inputText
							value="#{groupBean.group.groupName}" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="城市：" /><h:inputText
							value="#{groupBean.group.birthCity}" /></td>

						<td><h:outputLabel value="规模：" /><h:inputText
							value="#{groupBean.group.birthProvince }" /></td>
					</tr>
					<tr>
						<td><h:outputLabel value="地址：" /><h:inputText
							value="#{groupBean.group.address }" /></td>
						<td><h:outputLabel value="Email：" /><h:inputText
							value="#{groupBean.group.email}" /></td>
					</tr>
					<tr>
						<td colspan="2"><h:outputLabel value="组织网站：" /><h:inputText
							value="#{groupBean.group.index}" /></td>
					</tr>
					<tr>
						<td colspan="2"><h:outputLabel value="logo：" /><h:inputText
							value="#{groupBean.group.logoPicture}" id="logoPicture" /></td>
					</tr>
					<tr>
						<td colspan="2"><h:outputLabel value="首页图片：" /><h:inputText
							value="#{groupBean.group.adPicture}" /></td>
					</tr>
					<tr>
						<td colspan="2"><h:outputLabel value="未来展望：" /> <FCK:editor
							instanceName="future" width="500" height="500">
							<jsp:attribute name="value">
			<h:outputText value="#{groupBean.group.future}" escape="false" />
		</jsp:attribute>
							<jsp:body>
			<FCK:config />
		</jsp:body>
						</FCK:editor></td>
					</tr>
					<tr>
						<td colspan="2"><h:commandButton action="#{groupBean.add }"
							value="新增" type="submit" /><h:commandButton type="reset"
							value="重置" /></td>
					</tr>
					<tr>
						<td colspan="2"><a4j:commandLink ajaxSingle="true"
							onclick="javascript:Richfaces.showModalPanel('modifyGroupPwd',{width:200,top:200});">修改密码 </a4j:commandLink>
						<h:outputText value="#{groupBean.errormsg}" id="emsg" /><h:messages
							id="errorinfo" /></td>
					</tr>
				</h:form>
				<tr>
					<td colspan="2"><h:form id="uploadPicture">
						<table align="left">
							<tr>
								<td><a4j:region>
									<rich:fileUpload
										fileUploadListener="#{groupBean.uploadListener}"
										maxFilesQuantity="5" autoclear="false" addControlLabel="添加图片"
										uploadControlLabel="上传" clearAllControlLabel="清除所有"
										clearControlLabel="清除" cancelEntryControlLabel="取消"
										stopControlLabel="停止" stopEntryControlLabel="停止"
										noDuplicate="true" id="upload" listHeight="100"
										ajaxSingle="true" acceptedTypes="jpg, gif, png, bmp,jpeg "
										transferErrorLabel="传输出错--文件过大或名称错误！">
										<a4j:support event="onuploadcomplete"
											reRender="picture,errorinfo" />
									</rich:fileUpload>
								</a4j:region></td>
							</tr>
							<a4j:outputPanel id="picture">
								<tr>
									<td><h:outputLabel for="groupPicture" value="请复制链接"
										rendered="#{not empty groupBean.picture}" /> <h:outputText
										id="groupPicture" value="#{groupBean.picture }" /></td>
								</tr>
								<tr>
									<td><h:graphicImage value="#{groupBean.picture }" /></td>
								</tr>
							</a4j:outputPanel>
						</table>
					</h:form></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><h:outputLink value="#">详细信息</h:outputLink></td>
				</tr>
			</table>

			<rich:modalPanel height="150" id="modifyGroupPwd" resizeable="false"
				width="200" zindex="1000">
				<h:form id="modifyGroupPwdForm">
					<a4j:region>
						<h:outputText value="修改密码" />
						<f:facet name="controls">
							<h:outputLink
								value="javascript:Richfaces.hideModalPanel('modifyGroupPwd')">close</h:outputLink>
						</f:facet>
						<rich:panel id="nid">
							<h:outputLabel value="原密码："/> <h:inputSecret value="#{group.pwd}" size="10" /><br/>
							<h:outputLabel value="新密码："/> <h:inputSecret value="#{groupBean.pwd}"  size="10" /><br/>
							<h:outputLabel value="再输一遍"/><h:inputSecret value="#{groupBean.pwd2}"  size="10" />
							<br />
							<a4j:commandLink
								onclick="Richfaces.hideModalPanel('modifyGroupPwd')"
								actionListener="#{groupBean.ajaxModifyGroupPwd}" reRender="emsg">
								<f:param name="gid" value="#{sessionScope.zoyiId}" />确定修改
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
								onclick="Richfaces.hideModalPanel('modifyGroupPwd')" value="取消" />
						</rich:panel>
					</a4j:region>
				</h:form>
			</rich:modalPanel></div>
			<div id="annoucement">
			<div id="annouce_bg"><h:outputLink
				value="announcement_list.php"  target="_blank">更多&gt;&gt;</h:outputLink></div>
			<table width="230" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
					<div class="annouce_con">
					<ul>
						<h:form>
							<c:forEach items="#{indexBean.newAnnouncement}"
								var="newAnnouncement">
								<li><h:outputLink target="_blank"
						value="announcement_content.php">
									<f:param name="aid" value="#{newAnnouncement.id}" />
									<h:outputText value="#{newAnnouncement.title }" />
								</h:outputLink></li>
							</c:forEach>
						</h:form>
					</ul>
					</div>
					</td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
	</table>

	<div><img src="images/gongyiads.png" /></div>
	<div id="hr">
	<hr />
	</div>
	<div id="footer">
	<div><h:outputLink value="#">联系我们</h:outputLink> | <h:outputLink value="#">关于我们</h:outputLink> | <h:outputLink value="#">网站地图</h:outputLink>
	| <h:outputLink value="#">友情连接</h:outputLink> | <h:outputLink value="#">网站律师</h:outputLink></div>
	<div>CopyRight 2003 © 东华大学旭日工商管理学院 版权所有</div>
	<div>地址：上海市延安西路1882号 邮编：200051</div>
	</div>
</f:view>
</body>
</html>