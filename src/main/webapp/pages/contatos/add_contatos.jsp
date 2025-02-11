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
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Cadastro de contato</h4>
                  <p class="card-category">Preencha seus dados</p>
                </div>
                <div class="card-body">
                	<c:if test="${sucess != null}">
                		<div class="alert alert-success">
                    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      		<i class="material-icons">close</i>
                    		</button>
                    		<span>
                      		<b> Sucesso! - </b> Cadastro efetuado com sucesso!</span>
                  		</div>
					</c:if>
                  <form action="${pageContext.request.contextPath}/salvar" method="post">
                    <div class="row">
                      
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Nome</label>
                          <input type="text" name="name" class="form-control" maxlength="30" required="required">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Email</label>
                          <input type="email" name="email" class="form-control" maxlength="50" required="required">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Fone</label>
                          <input type="text" name="phone" class="form-control" maxlength="50" required="required">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Senha</label>
                          <input type="password" name="password" class="form-control" maxlength="50" required="required">
                        </div>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        </jsp:attribute>
</mt:admin_template>