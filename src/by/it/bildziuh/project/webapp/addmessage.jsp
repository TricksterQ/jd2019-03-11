<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Write message</legend>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="message">Message</label>
  <div class="col-md-4">
    <textarea class="form-control" id="message" name="message"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sendmessage"></label>
  <div class="col-md-4">
    <button id="sendmessage" name="sendmessage" class="btn btn-primary">Send message</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>



