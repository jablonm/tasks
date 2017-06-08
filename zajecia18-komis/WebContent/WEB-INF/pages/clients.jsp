<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h2>Lista klientów</h2>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by', 'name','sortClientForm')">Imię</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=secondName'">Nazwisko</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=address'">Adres</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=tel'">Telefon</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=city'">Miasto</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${clients}">
				<tr>
					<td>${client.name}</td>
					<%-- client=var --%>
					<td>${client.secondName}</td>
					<td>${client.address}</td>
					<td>${client.tel}</td>
					<td>${client.city}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="DealerServlet" method="post" id="sortClientForm">
		<input type="hidden" name="domain" value="client" /> <input type="hidden" name="action" value="sort" /> <input type="hidden"
			name="orderBy" id="client_sort_by" value="id" />
	</form>
</div>