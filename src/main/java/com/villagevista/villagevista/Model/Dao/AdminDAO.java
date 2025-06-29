package com.villagevista.villagevista.Model.Dao;

import com.villagevista.villagevista.Model.Mo.Admin;

import java.util.List;

public interface AdminDAO {
    public Admin create(
                Long adminId,
                String username,
                String password,
                String nome,
                String cf_admin,
                String cognome);

    public void update (Admin admin);

    public void delete (Admin admin);

    public Admin findLoggedAdmin();

    public Admin findByAdminId(Long adminId);
    public Admin findByUsername(String username);
    public Admin validate(String username, String Password);

    public List<Admin> findAllAdmins();

}
