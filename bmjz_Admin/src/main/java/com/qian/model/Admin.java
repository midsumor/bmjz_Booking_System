package com.qian.model;


public class Admin {

  private long adminId;
  private String account;
  private String password;
  private String permission;


  @Override
  public String toString() {
    return "Admin{" +
            "adminId=" + adminId +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", permission='" + permission + '\'' +
            '}';
  }

  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

}
