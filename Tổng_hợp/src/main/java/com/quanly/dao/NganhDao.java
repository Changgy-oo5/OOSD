package com.quanly.dao;

import com.quanly.model.Nganh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NganhDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Nganh> getAllNganh() {
        String sql = "SELECT * FROM NGANH";
        return jdbcTemplate.query(sql, new NganhRowMapper());
    }

    public Nganh getNganhById(String maNganh) {
        String sql = "SELECT * FROM NGANH WHERE MaNganh = ?";
        return jdbcTemplate.queryForObject(sql, new NganhRowMapper(), maNganh);
    }

    private static class NganhRowMapper implements RowMapper<Nganh> {
        @Override
        public Nganh mapRow(ResultSet rs, int rowNum) throws SQLException {
            Nganh nganh = new Nganh();
            nganh.setMaNganh(rs.getString("MaNganh"));
            nganh.setTenNganh(rs.getString("TenNganh"));
            nganh.setLoaiNganh(rs.getString("LoaiNganh"));
            return nganh;
        }
    }
}