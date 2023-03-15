package com.poly.hangnt169.B4_CRUDListFixCung.service;

import com.poly.hangnt169.B4_CRUDListFixCung.entity.SinhVien;

import java.util.List;

/**
 * @author hangnt169
 */
public interface SinhVienService {

    List<SinhVien>fakeData();

    void removeStudent(List<SinhVien>lists, int index);

    SinhVien getOne(List<SinhVien>lists,int index);

}
