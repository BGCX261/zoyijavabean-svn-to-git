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
	<h:form id="allUserCreditForm">
						<rich:dataTable id="allUserCredit" align="center"
							value="#{usermodelbean.userCreditData}" var="userCredit"
							rows="#{usermodelbean.pageSize }">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="活动名" />
								</f:facet>
								<h:outputLink
									value="http://localhost/cq/home/space.php?do=event&id=#{userCredit.benifitActivity.id}">
									<h:outputText
										value="#{userCredit.benifitActivity.activityName}" />
								</h:outputLink>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="组织" />
								</f:facet>
								<h:outputLink
									value="http://localhost/cq/home/space.php?do=mtag&tagid=#{userCredit.benifitActivity.group.id}">
									<h:outputText value="#{userCredit.benifitActivity.group.groupName}" />
								</h:outputLink>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="得到爱心" />
								</f:facet>
								<h:outputText value="#{userCredit.credit}" />
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="黑心" />
								</f:facet>
								<h:outputText value="#{userCredit.darkmind }" />
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="评分时间" />
								</f:facet>
								<h:outputText value="#{userCredit.getCreditDate }" >
								<f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>
							</rich:column>
						</rich:dataTable>
						<rich:datascroller align="center" for="allUserCredit">
						</rich:datascroller>
						<rich:spacer height="10" />
					</h:form>
</f:view>
</body>
</html>