package com.qhit.baseCompany.pojo;


/** 
* Created by GeneratorCode on 2019/03/30
*/ 

public class BaseCompany { 
    private Integer compid;    //主键 
    private String compname;    //公司名称 
    private String contacts;    //联系人 
    private String comptel;    //联系电话 
    private String industry;    //行业 
    private String address;    //地址 

    public Integer getCompid() { 
        return compid;
    }

    public void setCompid(Integer compid) { 
        this.compid = compid;
    } 

    public String getCompname() { 
        return compname;
    }

    public void setCompname(String compname) { 
        this.compname = compname;
    }
    public String getContacts() { 
        return contacts;
    }

    public void setContacts(String contacts) { 
        this.contacts = contacts;
    }
    public String getComptel() { 
        return comptel;
    }

    public void setComptel(String comptel) { 
        this.comptel = comptel;
    }
    public String getIndustry() { 
        return industry;
    }

    public void setIndustry(String industry) { 
        this.industry = industry;
    }
    public String getAddress() { 
        return address;
    }

    public void setAddress(String address) { 
        this.address = address;
    }

 }