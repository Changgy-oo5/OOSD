<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Đăng ký thông tin tốt nghiệp</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      padding: 20px;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      background: white;
      border-radius: 15px;
      padding: 30px;
      box-shadow: 0 20px 60px rgba(0,0,0,0.3);
    }
    h2 {
      color: #333;
      margin-bottom: 10px;
      text-align: center;
    }
    .subtitle {
      text-align: center;
      color: #666;
      margin-bottom: 30px;
      padding-bottom: 20px;
      border-bottom: 2px solid #f0f0f0;
    }
    .form-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #333;
    }
    .required:after {
      content: " *";
      color: red;
    }
    input, select {
      width: 100%;
      padding: 12px;
      border: 1px solid #ddd;
      border-radius: 8px;
      font-size: 14px;
      transition: border-color 0.3s;
    }
    input:focus, select:focus {
      outline: none;
      border-color: #667eea;
    }
    .error {
      color: red;
      font-size: 12px;
      margin-top: 5px;
      display: block;
    }
    .error-message {
      background: #fee;
      border-left: 4px solid red;
      padding: 10px;
      margin-bottom: 20px;
      border-radius: 5px;
    }
    .success-message {
      background: #d4edda;
      border-left: 4px solid #28a745;
      padding: 10px;
      margin-bottom: 20px;
      border-radius: 5px;
      color: #155724;
    }
    .row {
      display: flex;
      gap: 20px;
    }
    .row .form-group {
      flex: 1;
    }
    button {
      width: 100%;
      padding: 14px;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: transform 0.3s;
    }
    button:hover {
      transform: translateY(-2px);
    }
    .btn-back {
      background: #6c757d;
      margin-top: 10px;
    }
    .btn-back:hover {
      background: #5a6268;
    }
    hr {
      margin: 20px 0;
      border: none;
      border-top: 2px solid #f0f0f0;
    }
    h3 {
      color: #667eea;
      margin: 20px 0 15px 0;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>📋 ĐĂNG KÝ THÔNG TIN TỐT NGHIỆP</h2>
  <div class="subtitle">Vui lòng nhập đầy đủ thông tin bên dưới</div>

  <c:if test="${param.success != null}">
    <div class="success-message">✅ Đăng ký thành công!</div>
  </c:if>

  <form:form modelAttribute="studentDTO" method="post" acceptCharset="UTF-8">
    <h3>📌 Thông tin sinh viên</h3>

    <div class="row">
      <div class="form-group">
        <label class="required">Số CMND/CCCD</label>
        <form:input path="soCMND" placeholder="Nhập số CMND" />
        <form:errors path="soCMND" cssClass="error" />
      </div>
      <div class="form-group">
        <label>Họ và tên</label>
        <form:input path="hoTen" placeholder="Nhập họ tên" />
        <form:errors path="hoTen" cssClass="error" />
      </div>
    </div>

    <div class="row">
      <div class="form-group">
        <label>Email</label>
        <form:input path="email" type="email" placeholder="example@mail.com" />
      </div>
      <div class="form-group">
        <label>Số điện thoại</label>
        <form:input path="soDT" placeholder="Nhập số điện thoại" />
      </div>
    </div>

    <div class="form-group">
      <label>Địa chỉ</label>
      <form:input path="diaChi" placeholder="Nhập địa chỉ" />
    </div>

    <hr>

    <h3>🎓 Thông tin tốt nghiệp</h3>

    <div class="row">
      <div class="form-group">
        <label class="required">Trường tốt nghiệp</label>
        <form:select path="maTruong">
          <form:option value="">-- Chọn trường --</form:option>
          <form:options items="${truongList}" itemValue="maTruong" itemLabel="tenTruong" />
        </form:select>
        <form:errors path="maTruong" cssClass="error" />
      </div>
      <div class="form-group">
        <label class="required">Ngành tốt nghiệp</label>
        <form:select path="maNganh">
          <form:option value="">-- Chọn ngành --</form:option>
          <form:options items="${nganhList}" itemValue="maNganh" itemLabel="tenNganh" />
        </form:select>
        <form:errors path="maNganh" cssClass="error" />
      </div>
    </div>

    <div class="row">
      <div class="form-group">
        <label>Hệ tốt nghiệp</label>
        <form:select path="heTN">
          <form:option value="">-- Chọn hệ --</form:option>
          <form:option value="Chính quy">Chính quy</form:option>
          <form:option value="Tại chức">Tại chức</form:option>
          <form:option value="Từ xa">Từ xa</form:option>
          <form:option value="Liên thông">Liên thông</form:option>
        </form:select>
      </div>
      <div class="form-group">
        <label class="required">Ngày tốt nghiệp</label>
        <form:input path="ngayTN" type="date" />
        <form:errors path="ngayTN" cssClass="error" />
      </div>
    </div>

    <div class="form-group">
      <label>Loại tốt nghiệp</label>
      <form:select path="loaiTN">
        <form:option value="">-- Chọn loại --</form:option>
        <form:option value="Xuất sắc">Xuất sắc</form:option>
        <form:option value="Giỏi">Giỏi</form:option>
        <form:option value="Khá">Khá</form:option>
        <form:option value="Trung bình">Trung bình</form:option>
        <form:option value="Yếu">Yếu</form:option>
      </form:select>
    </div>

    <button type="submit">💾 LƯU THÔNG TIN</button>
    <button type="button" class="btn-back" onclick="window.location.href='${pageContext.request.contextPath}/'">🏠 Về trang chủ</button>
  </form:form>
</div>
</body>
</html>