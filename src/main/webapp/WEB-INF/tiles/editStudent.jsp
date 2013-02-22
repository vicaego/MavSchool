<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/contacts.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Contact Form</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
 		<form:form action="updateStudent.do" method="post" commandName="editStudent">
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">					
					<tr>
						<td width="100" align="right">Id</td>
						<td width="150">
						<form:input path="id" readonly="true"/></td>
						<td align="left">
						<form:errors path="id" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Surname</td>
						<td>
						<form:input path="surname"/></td>
						<td align="left">
						<form:errors path="surname" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Forename</td>
						<td>
						<form:input path="forename"/></td>
						<td align="left">
						<form:errors path="forename" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					<tr>
						<td width="100" align="right">DOB</td>
						<td><form:input path="dob"/></td>
						<td align="left"><form:errors path="dob" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr>
						<td width="100" align="right">Address</td>
						<td><form:input path="address"/></td>
						<td align="left">
						<form:errors path="address" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteContact('deleteStudent.do?id=${editContact.id}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllStudents.do');">
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
