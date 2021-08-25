package com.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author idea
 * @create 2021-01-21-19:16
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId("id")
    private int id;
    @TableField("name")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    @TableField("password")
    private String password;
}
