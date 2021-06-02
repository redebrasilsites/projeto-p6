<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	<jsp:attribute name="content">
	<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-info">
                  <h4 class="card-title ">Lista de clientes</h4>
                  <p class="card-category">Aqui está a lista de clientes cadastrados</p>
                </div>
                <div class="card-body">
<div class="table-responsive">
				<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Phone</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="client" items="${clients}">
							<tr>
								<td><c:out value="${client.id}" /></td>
								<td><c:out value="${client.name}" /></td>
								<td><c:out value="${client.email}" /></td>
								<td><c:out value="${client.phone}" /></td>
								<td>
								<form action="editar" method="post">
									<input type="hidden" name="email" value="${client.email}" />
									<input type="submit" class="btn btn-primary btn-sm" value="Alterar" />
								</form>
								</td>
								<td>
								<form action="excluir" method="post">
									<input type="hidden" name="id" value="${client.id}" />
									<input type="submit" class="btn btn-danger btn-sm" value="Excluir" />
								</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
                </div>
              </div>
            </div>
          </div>
        </div>
	</jsp:attribute>
</mt:admin_template>