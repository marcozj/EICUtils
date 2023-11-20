package com.saviynt.custom.eicutils;

import org.json.JSONObject;

public class SAVUser {
    private String username;
    private String firstname;
    private String lastname;
    private String middlename;
    private String displayname;
    private String statuskey;
    private String manager;
    private String departmentname;
    private String employeeType;
    private String jobdescription;
    private String jobcodedesc;
    private String email;
    private String passwordExpired;
    private String enabled;
    private String accountExpired;
    private String password;
    private String SAVRoles;
    private String UserGroups;

    public SAVUser() {
        this.statuskey = "1";
        this.passwordExpired = "false";
        this.enabled = "true";
        this.accountExpired = "false";
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        if (username != null && !username.trim().isEmpty()) {
            json.put("username", username);
        }
        if (firstname != null && !firstname.trim().isEmpty()) {
            json.put("firstname", firstname);
        }
        if (lastname != null && !lastname.trim().isEmpty()) {
            json.put("lastname", lastname);
        }
        if (middlename != null && !middlename.trim().isEmpty()) {
            json.put("middlename", middlename);
        }
        if (displayname != null && !displayname.trim().isEmpty()) {
            json.put("displayname", displayname);
        }
        if (statuskey != null && !statuskey.trim().isEmpty()) {
            json.put("statuskey", statuskey);
        }
        if (manager != null && !manager.trim().isEmpty()) {
            json.put("manager", manager);
        }
        if (departmentname != null && !departmentname.trim().isEmpty()) {
            json.put("departmentname", departmentname);
        }
        if (employeeType != null && !employeeType.trim().isEmpty()) {
            json.put("employeeType", employeeType);
        }
        if (jobdescription != null && !jobdescription.trim().isEmpty()) {
            json.put("jobdescription", jobdescription);
        }
        if (jobcodedesc != null && !jobcodedesc.trim().isEmpty()) {
            json.put("jobcodedesc", jobcodedesc);
        }
        if (email != null && !email.trim().isEmpty()) {
            json.put("email", email);
        }
        if (passwordExpired != null && !passwordExpired.trim().isEmpty()) {
            json.put("passwordExpired", passwordExpired);
        }
        if (enabled != null && !enabled.trim().isEmpty()) {
            json.put("enabled", enabled);
        }
        if (accountExpired != null && !accountExpired.trim().isEmpty()) {
            json.put("accountExpired", accountExpired);
        }
        if (password != null && !password.trim().isEmpty()) {
            json.put("password", password);
        }

        return json;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String str) {
        this.firstname = str;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String str) {
        this.lastname = str;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String str) {
        this.middlename = str;
    }
    
    public String getDisplayname() {
        return displayname;
    }
    
    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public String getStatuskey() {
        return statuskey;
    }

    public void setStatuskey(String str) {
        this.statuskey = str;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String str) {
        this.manager = str;
    }

    public String getDepartmentName() {
        return departmentname;
    }
    
    public void setDepartmentName(String str) {
        this.departmentname = str;
    }
    
    public String getEmployeeType() {
        return employeeType;
    }
    
    public void setEmployeeType(String str) {
        this.employeeType = str;
    }
    
    public String getJobDescription() {
        return jobdescription;
    }
    
    public void setJobDescription(String str) {
        this.jobdescription = str;
    }
    
    public String getJobcodeDesc() {
        return jobcodedesc;
    }
    
    public void setJobcodeDesc(String str) {
        this.jobcodedesc = str;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(String str) {
        this.passwordExpired = str;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String str) {
        this.enabled = str;
    }

    public String getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpire(String str) {
        this.accountExpired = str;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getSAVRoles() {
        return SAVRoles;
    }

    public void setSAVRoles(String str) {
        this.SAVRoles = str;
    }

    public String getUserGroups() {
        return UserGroups;
    }

    public void setUserGroups(String str) {
        this.UserGroups = str;
    }
}
