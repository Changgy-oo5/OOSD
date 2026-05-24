<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Kết quả tra cứu việc làm</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      padding: 20px;
    }
    .container {
      max-width: 1300px;
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
      overflow-x: auto;
      display: block;
    }
    th {
      background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
      color: white;
      padding: 12px;
      text-align: left;
      font-size: 14px;
    }
    td {
      padding: 12px;
      border-bottom: 1px solid #eee;
      font-size: 13px;
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
      background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
      color: white;
      border: none;
      border-radius: 8px;
      cursor: pointer;
    }
    .btn-back {
      background: #6c757d;
    }
    .badge-cmnd {
      background: #17a2b8;
      color: white;
      padding: 3px 8px;
      border-radius: 5px;
      font-size: 12px;
      font-weight: bold;
    }
    .job-badge {
      background: #28a745;
      color: white;
      padding: 3px 8px;
      border-radius: 5px;
      font-size: 11px;
    }
    .warning {
      background: #ffc107;
      color: #333;
      padding: 3px 8px;
      border-radius: 5px;
      font-size: 11px;
    }
    th {
      position: sticky;
      top: 0;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>💼 KẾT QUẢ TRA CỨU VIỆC LÀM</h2>
  <div class="subtitle">Từ khóa: <strong>${keyword}</strong></div>

  <div class="result-count">
    📊 Tìm thấy <strong>${jobInfoList.size()}</strong> kết quả
  </div>

  <c:choose>
    <c:when test="${empty jobInfoList}">
      <div class="no-data">
        ⚠️ Không tìm thấy sinh viên nào với từ khóa "${keyword}"
      </div>
    </c:when>
    <c:otherwise>
      <table>
        <thead>
        <tr>
          <th>STT</th>
          <th>Số CMND</th>
          <th>Họ tên</th>
          <th>Mã ngành TN</th>
          <th>Mã trường TN</th>
          <th>Mã ngành CT</th>
          <th>Tên công ty</th>
          <th>Thời gian LV</th>
          <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="info" items="${jobInfoList}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td><span class="badge-cmnd">${info.soCMND}</span></td>
            <td><strong>${info.hoTen}</strong></td>
            <td><span class="job-badge">${info.maNganhTotNghiep}</span></td>
            <td><span class="job-badge">${info.maTruong}</span></td>
            <td>
              <c:choose>
                <c:when test="${empty info.maNganhCongTy}">
                  <span class="warning">🔍 Chưa có việc</span>
                </c:when>
                <c:otherwise>
                  ${info.maNganhCongTy}
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <c:choose>
                <c:when test="${empty info.tenCongTy}">
                  <span class="warning">Chưa có việc làm</span>
                </c:when>
                <c:otherwise>
                  <strong>${info.tenCongTy}</strong>
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <c:choose>
                <c:when test="${info.thoiGianLamViec > 0}">
                  ${info.thoiGianLamViec} tháng
                </c:when>
                <c:otherwise>
                  -
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <c:choose>
                <c:when test="${not empty info.maNganhCongTy}">
                  ✅ Đang làm việc
                </c:when>
                <c:otherwise>
                  ⏳ Chưa có việc
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:otherwise>
  </c:choose>

  <div class="btn-group">
    <button onclick="window.history.back()">🔍 Tra cứu lại</button>
    <button class="btn-back" onclick="window.location.href='${pageContext.request.contextPath}/'">🏠 Về trang chủ</button>
  </div>
</div>
</body>
</html>