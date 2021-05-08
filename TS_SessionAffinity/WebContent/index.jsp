<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


    
        
        <title>Books Card - Base Instance</title>
    
    
		<span style="color: blue; font-size: small;">
			Server: Instance 3
        </span>
       <br>
        <hr>

        <span style="color: #cc0000; font-size: large;">
         

        Session Id : <%=request.getSession().getId()%>  <br>

        Is it New Session : <%=request.getSession().isNew()%> <br>

        Session Creation Date : <%=new Date(request.getSession().getCreationTime())%> <br>

        Session Access Date : <%=new Date(request.getSession().getLastAccessedTime())%> <br>

		
        </span>
        <br>
        <b>Cart List </b>

        <hr>
        
        
        <ul>
        <%		
                String bookName = request.getParameter("bookName");
                List<String> listOfBooks = (List<String>) request.getSession().getAttribute("Books");

                if (listOfBooks == null) {
                    listOfBooks = new ArrayList<String>();
                    request.getSession().setAttribute("Books", listOfBooks);
                }
                if (bookName != null) {
                    listOfBooks.add(bookName);
                    request.getSession().setAttribute("Books", listOfBooks);
                }


                for (String book : listOfBooks) {
                    out.println("<li>"+book + "</li>");
                }
            
        %>
        </string></string></string></ul>
<hr>
        <form action="index.jsp" method="post">
            Book Name <input name="bookName" type="text">

            <input type="submit" value="Add to Cart">
        </form>
<hr>
    


