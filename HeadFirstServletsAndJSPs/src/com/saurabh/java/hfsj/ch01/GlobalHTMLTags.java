package com.saurabh.java.hfsj.ch01;

import java.util.List;


public class GlobalHTMLTags {
	
	public static String doStartHTMLBody(String title){
		StringBuffer bodyStart = new StringBuffer();
		bodyStart.append("<HTML>\n");
		bodyStart.append("<HEAD>\n");
		bodyStart.append("<TITLE>" + title +"\n");
		bodyStart.append("</TITLE>\n");
		bodyStart.append("</HEAD>\n");
		bodyStart.append("<BODY>");
		return bodyStart.toString();
	}
	
	public static String doStartHTMLBody(String title, StringBuffer bodyBuffer){
		StringBuffer bodyStart = new StringBuffer();
		bodyStart.append("<HTML>\n");
		bodyStart.append("<HEAD>\n");
		bodyStart.append("<TITLE>" + title +"\n");
		bodyStart.append("</TITLE>\n");
		bodyStart.append("</HEAD>\n");
		bodyStart.append("<BODY>");
		bodyStart.append(bodyBuffer.toString());
		return bodyStart.toString();
	}
	
	public static String doStartHTMLBody(String title, String cssExternalSytleSheetFileName, StringBuffer bodyBuffer){
		StringBuffer bodyStart = new StringBuffer();
		bodyStart.append("<HTML>\n");
		bodyStart.append("<HEAD>\n");
		bodyStart.append("<LINK rel='stylesheet' type='text/css' href='" + cssExternalSytleSheetFileName + "'>\n");
		bodyStart.append("<TITLE>" + title +"\n");
		bodyStart.append("</TITLE>\n");	
		bodyStart.append("</HEAD>\n");
		bodyStart.append("<BODY>");
		bodyStart.append(bodyBuffer.toString());
		return bodyStart.toString();
	}
	
	public static String doAppendCSSFile(String cssExternalSytleSheetFileName){
		StringBuffer linkTag = new StringBuffer();
		linkTag.append("<LINK rel='stylesheet' type='text/css' href='" + cssExternalSytleSheetFileName + "'>\n");
		return linkTag.toString();
	}
	
	public static String doEndHTMLBody(){
		StringBuffer bodyEnd = new StringBuffer();
		bodyEnd.append("</BODY>\n");
		bodyEnd.append("</HTML>");
		return bodyEnd.toString();
	}
	
	public static String doAppendHeading(String headingLevel, String heading){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("\n<H" + headingLevel+ ">");
		bodyBuffer.append(heading);
		bodyBuffer.append("</H" + headingLevel+ ">\n");
		return bodyBuffer.toString();
	}
	
	public static String doAppendImage(String imageSrc, String align, String height, String width, String altText){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("<img src='"+imageSrc+"'");
		bodyBuffer.append(" alt='"+altText+"' align='"+align+"' height='"+height+ "' width='"+width+"'/><br><br>\n");
		return bodyBuffer.toString();
	}
	
	public static String doAppendHtmlTable(int borderWidth, String tableContents){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("<table border='"+borderWidth+"'>\n");
		bodyBuffer.append(tableContents);
		bodyBuffer.append("\n</table>");
		return bodyBuffer.toString();
	}
	
	public static String doAppendHtmlTableRow(StringBuffer tds){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("\n\t<tr>");
		bodyBuffer.append(tds.toString());
		bodyBuffer.append("\t</tr>\n");
		return bodyBuffer.toString();
	}
	
	public static String doAppendHtmlTableData(int colspan, String actualtableData){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("\n\t\t<td colspan='" + colspan + "'>");
		bodyBuffer.append(actualtableData);
		bodyBuffer.append("</td>");
		return bodyBuffer.toString();
	}
	
	public static String doAppendHtmlSelect(String name,List<String> options){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("<select name='" + name + "'>\n");
		for(String option: options){
			bodyBuffer.append("<option value='"+option+"'>"+option+"</option>\n");
		}
		bodyBuffer.append("</select>\n");
		return bodyBuffer.toString();
	}
	
	public static String doAppendHtmlHyperLink(String URL,String textToDisplay){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("<a href='" + URL + "'>" +  textToDisplay);
		bodyBuffer.append("</a>\n");
		return bodyBuffer.toString();
	}
	
	public static StringBuffer displayErrorPage(Exception e){
		StringBuffer htmlPageBuffer = new StringBuffer();
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append(doAppendImage("resources/Web-under-construction.jpeg", "middle", "600", "800", "Webpage under contruction"));
		bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Actual Exception:" ));
		bodyBuffer.append("<br>");
		StackTraceElement[] stackTraceElements = e.getStackTrace();
		for(StackTraceElement ste: stackTraceElements){
			bodyBuffer.append("\t" + ste.getClassName() + "." + ste.getMethodName() + " [Line:"  + ste.getLineNumber()+"]<br>");
		}
		htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Internal Server Error!", bodyBuffer));
		htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
		return bodyBuffer;
	}

}
