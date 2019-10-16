package com.maplegroup.maplehotel.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Journal {
    private int journalId;//日志id
    private String journalUserName;//操作员
    private String journalOperate;//操作内容
    private String journalTime;//日志时间
    private String journalRemark;//备注
    private int journalDel;//删除标记
    private String journalRE;//预留
    private User user;
    public Journal(int journalId) {
        this.journalId = journalId;

    }
}