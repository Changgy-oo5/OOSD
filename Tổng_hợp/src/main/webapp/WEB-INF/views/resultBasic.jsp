<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Kết quả tìm kiếm sinh viên</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      padding: 20px;
    }
    .container {
      max-width: 1200px;
      margin: 0 auto;
      background: white;
      border-radius: 15px;
      padding: 30px;
      box-shadow: 0 20px 60px rgba(0,0,0,0.3);
    }
    h2 {
      color: #333;
      margin-bottom: 10px;
    }
    .subtitle {
      color: #666;
      margin-bottom: 20px;
      padding-bottom: 15px;
      border-bottom: 2px solid #f0f0f0;
    }
    .result-count {
      background: #e7f3ff;
      padding: 10px 15px;
      border-radius: 8px;
      margin-bottom: 20px;
      display: inline-block;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      padding: 12px;
      text-align: left;
    }
    td {
      padding: 12px;
      border-bottom: 1px solid #eee;
    }
    tr:hover {
      background: #f5f5f5;
    }
    .no-data {
      text-align: center;
      padding: 40px;
      color: #999;
    }
    .btn-group {
      margin-top: 20px;
      display: flex;
      gap: 10px;
    }
    button {
      padding: 10px 20px;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      border: none;
      border-radius: 8px;
      cursor: pointer;
    }
    .btn-back {
      background: #6c757d;
    }
    .badge {
      background: #28a745;
      color: white;
      padding: 3px 8px;
      border-radius: 5px;
      font-size: 12px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>📋 KẾT QUẢ TÌM KIẾM</h2>
  <div class="subtitle">Từ khóa: <strong>${keyword}</strong></div>

  <div class="result-count">
    📊 Tìm thấy <strong>${students.size()}</strong> sinh viên
  </div>

  <c:choose>
    <c:when test="${empty students}">
      <div class="no-data">
        ⚠️ Không tìm thấy sinh viên nào phù hợp với từ khóa "${keyword}"
      </div>
    </c:when>
    <c:otherwise>
      <table>
        <thead>
        <tr>
          <th>STT</th>
          <th>Số CMND</th>
          <th>Họ và tên</th>
          <th>Email</th>
          <th>Số điện thoại</th>
          <th>Địa chỉ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sv" items="${students}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td><span class="badge">${sv.soCMND}</span></td>
            <td><strong>${sv.hoTen}</strong></td>
            <td>${not empty sv.email ? sv.email : '-'}</td>
            <td>${not empty sv.soDT ? sv.soDT : '-'}</td>
            <td>${not empty sv.diaChi ? sv.diaChi : '-'}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:otherwise>
  </c:choose>

  <div class="btn-group">
    <button onclick="window.history.back()">🔍 Tìm kiếm lại</button>
    <button class="btn-back" onclick="window.location.href='${pageContext.request.contextPath}/'">🏠 Về trang chủ</button>
  </div>
</div>
</body>
</html>