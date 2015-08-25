<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>众益网</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/second.css" />
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>
<style type="text/css">
#annoucelist {
	width: 572px;
	height: 584px;
	margin: 5px auto;
	background: url(images/annoucelist_bg.gif) left top no-repeat;
	padding-top: 50px
}
</style>
<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><h:outputLink value="index.php">首页</h:outputLink></li>
		<c:choose>
			<c:when test="${not empty sessionScope.zoyiGroup}">
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><a class="current" href="#">公益新闻库</a></li>
		<li style="width: 200px">&nbsp;</li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<table width="960" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left">您的位置：首页 -&gt;公告</td>
			<td width="180" align="right">
			<div id="search"><input type="text" /><h:outputLink value="#"><img
				src="images/1.gif" height="20" width="20" /></h:outputLink></div>
			</td>
		</tr>
	</table>
	<div style="margin: 10px auto"><img src="images/gongyiads.png" /></div>
	<table width="962" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="152" valign="top">
			<div id="newsclassify">
			<div id="classify_title">公告分类</div>
			
			</div>
			</td>
			<td width="580" valign="top">
			<div id="annoucelist"><h:form>
				<rich:dataTable id="allAnnouncement" width="520" border="0"
					cellspacing="0" cellpadding="4" columnsWidth="70%,18%,12%"
					value="#{announcementBean.dataModel}" var="announcement"
					rows="#{announcementBean.pageSize }">
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="公告标题" />
						</f:facet>
						<h:commandLink target="_blank"
							action="#{announcementBean.queryById}">
							<f:param name="aid" value="#{announcement.id}" />
							<h:outputText value="#{announcement.title}" />
						</h:commandLink>
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="时间" />
						</f:facet>
						<h:outputText value="#{announcement.createDate }">
							<f:convertDateTime pattern="yyyy年MM月dd日" />
						</h:outputText>
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="发布者" />
						</f:facet>
						<h:outputText value="#{announcement.announcer }" />
					</rich:column>
				</rich:dataTable>
				<rich:spacer />
				<rich:datascroller page="#{announcementBean.scrollerPage}"
					for="allAnnouncement" align="left" />
				<rich:spacer />
			</h:form></div>
			</td>
			<td width="230" valign="top">
			<div style="width: 218px; height: 199px; margin: 5px auto"><img
				src="images/newsad.jpg" /></div>
			<h:form><div id="rank">
			<div class="title">个人排行<h:outputLink style="margin-left: 90px" value="#">详情&gt;&gt;</h:outputLink></div>
			<ul>
				
					<c:forEach items="#{indexBean.softUser}" var="softUser">
						<li><c:out value="${softUser.name}"></c:out> <h:commandLink
							target="_blank" action="#"><f:param value="#{softUser.userId}" name="uid"></f:param>--&gt;</h:commandLink></li>
					</c:forEach>
				
			</ul>
			</div>
			<div id="rank">
			<div class="title">公益组织排行<h:outputLink style="margin-left: 60px" value="#">详情&gt;&gt;</h:outputLink></div>
			<ul>
			<c:forEach items="#{indexBean.softGroup}" var="softGroup">
				<li><c:out value="${softGroup.groupName}"/> <h:commandLink target="_blank" action="#{groupBean.queryById}"><f:param name="gid" value="#{softGroup.id}"></f:param>--&gt;</h:commandLink></li>
				</c:forEach>
			</ul>
			</div>
			</h:form>
			</td>
		</tr>
	</table>
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