<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
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
			value="http://localhost/cq/home/space.php?uid=#{userinfobean.userinfo.userId }">他的主页</h:outputLink></li>
		<li><a class="current" href="#">他的公益</a></li>
		<li><h:outputLink value="user_group_activity_list.php">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页 -&gt; 公益排名</div>
	<table width="960" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="180" valign="top">
			<div style="width: 170px; height: 5px"></div>
			<h:form>
				<table class="table3" width="170" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink
							value="http://localhost/cq/home/space.php?do=event&view=all">活动查看</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?uid=3&do=event&view=me">我的活动</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?do=event&view=city">同城活动</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?do=event&view=recommend">推荐活动</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?do=event&view=all&type=going">尚未结束的活动</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?do=event&view=all&type=over">已经结束的活动</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink value="#">排行查看</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="user_soft_list.php">
							<f:param name="uid" value="#{usermodelbean.userinfo.userId }" />他的排行榜</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink value="user_soft_list.php">个人排行榜</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="group_soft_list.php">公益组织排行榜</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink
							value="user_manage_credit.php">信用查看</h:outputLink></div>
						</td>
					</tr>
					<!-- 
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink value="#">益币查看</h:outputLink></div>
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
					</tr>-->
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink
							value="http://localhost/cq/home/space.php?do=pm">站内消息</h:outputLink></div>
						</td>
					</tr>
					<!-- 
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
						<div class="leftnav1"><h:outputLink value="#">我的公益圈</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="http://localhost/cq/home/space.php?do=friend">益友</h:outputLink></div>
						</td>
					</tr>

					<tr>
						<td>
						<div class="leftnav2">— <h:outputLink
							value="user_group_list.php">公益组织</h:outputLink></div>
						</td>
					</tr>
					<!-- 
				<tr>
					<td>
					<div class="leftnav1"><h:outputLink value="#">黑名单</h:outputLink></div>
					</td>
				</tr> -->
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink value="#">认证中心</h:outputLink></div>
						</td>
					</tr>
					<tr>
						<td>
						<div class="leftnav1"><h:outputLink value="#">咨询求助</h:outputLink></div>
						</td>
					</tr>
				</table>
			</h:form>
			<div style="margin: 5px auto"><img src="images/ad4.jpg" /></div>
			</td>
			<td valign="top">
			<div id="tishi">
			<table width="520" border="0" cellspacing="0" cellpadding="3">
				<tr>
					<td width="430" align="center"><h:form>
				<rich:dataTable id="allUser" width="660" border="0" cellspacing="0"
					cellpadding="4" value="#{usermodelbean.dataModel}" var="userinfo"
					rows="#{usermodelbean.pageSize }">

					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="排名" />
						</f:facet>
						<h:outputText value="#{usermodelbean.dataModel.rowIndex}" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="姓名" />
						</f:facet>
						<h:outputText value="#{userinfo.name }" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="性别" />
						</f:facet>
						<h:outputText value="#{userinfo.gender }" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="地址" />
						</f:facet>
						<h:outputText value="#{userinfo.nowAddress}" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="爱心值" />
						</f:facet>
						<h:outputText value="#{userinfo.credit}" />
					</rich:column>
					<rich:column style="text-align:left;">
						<f:facet name="header">
							<h:outputText value="详细" />
						</f:facet>
						<h:commandLink target="_blank" action="user_soft_list.php">
							<f:param name="uid" value="#{userinfo.userId}" />
							<h:outputText value="详细" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
				<rich:spacer />
				<rich:datascroller for="allUser" align="left" />
				<rich:spacer />
			</h:form>
					</td>
				</tr>
			</table>
			<h:outputLink target="_blank"
				value="http://localhost/cq/home/cp.php"></h:outputLink></div>
			
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