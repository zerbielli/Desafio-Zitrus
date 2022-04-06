<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <jsp:include page="header.jsp"></jsp:include>

      <h3>Lista de autorizações</h3>
      <br>
      <table class="table table-striped">
        <thead>
          <tr>
            <th><b>Procedimento</b></th>
            <th><b>Idade</b></th>
            <th><b>Sexo</b></th>
            <th><b>Situação</b></th>
            <th><b>Ações</b></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listAutorizacoes}" var="aut">
            <tr>
              <td>
                <c:out value="${aut.procedimento.nome}"></c:out>
              </td>
              <td>
                <c:out value="${aut.idade}"></c:out>
              </td>

              <td>
                <c:out value="${aut.sexo.descricao}"></c:out>
              </td>

              <td>
                <c:out value="${aut.situacao.descricao}"></c:out>
              </td>

              <td>
                <div class="btn-group " role="group">
                  <a href="/${aut.id}/edit" class="btn btn-info btn-sm">Editar</a>
                  <a href="/${aut.id}/cancel" class="btn btn-warning btn-sm">Cancelar</a>
                  <a href="/${aut.id}/delete" class="btn btn-danger btn-sm">Excluir</a>
                </div>
              </td>
            </tr>

          </c:forEach>
        </tbody>
      </table>
      </div>

      <jsp:include page="footer.jsp"></jsp:include>