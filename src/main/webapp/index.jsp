<%@page import="com.cg.service.BookService"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.model.Book"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<body>
<h2>Library Form</h2>
<form action="home">
Library Id :<br>
<input type= "text" name ="libraryId"> <br> <br>
Library Name: <br>
<input type= "text" name ="libraryName"> <br> <br>
Book Name : <br>
<input type ="text" name= "bookName"><br> <br>
Book Id: <br>
 <input type ="text" name="bookId"><br> <br>
Publisher :<br>
<input type="text" name="publisher"><br> <br>
Author: <br>
<input type="text" name="author"><br><br>
<input type ="submit"> 
<br> 
</form>
<form action="find" name="get">
Find by id: <br>
<input type="text" name="bookId"> <br> <br>
<input type ="submit"> 
</form>
<table border="2">
<tr>
<th> Library Id </th>
<th> Library Name </th>
<th> Book Name </th>
<th> Book Id </th>
<th> Publisher </th>
<th> Author </th>
</tr>
</table>
<% BookService bookService = new BookService();
List<Book> books = bookService.getAllBooks(); 
%>
			<% 
				for (Book b : books) { 
			%> 
			<tr> 
				<td><%=b.getLibrary().getLibraryId()%></td> 
				<td><%=b.getLibrary().getLibraryName()%></td> 
				<td><%=b.getBookName()%></td> 
				<td><%=b.getBookId()%></td> 
				<td><%=b.getPublisher()%></td> 
				<td><%=b.getAuthor()%></td>
				</tr>

				<% 
				} 
			%> 
</body>
</html>
 