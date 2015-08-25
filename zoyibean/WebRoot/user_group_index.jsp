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
		<li><h:outputLink
			value="http://localhost/cq/home/space.php?do=event&view=all">公益活动库</h:outputLink></li>
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
			<div id="zuzhi_logo"><h:graphicImage width="150" height="130"
				value="#{groupBean.group.logoPicture}" /><br />
			</div>
			<div id="fast_con"><h:outputText value="#{groupBean.group.groupName}" /></div>
			<h:form>
				<div class="button"><h:outputLink
					value="http://localhost/cq/home/space.php">
					<f:param name="do" value="mtag" />
					<f:param name="tagid" value="#{groupBean.group.id}" />【基本信息】</h:outputLink></div>
				<div class="button"><h:outputLink
					value="http://localhost/cq/home/space.php">
					<f:param name="view" value="event" />
					<f:param name="do" value="mtag" />
					<f:param name="tagid" value="#{groupBean.group.id}" />【活动信息】</h:outputLink></div>
				<div class="button"><h:outputLink value="#">【组织介绍】</h:outputLink></div>
				<div class="button"><h:outputLink value="#">【组织规模】</h:outputLink></div>
				<div class="button"><h:outputLink value="#">【未来展望】</h:outputLink></div>
			</h:form></td>
			<td width="770">
			<div class="zuzhiintro">
			<h6>&nbsp;</h6>
			<table width="650" border="0" cellspacing="5" cellpadding="3"
				style="text-align: left; font-size: 12px">
				<tr>
					<td colspan="4" align="left" class="tdtitle">基本信息</td>
				</tr>
				<tr>
					<td width="100" align="right">名称：</td>
					<td width="200"><h:outputText
						value="#{groupBean.group.groupName}" /></td>
					<td width="100" align="right">组织分类：</td>
					<td width="200"><h:outputText
						value="#{groupBean.group.groupCategory.title}" /></td>
				</tr>
				<tr>
					<td align="right">地址：</td>
					<td colspan="3"><h:outputText
						value="#{groupBean.group.birthProvince}" /><h:outputText
						value="#{groupBean.group.birthCity}" /><h:outputText
						value="#{groupBean.group.address}" /></td>
				</tr>
				<tr>
					<td align="right">Index：</td>
					<td colspan="3">
					<p align="left"><h:outputText value="#{groupBean.group.index }" /></p>
					</td>
				</tr>
				<tr>
					<td align="right">联系人：</td>
					<td>
					<p align="left"><h:outputLink
						value="http://202.120.148.197/cq/home/space.php">
						<f:param name="username" value="#{groupBean.group.linkman}" />
						<h:outputText value="#{groupBean.group.linkman}" />
					</h:outputLink></p>
					</td>
					<td align="right">电话：</td>
					<td>
					<p align="left"><h:outputText value="#{groupBean.group.phone}" /></p>
					</td>
				</tr>
				<tr>
					<td align="right">邮箱：</td>
					<td><h:outputText value="#{groupBean.group.email}" /></td>
					<td align="right">成立时间：</td>
					<td>
					<p align="left"><h:outputText
						value="#{groupBean.group.birthDay}" ><f:convertDateTime pattern="yyyy年MM月dd日"/></h:outputText></p>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="left" class="tdtitle">组织介绍</td>
				</tr>
				<tr>
					<td colspan="4" align="left">
					<p align="left"><h:outputText
						value="#{groupBean.group.aboutGroup }" escape="false" /></p>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="left" class="tdtitle">未来展望</td>
				</tr>
				<tr>
					<td colspan="4" align="left">
					<p align="left"><h:outputText value="#{groupBean.group.future}"
						escape="false" /></p>
					</td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
	</table>
	<div id="enterbtn"><h:outputLink
		value="http://localhost/cq/home/space.php">
		<f:param name="do" value="mtag" />
		<f:param name="tagid" value="#{groupBean.group.id}" />
		<img src="images/enterbtn.gif" />
	</h:outputLink></div>
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