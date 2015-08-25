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
<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><h:outputLink value="index.php">首页</h:outputLink></li>
		<c:choose>
			<c:when test="${not empty sessionScope.zoyiGroup}">
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px">&nbsp;</li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<table width="960" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left">您的位置：首页 -&gt; 公益组织</td>
			<td width="180" align="right">
			<div id="search"><input type="text" /><h:outputLink value="#">
				<img src="images/1.gif" height="20" width="20" />
			</h:outputLink></div>
			</td>
		</tr>
	</table>

	<table width="970" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td width="150" valign="top">
			<div id="zuzhifenlei_bg">组织查询</div>
			<ul>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?do=mtag&view=hot">热门的组织</h:outputLink></li>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?do=mtag&view=me">我参与的组织</h:outputLink></li>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?do=mtag&view=hot&orderby=threadnum">全部组织</h:outputLink></li>
			</ul>
			</td>
			<td width="570" rowspan="2" valign="top">
			<div id=""><h:form id="allGroupFrom">
				<rich:dataTable id="allGroup" width="570"
					value="#{groupBean.dataModel}" var="group"
					rows="#{groupBean.pageSize }">
					<rich:column>
						<f:facet name="header">
							<h:outputText value="名称"></h:outputText>
						</f:facet>
						<h:commandLink target="_blank" action="#{groupBean.queryById}">
							<f:param name="gid" value="#{group.id}" />
							<h:outputText value="#{group.groupName}" />
						</h:commandLink>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="地址" />
						</f:facet>
						<h:outputText value="#{group.birthProvince}" />
						<h:outputText value="#{group.birthCity}" />
						<h:outputText value="#{group.address}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="联系人" />
						</f:facet>
						<h:outputText value="#{group.linkman }" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="详细" />
						</f:facet>
						<h:outputLink target="_blank" value="user_group_index.php">
							<f:param value="#{group.id}" name="gid"></f:param>
							<h:outputText value="详细" />
						</h:outputLink>
					</rich:column>
				</rich:dataTable>
				<rich:spacer />
				<rich:datascroller page="#{groupBean.scrollerPage}" for="allGroup"
					align="left">
					<f:param name="cond" value="#{groupBean.cond }"></f:param>
				</rich:datascroller>
				<rich:spacer />
			</h:form></div>
			</td>
			<h:form>
				<td width="230" rowspan="2" valign="top">
				<div id="rank">
				<div class="title">公益组织排行<h:outputLink
					style="margin-left: 60px" value="#">详情&gt;&gt;</h:outputLink></div>
				<ul>
					<c:forEach items="#{indexBean.softGroup}" var="softGroup">
						<li><div align="left"><h:commandLink target="_blank"
							action="#{groupBean.queryById}">
							<f:param name="gid" value="#{softGroup.id}" />
							<c:out value="${softGroup.groupName}" /></h:commandLink></div></li>
					</c:forEach>
				</ul>
				</div>
				<div id="rank">
				<div class="title" style="text-align: left; text-indent: 10px">最火的公益活动</div>
				<ul>
					<c:forEach items="#{indexBean.softGroup}" var="softGroup">
						<li><div align="left"><h:commandLink action="#{groupBean.queryById}"
							target="_blank">
							<f:param name="gid" value="#{softGroup.id}" />
							<c:out value="${softGroup.groupName}" /></h:commandLink></div></li>
					</c:forEach>
				</ul>
				</div>
				</td>
			</h:form>
		</tr>
		<tr>
			<td valign="bottom">
			<div style="margin: 5px"><img src="images/ad2.jpg" width="129"
				height="173" /></div>
			</td>
		</tr>
		<tr>
			<td colspan="3" valign="top"><img src="images/gongyiads.png"
				width="960" height="91" /></td>
		</tr>
	</table>
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