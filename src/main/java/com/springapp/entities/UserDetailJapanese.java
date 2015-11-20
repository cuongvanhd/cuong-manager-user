package com.springapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cuong on 2015/11/18.
 */
@Entity
@Table(name = "tbl_detail_user_japan")
public class UserDetailJapanese implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_user_japan_id")
    private int detailUserJapanId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_level")
    private Japanese japanese;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "total")
    private int total;

    public UserDetailJapanese() {
    }

    public UserDetailJapanese(User user, Japanese japanese, Date startDate, Date endDate, int total) {
        this.user = user;
        this.japanese = japanese;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
    }

    public int getDetailUserJapanId() {
        return detailUserJapanId;
    }

    public void setDetailUserJapanId(int detailUserJapanId) {
        this.detailUserJapanId = detailUserJapanId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Japanese getJapanese() {
        return japanese;
    }

    public void setJapanese(Japanese japanese) {
        this.japanese = japanese;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
