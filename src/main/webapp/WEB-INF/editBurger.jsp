<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Edit your Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
    <!-- FONTS -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Climate+Crisis&family=Sen:wght@400;700&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="row d-flex mb-3">
      <img src="/img/hamburger.png" class="col" />
      <h1 class="col-11 mt-2">Burger Tracker</h1>
    </div>
    <div class="card p-3">
      <h2>Edit your burger</h2>
      <hr class="mb-3">
      <form:form action="/burgers/${thisBurger.id}/edit" method="POST" modelAttribute="thisBurger">
        <input type="hidden" name="_method" value="PUT" />
        <div class="mb-3">
              <form:label path="burgerName" class="form-label"
              >Burger Name:</form:label
              >
              <em><form:errors path="burgerName" ></form:errors></em>
          <form:input type="text" class="form-control" path="burgerName" />
        </div>
        <div class="mb-3">
          <form:label path="restaurantName" class="form-label"
            >Restaurant Name:</form:label
          >
          <em><form:errors path="restaurantName" ></form:errors></em>
          <form:input type="text" class="form-control" path="restaurantName" />
        </div>
        <div class="mb-3">
          <form:label path="rating" class="form-label">Rating:</form:label>
          <em><form:errors path="rating" ></form:errors></em>
          <form:input type="number" class="form-control" path="rating" min="0" max="5" />
        </div>
        <div class="mb-3">
            <form:label path="notes" class="form-label">Notes:</form:label>
            <em><form:errors path="notes" ></form:errors></em>
          <form:textarea
            class="form-control"
            placeholder="Leave a comment here"
            path="notes"
           />
        </div>
        <button class="btn">Update Burger</button>
      </form:form>
    </div>
    <div class="mt-3 d-flex justify-content-between"> 
      <div>
        Icons made by 
        <a href="https://www.flaticon.com/authors/freepik" title="Freepik"> Freepik </a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com'</a>
      </div>
      <div>
        <a class="btn px-4" href="/" role="button">Return to home</a>
      </div>
    </div>
  </body>
</html>
