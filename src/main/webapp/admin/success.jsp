<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	<jsp:attribute name="content">
	<div class="container-fluid">
         <div class="alert alert-success">
                    <button type="button" class="close"
					data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>
                      <b> SUCESSO! - </b> Operação realizada com sucesso!</span>
                  </div> 	
    </div>
        </jsp:attribute>
</mt:admin_template>