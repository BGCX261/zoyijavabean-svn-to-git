<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<li><h:outputLink
			value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
		<li><h:outputLink style="current" value="group_self_index">我的公益</h:outputLink></li>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
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
			<div id="tishi">
			<table width="520" border="0" cellspacing="0" cellpadding="3">
				<tr>
					<td width="430" align="left" class="tdtitle">基本信息</td>
					<td width="80" align="left" valign="middle" class="tdtitle"><img
						src="images/editicon.gif" width="16" height="16" /><h:form>
						<h:outputLink
							value="http://localhost/cq/home/cp.php?ac=mtag&op=manage&tagid=#{sessionScope.zoyiId}&subop=base">
							编辑资料</h:outputLink>
					</h:form></td>
				</tr>
				<tr>
					<td colspan="2">
					<div class="tdcon"><span>名称：</span><h:outputText
						value="#{sessionScope.zoyiGroup.groupName }" /></div>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="left" class="tdtitle">联系方式</td>
				</tr>
				<tr>
					<td colspan="2">
					<div class="tdcon"><span style="margin-left: 35px">Email：</span><h:outputText
						value="#{sessionScope.zoyiGroup.email }" /></div>
					<div class="tdcon"><span style="margin-left: 35px">电话：</span><h:outputText
						value="#{sessionScope.zoyiGroup.phone }" /></div>
					<div class="tdcon"><span style="margin-left: 5px">个人网站：</span><h:outputText
						value="#{sessionScope.zoyiGroup.index }" /></div>
					</td>
				</tr>
			</table>
			<h:outputLink
				value="http://localhost/cq/home/space.php?do=mtag&tagid=#{sessionScope.zoyiId}">详细信息</h:outputLink></div>
			<div id="annoucement">
			<div id="annouce_bg"><h:outputLink
				value="announcement_list.php" target="_blank">更多&gt;&gt;</h:outputLink></div>
			<table width="230" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
					<div class="annouce_con">
					<ul>
						<h:form id="annouce">
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
			<div id="duiying_con">活动管理</div>
			<div id="duiyingxinxi">
			<p>当前显示：<h:outputLink value="group_self_activity.php">所有的活动</h:outputLink>
			<h:outputLink value="group_self_activity.php">
				我的活动</h:outputLink> <h:outputLink
				value="http://localhost/cq/home/space.php?do=event&view=recommend">
				推荐活动</h:outputLink> <h:outputLink value="http://localhost/cq/home/space.php?do=event&view=city">
				同城活动</h:outputLink> <h:outputLink value="http://localhost/cq/home/space.php?do=event&view=all">
				全部活动</h:outputLink></p>
			<h:form id="allActivityForm">
			<br/>
				<rich:dataTable id="allActivity" width="720" border="0"
					cellspacing="0" cellpadding="5" value="#{groupBean.activityData}"
					var="activity" rows="#{groupBean.pageSize }">
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="标题" />
						</f:facet>
						<h:outputLink target="_blank"
							value="http://localhost/cq/home/space.php">
							<f:param name="id" value="#{activity.id}" />
							<f:param name="do" value="event" />
							<h:outputText value="#{activity.activityName}" />
						</h:outputLink>
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="申请结束时间" />
						</f:facet>
						<h:outputText value="#{activity.deadline}" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="已申请人数" />
						</f:facet>
						<h:outputLink value="http://localhost/cq/home/cp.php?ac=event&op=members&id=#{activity.id}&status=0">
						<h:outputText value="#{activity.membernum }" />/<h:outputText value="#{activity.limitnum }" /></h:outputLink>
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="分类" />
						</f:facet>
						<h:outputText value="#{activity.benifitActivityCategory.benifitActivityCategoryName }" />
					</rich:column>
				</rich:dataTable>
				<rich:spacer />
				<rich:datascroller for="allActivity" align="left">
					<f:param value="#{sessionScope.zoyiId}" name="gid" />
					<f:param value="#{activity.benifitActivityCategory.id }"
						name="gcid" />
				</rich:datascroller>
				<rich:spacer />
			</h:form></div>
			</td>
		</tr>
	</table>
	<div><img src="images/gongyiads.png" /></div>
	<div id="hr">
	<hr />
	</div>
	<div id="footer">
	<div><h:outputLink value="#">联系我们</h:outputLink> | <h:outputLink
		value="#">关于我们</h:outputLink> | <h:outputLink value="#">网站地图</h:outputLink>
	| <h:outputLink value="#">友情连接</h:outputLink> | <h:outputLink value="#">网站律师</h:outputLink></div>
	<div>CopyRight 2003 © 东华大学旭日工商管理学院 版权所有</div>
	<div>地址：上海市延安西路1882号 邮编：200051</div>
	</div>
</f:view>
</body>
</html>
