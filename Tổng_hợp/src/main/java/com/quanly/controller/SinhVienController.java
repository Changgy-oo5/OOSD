package com.quanly.controller;

import com.quanly.dao.NganhDao;
import com.quanly.dao.SinhVienDao;
import com.quanly.dao.TruongDao;
import com.quanly.dto.StudentGraduationDTO;
import com.quanly.model.SinhVien;
import com.quanly.model.TotNghiep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class SinhVienController {

    private final SinhVienDao sinhVienDAO;
    private final TruongDao truongDAO;
    private final NganhDao nganhDAO;

    @Autowired
    public SinhVienController(SinhVienDao sinhVienDAO, TruongDao truongDAO, NganhDao nganhDAO) {
        this.sinhVienDAO = sinhVienDAO;
        this.truongDAO = truongDAO;
        this.nganhDAO = nganhDAO;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/insert")
    public String showInsertForm(Model model) {
        model.addAttribute("studentDTO", new StudentGraduationDTO());
        model.addAttribute("truongList", truongDAO.getAllTruong());
        model.addAttribute("nganhList", nganhDAO.getAllNganh());
        return "insertForm";
    }

    @PostMapping("/insert")
    public String insertStudent(@Valid @ModelAttribute("studentDTO") StudentGraduationDTO dto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("truongList", truongDAO.getAllTruong());
            model.addAttribute("nganhList", nganhDAO.getAllNganh());
            return "insertForm";
        }

        if (!sinhVienDAO.existsBySoCMND(dto.getSoCMND())) {
            SinhVien sv = new SinhVien();
            sv.setSoCMND(dto.getSoCMND());
            sv.setHoTen(dto.getHoTen());
            sv.setEmail(dto.getEmail());
            sv.setSoDT(dto.getSoDT());
            sv.setDiaChi(dto.getDiaChi());
            sinhVienDAO.saveSinhVien(sv);
        }

        TotNghiep tn = new TotNghiep();
        tn.setSoCMND(dto.getSoCMND());
        tn.setMaTruong(dto.getMaTruong());
        tn.setMaNganh(dto.getMaNganh());
        tn.setHeTN(dto.getHeTN());
        tn.setNgayTN(dto.getNgayTN());
        tn.setLoaiTN(dto.getLoaiTN());
        sinhVienDAO.saveTotNghiep(tn);

        return "redirect:/insert?success";
    }

    @GetMapping("/search/basic")
    public String searchBasicForm() {
        return "searchBasic";
    }

    @PostMapping("/search/basic")
    public String searchBasic(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("students", sinhVienDAO.searchSinhVien(keyword));
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "resultBasic";
    }

    @GetMapping("/search/job")
    public String searchJobForm() {
        return "searchJob";
    }

    @PostMapping("/search/job")
    public String searchJob(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("jobInfoList", sinhVienDAO.searchGraduationJobInfo(keyword));
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "resultJob";
    }
}