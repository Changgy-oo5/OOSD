<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tìm kiếm sinh viên</title>
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
      border-color: #667eea;
    }
    button {
      padding: 15px 30px;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
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
      background: #e7f3ff;
      padding: 15px;
      border-radius: 10px;
      margin-top: 20px;
      text-align: left;
    }
    .info p {
      margin: 5px 0;
      color: #004085;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>🔍 TÌM KIẾM SINH VIÊN</h2>
  <div class="subtitle">Nhập CMND hoặc họ tên để tìm kiếm</div>

  <form action="${pageContext.request.contextPath}/search/basic" method="post">
    <div class="search-box">
      <input type="text" name="keyword" placeholder="Nhập CMND hoặc họ tên..." required />
      <button type="submit">Tìm kiếm</button>
    </div>
  </form>

  <button class="btn-back" onclick="window.location.href='${pageContext.request.contextPath}/'">🏠 Về trang chủ</button>

  <div class="info">
    <p>💡 <strong>Gợi ý:</strong></p>
    <p>- Tìm kiếm theo CMND: 0123456789</p>
    <p>- Tìm kiếm theo tên: Nguyễn Văn A</p>
    <p>- Để trống để xem tất cả sinh viên</p>
  </div>
</div>
</body>
</html>