
    <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/menu.jsp" />

		</div>
	</nav>



<form  action="${pageContext.request.contextPath}/admin/importExcel"class="login-form" method="POST">        
                   <input type='file' name="file2" value ="choisir un fihcier">
                 <br>
                   <input type="submit" value="importer/"/>							
						</form>




	<jsp:include page="../fragments/adminfooter.jsp" />

