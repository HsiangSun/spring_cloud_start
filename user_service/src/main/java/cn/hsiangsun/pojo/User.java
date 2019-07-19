package cn.hsiangsun.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true) //主键回填
    private Integer id;

    private String username;
    private String password;
    private Date birthday;

}

