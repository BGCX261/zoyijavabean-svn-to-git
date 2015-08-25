<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
table p {
	text-indent: 2em
}

.zuzhiintro {
	width: 650px;
	height: auto;
	background: #E1F6CA url(images/bottom.gif) no-repeat left bottom;
	padding-bottom: 20px
}

.zuzhiintro h6 {
	background: url(images/top.gif) no-repeat left top
}

.zuzhiintro table {
	border-left: 1px solid #657A4E;
	border-right: 1px solid #657A4E
}

.tdtitle {
	text-indent: 10px
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
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页 -&gt; 公益组织</div>
	<table width="980" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="210" valign="top">
			<div id="zuzhifenlei_bg">活动查询</div>
			<ul>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?uid=6&do=event&view=me">我的组织</h:outputLink></li>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?do=event&view=city">同城活动</h:outputLink></li>
				<li><h:outputLink target="_blank"
					value="http://202.120.148.197/cq/home/space.php?do=event&view=recommend">推荐活动</h:outputLink></li>
				<li><h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php?do=event&view=all">全部活动</h:outputLink></li>
				<li><h:outputLink value="user_group_activity_list.php">公益列表</h:outputLink></li>
			</ul>
			</td>
			<td width="770" align="left" style="text-align: left;">
			<div style="text-align: left;" class="zuzhiintro">
			<h6>&nbsp;</h6>
			<table width="650" border="0" cellspacing="5" cellpadding="3"
				align="left" style="text-align: left; font-size: 12px">
				<tr>
					<td colspan="4" align="left" class="tdtitle">活动信息</td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;活动名称：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.activityName }" /></td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;申请截止时间：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.deadline }" />&nbsp;</td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;活动时间：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.starttime }" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>~<h:outputText
						value="#{benifitActivityBean.benifitActivity.endtime  }" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>&nbsp;</td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;接受报名人数：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.limitnum }" />&nbsp;</td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;举办组织：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.group.groupName }" />&nbsp;</td>
				</tr>
				<tr align="left">
					<td align="left">&nbsp;活动介绍：</td>
					<td colspan="3" align="left">&nbsp;<h:outputText
						value="#{benifitActivityBean.benifitActivity.detail }"
						escape="false" />&nbsp;</td>
				</tr>
				<c:choose>
					<c:when
						test="${not empty benifitActivityBean.benifitActivity.poster}">
						<tr align="left">
							<td align="left">&nbsp;海报：</td>
							<td colspan="3" align="left">&nbsp;<h:outputText
								value="#{benifitActivityBean.benifitActivity.poster }" />&nbsp;</td>
						</tr>
					</c:when>
				</c:choose>
				<tr align="left">
					<td colspan="4" align="left"><h:outputText
						value="#{benifitActivityBean.errormsg}" id="errorinfo"></h:outputText>
					&nbsp;<h:messages /></td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
	</table>
	<div id="enterbtn">
		<h:outputLink value="http://localhost/cq/home/space.php?do=event&id=#{benifitActivityBean.benifitActivity.id}">
			<img src="images/woyaojiaru.gif" />
		</h:outputLink>
	</div>
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