package dk.johannes.loginapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @Column
    private Date createDate;
}
