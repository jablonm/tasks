<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h2>Lista klientów</h2>
	<button type="button" data-toggle="collapse" class="btn btn-info btn-sm" data-target="#add_client">Nowy klient</button>
	<button type="button" data-toggle="collapse" class="btn btn-info btn-sm" data-target="#search_client">Wyszukaj</button>
	<div id="add_client" class="collapse">
		<form action="DealerServlet" method="post" class="form-horizontal">
			<input type="hidden" name="action" value="add" /> <input type="hidden" name="domain" value="clients" />
			
			
			<div class="form-group<c:if test="${newClientValidationErrors['name']!=null}"> has-error </c:if>">
				<label class="control-label col-sm-2" for="name">Imie:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" />
					<c:if test="${newClientValidationErrors['name']!=null}"> ${newClientValidationErrors['name'].message} </c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="secondname">Nazwisko:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="secondname" name="secondname" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Adres:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="address" id="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="tel">Telefon:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="tel" id="tel" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="city">Miasto:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="city" id="city" />
				</div>
			</div>
			<button type="submit" class="btn btn-success btn-sm">Zapisz</button>
		</form>
		<c:if test="${onError!=null}">
			<div class="panel panel-danger">
				<div class="panel-heading">Podano nieprawidłowe wartości.</div>
				<div class="panel-body">${onError}</div>
			</div>
		</c:if>
	</div>
	<div id="search_client" class="collapse">
		<form action="DealerServlet" method="post" class="form-horizontal">
			<input type="hidden" name="action" value="search" /> <input type="hidden" name="domain" value="clients" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Imie:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="secondname">Nazwisko:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="secondname" name="secondname" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Adres:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="address" id="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="tel">Telefon:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="tel" id="tel" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="city">Miasto:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="city" id="city" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-sm">Filtruj</button>
		</form>
		<form action="DealerServlet" method="post">
			<input type="hidden" name="domain" value="clients" /> <input type="hidden" name="action" value="reset" />
			<button type="submit" class="btn btn-warning btn-sm">Reset</button>
		</form>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by','name','sortClientForm')">Imię</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by','secondname','sortClientForm')">Nazwisko</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by','address','sortClientForm')">Adres</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by','tel','sortClientForm')">Telefon</th>
				<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="changeFieldValue('client_sort_by','city','sortClientForm')">Miasto</th>
				<th>Akcje</th>
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
					<td>
						<form action="DealerServlet" method="post">
							<!-- <form action="action_client" method="post"> -->
							<input type="hidden" name="id" value="${client.id}" /> <input type="hidden" name="action" value="delete" /> <input type="hidden"
								name="domain" value="clients" />
							<button type="submit" class="btn btn-danger btn-sm">Usun</button>
							<button type="button" data-toggle="modal" data-target="#edit_client_${client.id}" class="btn btn-primary btn-sm">Edytuj</button>
						</form>
						<div id="edit_client_${client.id}" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class="modal-body">
										<form action="DealerServlet" method="post">
											<input type="hidden" name="id" value="${client.id}" /> <input type="hidden" name="action" value="edit" />
											<div class="form-group">
												<label for="name_edit">Imie:</label> <input type="text" class="form-control" id="name_edit" name="name" value="${client.name}" />
											</div>
											<div class="form-group">
												<label for="secondname_edit">Nazwisko:</label> <input type="text" class="form-control" id="secondname_edit" name="secondname"
													value="${client.secondName}" />
											</div>
											<div class="form-group">
												<label for="address_edit">Adres:</label> <input class="form-control" type="text" name="address" id="address_edit"
													value="${client.address}" />
											</div>
											<div class="form-group">
												<label for="tel_edit">Telefon:</label> <input class="form-control" type="text" name="tel" id="tel_edit" value="${client.tel}" />
											</div>
											<div class="form-group">
												<label for="city_edit">Miasto:</label> <input class="form-control" type="text" name="city" id="city_edit" value="${client.city}" />
											</div>
											<input type="hidden" name="domain" value="clients" />
											<button type="submit" class="btn btn-default btn-sm">Zapisz</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="DealerServlet" method="post" id="sortClientForm">
		<input type="hidden" name="domain" value="clients" /> <input type="hidden" name="action" value="sort" /> <input type="hidden"
			name="orderBy" id="client_sort_by" value="id" />
	</form>
</div>