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
			<div id="tishi"><h:form>
				<h1 align="center">管理活动</h1>
				<rich:dataTable id="allBenifitActivity" align="center"
					value="#{groupBean.activityData}" var="activity"
					rows="#{benifitActivityBean.pageSize }">
					<rich:column>
						<f:facet name="header">
							<h:outputText value="活动号" />
						</f:facet>
						<h:outputText value="#{activity.id}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="活动标题" />
						</f:facet>
						<h:commandLink target="_blank"
							action="#{benifitActivityBean.queryById}">
							<f:param name="baid" value="#{activity.id}" />
							<h:outputText value="#{activity.activityName }" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="活动地点" />
						</f:facet>
						<h:outputText value="#{activity.activityPlace}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="申请截止时间" />
						</f:facet>
						<h:outputText value="#{activity.applyDeadline}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="已报名/已接受/上限" />
						</f:facet>
						<h:outputLink value="group_accept_user.php">
							<f:param name="gid" value="#{activity.group.id}"/>
							<f:param name="baid" value="#{activity.id}"/>
							<f:param name="status" value="0"/>
							<h:outputText value="#{activity.applyingPeopleNum }" />/<h:outputText
								value="#{activity.acceptedPeopleNum }" />/<h:outputText
								value="#{activity.limitPeopleNum}" />
						</h:outputLink>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="编辑" />
						</f:facet>
						<h:commandLink action="#{benifitActivityBean.preModify}">
							<f:param name="baid" value="#{activity.id}" />
							<h:outputText value="编辑" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
				<rich:datascroller align="center" for="allBenifitActivity">
					<f:param name="baid" value="#{param.baid}" />
					<f:param name="status" value="#{param.status}" />
				</rich:datascroller>
				<rich:spacer />
			</h:form><h:outputLink value="#">详细信息</h:outputLink></div>
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