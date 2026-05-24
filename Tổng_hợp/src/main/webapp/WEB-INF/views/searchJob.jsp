<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tra cứu việc làm sinh viên</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      padding: 20px;
    }
    .container {
      max-width: 600px;
      margin: 50px auto;
      background: white;
      border-radius: 15px;
      padding: 40px;
      box-shadow: 0 20px 60px rgba(0,0,0,0.3);
      text-align: center;
    }
    h2 {
      color: #333;
      margin-bottom: 10px;
    }
    .subtitle {
      color: #666;
      margin-bottom: 30px;
    }
    .search-box {
      display: flex;
      gap: 10px;
      margin-bottom: 20px;
    }
    input[type="text"] {
      flex: 1;
      padding: 15px;
      border: 2px solid #ddd;
      border-radius: 10px;
      font-size: 16px;
    }
    input[type="text"]:focus {
      outline: none;
      border-color: #f5576c;
    }
    button {
      padding: 15px 30px;
      background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
      color: white;
      border: none;
      border-radius: 10px;
      font-size: 16px;
      cursor: pointer;
    }
    button:hover {
      transform: translateY(-2px);
      box-shadow: 0 5px 15px rgba(0,0,0,0.2);
    }
    .btn-back {
      background: #6c757d;
      margin-top: 10px;
    }
    .info {
      background: #fff3cd;
      padding: 15px;
      border-radius: 10px;
      margin-top: 20px;
      text-align: left;
    }
    .info p {
      margin: 5px 0;
      color: #856404;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>💼 TRA CỨU VIỆC LÀM SINH VIÊN</h2>
  <div class="subtitle">Tra cứu thông tin tốt nghiệp và công việc hiện tại</div>

  <form action="${pageContext.request.contextPath}/search/job" method="post">
    <div class="search-box">
      <input type="text" name="keyword" placeholder="Nhập CMND hoặc họ tên sinh viên..." required />
      <button type="submit">Tra cứu</button>
    </div>
  </form>

  <button class="btn-back" onclick="window.location.href='${pageContext.request.contextPath}/'">🏠 Về trang chủ</button>

  <div class="info">
    <p>📌 <strong>Thông tin hiển thị bao gồm:</strong></p>
    <p>- Thông tin cá nhân sinh viên</p>
    <p>- Ngành và trường đã tốt nghiệp</p>
    <p>- Công việc hiện tại (tên công ty, ngành nghề, thời gian làm việc)</p>
    <p>💡 <em>Hệ thống giúp thống kê việc làm sinh viên sau tốt nghiệp</em></p>
  </div>
</div>
</body>
</html>