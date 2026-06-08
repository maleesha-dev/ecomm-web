<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="lk.novasphere.ecomm.user.remote.TestRemote" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: Maleesha
  Date: 6/7/2026
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    // @EJB
    // private TestRemote testRemote;
%>
<h1>Index Page!</h1>

<%

    try {

        InitialContext ic = new InitialContext();
        TestRemote tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");
        tr.test();

    } catch (NamingException e) {
        throw new RuntimeException(e);
    }

%>

</body>
</html>
