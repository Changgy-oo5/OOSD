package com.quanly.dao;

import com.quanly.model.Truong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TruongDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Truong> getAllTruong() {
        String sql = "SELECT * FROM TRUONG";
        return jdbcTemplate.query(sql, new TruongRowMapper());
    }

    public Truong getTruongById(String maTruong) {
        String sql = "SELECT * FROM TRUONG WHERE MaTruong = ?";
        return jdbcTemplate.queryForObject(sql, new TruongRowMapper(), maTruong);
    }

    private static class TruongRowMapper implements RowMapper<Truong> {
        @Override
        public Truong mapRow(ResultSet rs, int rowNum) throws SQLException {
            Truong truong = new Truong();
            truong.setMaTruong(rs.getString("MaTruong"));
            truong.setTenTruong(rs.getString("TenTruong"));
            truong.setDiaChi(rs.getString("DiaChi"));
            truong.setSoDT(rs.getString("SoDT"));
            return truong;
        }
    }
}