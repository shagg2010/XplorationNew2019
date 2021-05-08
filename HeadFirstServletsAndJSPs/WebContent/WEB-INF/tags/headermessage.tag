<%@ attribute name="message" description="Message to be displayed" required="true" rtexprvalue="true"%> 
<%@ attribute name="color" description="Font-Color for the message" required="true" rtexprvalue="true"%> 
Message of the Day: <font color='${color}'> ${message} </font>