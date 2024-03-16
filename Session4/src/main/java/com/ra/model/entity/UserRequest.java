package com.ra.model.entity;
import com.ra.util.annotation.Column;
import com.ra.util.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

public class UserRequest {
    private String id = UUID.randomUUID().toString();
    @NotEmpty(message = "Email không được bỏ trống!")
    @Email(message = "Email sai định dạng!")
    private String email;
    @NotEmpty(message = "Mật khẩu không được bỏ trống!")
    private String password;
    @NotEmpty(message = "Số điện thoại không được bỏ trống!")
    private String phone;
    private MultipartFile image;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created = new Date();
    private boolean status = true;

    public UserRequest() {
    }

    public UserRequest(String id, String email, String password, String phone, MultipartFile image, String avatar, Date birthday, String address, Date created, boolean status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
        this.avatar = avatar;
        this.birthday = birthday;
        this.address = address;
        this.created = created;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}