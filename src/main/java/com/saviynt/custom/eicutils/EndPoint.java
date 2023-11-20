package com.saviynt.custom.eicutils;

import org.json.JSONObject;

public class EndPoint {
    private String endpointname;
    private String displayName;
    private String securitysystem;
    private String description;
    private String ownerType;
    private String owner;
    private String resourceOwnerType;
    private String resourceOwner;
    private String accessquery;
    private String enableCopyAccess;
    private String disableNewAccountRequestIfAccountExists;
    private String disableRemoveAccount;
    private String allowRemoveAllRoleOnRequest;
    private String statusConfig;
    private String disableModifyAccount;
    private String userAccountCorrelationRule;
    private String accountNameRule;
    private String connectionconfig;
    private String taskemailtemplates;
    private String customproperty1Label;
    private String customproperty2Label;
    private String customproperty3Label;
    private String customproperty4Label;
    private String customproperty5Label;
    private String customproperty6Label;
    private String customproperty7Label;
    private String customproperty8Label;
    private String customproperty9Label;
    private String customproperty10Label;
    private String customproperty11Label;
    private String customproperty12Label;
    private String customproperty13Label;
    private String customproperty14Label;
    private String customproperty15Label;
    private String customproperty16Label;
    private String customproperty17Label;
    private String customproperty18Label;
    private String customproperty19Label;
    private String customproperty20Label;
    private String customproperty21Label;
    private String customproperty22Label;
    private String customproperty23Label;
    private String customproperty24Label;
    private String customproperty25Label;
    private String customproperty26Label;
    private String customproperty27Label;
    private String customproperty28Label;
    private String customproperty29Label;
    private String customproperty30Label;
    private String customproperty31Label;
    private String customproperty32Label;
    private String customproperty33Label;
    private String customproperty34Label;
    private String customproperty35Label;
    private String customproperty36Label;
    private String customproperty37Label;
    private String customproperty38Label;



    public EndPoint() {
        this.enableCopyAccess = "true";
        this.disableNewAccountRequestIfAccountExists = "false";
        this.disableRemoveAccount = "false";
        this.disableModifyAccount = "false";
        this.allowRemoveAllRoleOnRequest = "true";
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        if (endpointname != null && !endpointname.trim().isEmpty()) {
            json.put("endpointname", endpointname);
        }
        if (displayName != null && !displayName.trim().isEmpty()) {
            json.put("displayName", displayName);
        }
        if (securitysystem != null && !securitysystem.trim().isEmpty()) {
            json.put("securitysystem", securitysystem);
        }
        if (description != null && !description.trim().isEmpty()) {
            json.put("description", description);
        }
        if (ownerType != null && !ownerType.trim().isEmpty()) {
            json.put("ownerType", ownerType);
        }
        if (owner != null && !owner.trim().isEmpty()) {
            json.put("owner", owner);
        }
        if (resourceOwnerType != null && !resourceOwnerType.trim().isEmpty()) {
            json.put("resourceOwnerType", resourceOwnerType);
        }
        if (resourceOwner != null && !resourceOwner.trim().isEmpty()) {
            json.put("resourceOwner", resourceOwner);
        }
        if (accessquery != null && !accessquery.trim().isEmpty()) {
            json.put("accessquery", accessquery);
        }
        if (enableCopyAccess != null && !enableCopyAccess.trim().isEmpty()) {
            json.put("enableCopyAccess", enableCopyAccess);
        }
        if (disableNewAccountRequestIfAccountExists != null && !disableNewAccountRequestIfAccountExists.trim().isEmpty()) {
            json.put("disableNewAccountRequestIfAccountExists", disableNewAccountRequestIfAccountExists);
        }
        if (disableRemoveAccount != null && !disableRemoveAccount.trim().isEmpty()) {
            json.put("disableRemoveAccount", disableRemoveAccount);
        }
        if (allowRemoveAllRoleOnRequest != null && !allowRemoveAllRoleOnRequest.trim().isEmpty()) {
            json.put("allowRemoveAllRoleOnRequest", allowRemoveAllRoleOnRequest);
        }
        if (statusConfig != null && !statusConfig.trim().isEmpty()) {
            json.put("statusConfig", statusConfig);
        }
        if (disableModifyAccount != null && !disableModifyAccount.trim().isEmpty()) {
            json.put("disableModifyAccount", disableModifyAccount);
        }
        if (userAccountCorrelationRule != null && !userAccountCorrelationRule.trim().isEmpty()) {
            json.put("userAccountCorrelationRule", userAccountCorrelationRule);
        }
        if (accountNameRule != null && !accountNameRule.trim().isEmpty()) {
            json.put("accountNameRule", accountNameRule);
        }
        if (connectionconfig != null && !connectionconfig.trim().isEmpty()) {
            json.put("connectionconfig", connectionconfig);
        }
        if (taskemailtemplates != null && !taskemailtemplates.trim().isEmpty()) {
            json.put("taskemailtemplates", taskemailtemplates);
        }
        if (customproperty1Label != null && !customproperty1Label.trim().isEmpty()) {
            json.put("customproperty1Label", customproperty1Label);
        }
        if (customproperty2Label != null && !customproperty2Label.trim().isEmpty()) {
            json.put("customproperty2Label", customproperty2Label);
        }
        if (customproperty3Label != null && !customproperty3Label.trim().isEmpty()) {
            json.put("customproperty3Label", customproperty3Label);
        }
        if (customproperty4Label != null && !customproperty4Label.trim().isEmpty()) {
            json.put("customproperty4Label", customproperty4Label);
        }
        if (customproperty5Label != null && !customproperty5Label.trim().isEmpty()) {
            json.put("customproperty5Label", customproperty5Label);
        }
        if (customproperty6Label != null && !customproperty6Label.trim().isEmpty()) {
            json.put("customproperty6Label", customproperty6Label);
        }
        if (customproperty7Label != null && !customproperty7Label.trim().isEmpty()) {
            json.put("customproperty7Label", customproperty7Label);
        }
        if (customproperty8Label != null && !customproperty8Label.trim().isEmpty()) {
            json.put("customproperty8Label", customproperty8Label);
        }
        if (customproperty9Label != null && !customproperty9Label.trim().isEmpty()) {
            json.put("customproperty9Label", customproperty9Label);
        }
        if (customproperty10Label != null && !customproperty10Label.trim().isEmpty()) {
            json.put("customproperty10Label", customproperty10Label);
        }
        if (customproperty11Label != null && !customproperty11Label.trim().isEmpty()) {
            json.put("customproperty11Label", customproperty11Label);
        }
        if (customproperty12Label != null && !customproperty12Label.trim().isEmpty()) {
            json.put("customproperty12Label", customproperty12Label);
        }
        if (customproperty13Label != null && !customproperty13Label.trim().isEmpty()) {
            json.put("customproperty13Label", customproperty13Label);
        }
        if (customproperty14Label != null && !customproperty14Label.trim().isEmpty()) {
            json.put("customproperty14Label", customproperty14Label);
        }
        if (customproperty15Label != null && !customproperty15Label.trim().isEmpty()) {
            json.put("customproperty15Label", customproperty15Label);
        }
        if (customproperty16Label != null && !customproperty16Label.trim().isEmpty()) {
            json.put("customproperty16Label", customproperty16Label);
        }
        if (customproperty17Label != null && !customproperty17Label.trim().isEmpty()) {
            json.put("customproperty17Label", customproperty17Label);
        }
        if (customproperty18Label != null && !customproperty18Label.trim().isEmpty()) {
            json.put("customproperty18Label", customproperty18Label);
        }
        if (customproperty19Label != null && !customproperty19Label.trim().isEmpty()) {
            json.put("customproperty19Label", customproperty19Label);
        }
        if (customproperty20Label != null && !customproperty20Label.trim().isEmpty()) {
            json.put("customproperty20Label", customproperty20Label);
        }
        if (customproperty21Label != null && !customproperty21Label.trim().isEmpty()) {
            json.put("customproperty21Label", customproperty21Label);
        }
        if (customproperty22Label != null && !customproperty22Label.trim().isEmpty()) {
            json.put("customproperty22Label", customproperty22Label);
        }
        if (customproperty23Label != null && !customproperty23Label.trim().isEmpty()) {
            json.put("customproperty23Label", customproperty23Label);
        }
        if (customproperty24Label != null && !customproperty24Label.trim().isEmpty()) {
            json.put("customproperty24Label", customproperty24Label);
        }
        if (customproperty25Label != null && !customproperty25Label.trim().isEmpty()) {
            json.put("customproperty25Label", customproperty25Label);
        }
        if (customproperty26Label != null && !customproperty26Label.trim().isEmpty()) {
            json.put("customproperty26Label", customproperty26Label);
        }
        if (customproperty27Label != null && !customproperty27Label.trim().isEmpty()) {
            json.put("customproperty27Label", customproperty27Label);
        }
        if (customproperty28Label != null && !customproperty28Label.trim().isEmpty()) {
            json.put("customproperty28Label", customproperty28Label);
        }
        if (customproperty29Label != null && !customproperty29Label.trim().isEmpty()) {
            json.put("customproperty29Label", customproperty29Label);
        }
        if (customproperty30Label != null && !customproperty30Label.trim().isEmpty()) {
            json.put("customproperty30Label", customproperty30Label);
        }
        if (customproperty31Label != null && !customproperty31Label.trim().isEmpty()) {
            json.put("customproperty31Label", customproperty31Label);
        }
        if (customproperty32Label != null && !customproperty32Label.trim().isEmpty()) {
            json.put("customproperty32Label", customproperty32Label);
        }
        if (customproperty33Label != null && !customproperty33Label.trim().isEmpty()) {
            json.put("customproperty33Label", customproperty33Label);
        }
        if (customproperty34Label != null && !customproperty34Label.trim().isEmpty()) {
            json.put("customproperty34Label", customproperty34Label);
        }
        if (customproperty35Label != null && !customproperty35Label.trim().isEmpty()) {
            json.put("customproperty35Label", customproperty35Label);
        }
        if (customproperty36Label != null && !customproperty36Label.trim().isEmpty()) {
            json.put("customproperty36Label", customproperty36Label);
        }
        if (customproperty37Label != null && !customproperty37Label.trim().isEmpty()) {
            json.put("customproperty37Label", customproperty37Label);
        }
        if (customproperty38Label != null && !customproperty38Label.trim().isEmpty()) {
            json.put("customproperty38Label", customproperty38Label);
        }
        

        return json;
    }

    public String getEndpointname() {
        return this.endpointname;
    }

    public void setEndpointname(String endpointname) {
        this.endpointname = endpointname;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSecuritysystem() {
        return this.securitysystem;
    }

    public void setSecuritysystem(String securitysystem) {
        this.securitysystem = securitysystem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerType() {
        return this.ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getResourceOwnerType() {
        return this.resourceOwnerType;
    }

    public void setResourceOwnerType(String resourceOwnerType) {
        this.resourceOwnerType = resourceOwnerType;
    }

    public String getResourceOwner() {
        return this.resourceOwner;
    }

    public void setResourceOwner(String resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public String getAccessquery() {
        return this.accessquery;
    }

    public void setAccessquery(String accessquery) {
        this.accessquery = accessquery;
    }

    public String getEnableCopyAccess() {
        return this.enableCopyAccess;
    }

    public void setEnableCopyAccess(String enableCopyAccess) {
        this.enableCopyAccess = enableCopyAccess;
    }

    public String getDisableNewAccountRequestIfAccountExists() {
        return this.disableNewAccountRequestIfAccountExists;
    }

    public void setDisableNewAccountRequestIfAccountExists(String disableNewAccountRequestIfAccountExists) {
        this.disableNewAccountRequestIfAccountExists = disableNewAccountRequestIfAccountExists;
    }

    public String getDisableRemoveAccount() {
        return this.disableRemoveAccount;
    }

    public void setDisableRemoveAccount(String disableRemoveAccount) {
        this.disableRemoveAccount = disableRemoveAccount;
    }

    public String getStatusConfig() {
        return this.statusConfig;
    }

    public void setStatusConfig(String statusConfig) {
        this.statusConfig = statusConfig;
    }

    public String getDisableModifyAccount() {
        return this.disableModifyAccount;
    }

    public void setDisableModifyAccount(String disableModifyAccount) {
        this.disableModifyAccount = disableModifyAccount;
    }

    public String getUserAccountCorrelationRule() {
        return this.userAccountCorrelationRule;
    }

    public void setUserAccountCorrelationRule(String userAccountCorrelationRule) {
        this.userAccountCorrelationRule = userAccountCorrelationRule;
    }

    public String getAccountNameRule() {
        return this.accountNameRule;
    }

    public void setAccountNameRule(String accountNameRule) {
        this.accountNameRule = accountNameRule;
    }

    public String getConnectionconfig() {
        return this.connectionconfig;
    }

    public void setConnectionconfig(String connectionconfig) {
        this.connectionconfig = connectionconfig;
    }

    public String getAllowRemoveAllRoleOnRequest() {
        return this.allowRemoveAllRoleOnRequest;
    }

    public void setAllowRemoveAllRoleOnRequest(String allowRemoveAllRoleOnRequest) {
        this.allowRemoveAllRoleOnRequest = allowRemoveAllRoleOnRequest;
    }

    public String getTaskemailtemplates() {
        return this.taskemailtemplates;
    }

    public void setTaskemailtemplates(String taskemailtemplates) {
        this.taskemailtemplates = taskemailtemplates;
    }
    public String getCustomproperty1Label() {
        return this.customproperty1Label;
    }

    public void setCustomproperty1Label(String customproperty1Label) {
        this.customproperty1Label = customproperty1Label;
    }

    public String getCustomproperty2Label() {
        return this.customproperty2Label;
    }

    public void setCustomproperty2Label(String customproperty2Label) {
        this.customproperty2Label = customproperty2Label;
    }

    public String getCustomproperty3Label() {
        return this.customproperty3Label;
    }

    public void setCustomproperty3Label(String customproperty3Label) {
        this.customproperty3Label = customproperty3Label;
    }

    public String getCustomproperty4Label() {
        return this.customproperty4Label;
    }

    public void setCustomproperty4Label(String customproperty4Label) {
        this.customproperty4Label = customproperty4Label;
    }

    public String getCustomproperty5Label() {
        return this.customproperty5Label;
    }

    public void setCustomproperty5Label(String customproperty5Label) {
        this.customproperty5Label = customproperty5Label;
    }

    public String getCustomproperty6Label() {
        return this.customproperty6Label;
    }

    public void setCustomproperty6Label(String customproperty6Label) {
        this.customproperty6Label = customproperty6Label;
    }

    public String getCustomproperty7Label() {
        return this.customproperty7Label;
    }

    public void setCustomproperty7Label(String customproperty7Label) {
        this.customproperty7Label = customproperty7Label;
    }

    public String getCustomproperty8Label() {
        return this.customproperty8Label;
    }

    public void setCustomproperty8Label(String customproperty8Label) {
        this.customproperty8Label = customproperty8Label;
    }

    public String getCustomproperty9Label() {
        return this.customproperty9Label;
    }

    public void setCustomproperty9Label(String customproperty9Label) {
        this.customproperty9Label = customproperty9Label;
    }

    public String getCustomproperty10Label() {
        return this.customproperty10Label;
    }

    public void setCustomproperty10Label(String customproperty10Label) {
        this.customproperty10Label = customproperty10Label;
    }

    public String getCustomproperty11Label() {
        return this.customproperty11Label;
    }

    public void setCustomproperty11Label(String customproperty11Label) {
        this.customproperty11Label = customproperty11Label;
    }

    public String getCustomproperty12Label() {
        return this.customproperty12Label;
    }

    public void setCustomproperty12Label(String customproperty12Label) {
        this.customproperty12Label = customproperty12Label;
    }

    public String getCustomproperty13Label() {
        return this.customproperty13Label;
    }

    public void setCustomproperty13Label(String customproperty13Label) {
        this.customproperty13Label = customproperty13Label;
    }

    public String getCustomproperty14Label() {
        return this.customproperty14Label;
    }

    public void setCustomproperty14Label(String customproperty14Label) {
        this.customproperty14Label = customproperty14Label;
    }

    public String getCustomproperty15Label() {
        return this.customproperty15Label;
    }

    public void setCustomproperty15Label(String customproperty15Label) {
        this.customproperty15Label = customproperty15Label;
    }

    public String getCustomproperty16Label() {
        return this.customproperty16Label;
    }

    public void setCustomproperty16Label(String customproperty16Label) {
        this.customproperty16Label = customproperty16Label;
    }

    public String getCustomproperty17Label() {
        return this.customproperty17Label;
    }

    public void setCustomproperty17Label(String customproperty17Label) {
        this.customproperty17Label = customproperty17Label;
    }

    public String getCustomproperty18Label() {
        return this.customproperty18Label;
    }

    public void setCustomproperty18Label(String customproperty18Label) {
        this.customproperty18Label = customproperty18Label;
    }

    public String getCustomproperty19Label() {
        return this.customproperty19Label;
    }

    public void setCustomproperty19Label(String customproperty19Label) {
        this.customproperty19Label = customproperty19Label;
    }

    public String getCustomproperty20Label() {
        return this.customproperty20Label;
    }

    public void setCustomproperty20Label(String customproperty20Label) {
        this.customproperty20Label = customproperty20Label;
    }

    public String getCustomproperty21Label() {
        return this.customproperty21Label;
    }

    public void setCustomproperty21Label(String customproperty21Label) {
        this.customproperty21Label = customproperty21Label;
    }

    public String getCustomproperty22Label() {
        return this.customproperty22Label;
    }

    public void setCustomproperty22Label(String customproperty22Label) {
        this.customproperty22Label = customproperty22Label;
    }

    public String getCustomproperty23Label() {
        return this.customproperty23Label;
    }

    public void setCustomproperty23Label(String customproperty23Label) {
        this.customproperty23Label = customproperty23Label;
    }

    public String getCustomproperty24Label() {
        return this.customproperty24Label;
    }

    public void setCustomproperty24Label(String customproperty24Label) {
        this.customproperty24Label = customproperty24Label;
    }

    public String getCustomproperty25Label() {
        return this.customproperty25Label;
    }

    public void setCustomproperty25Label(String customproperty25Label) {
        this.customproperty25Label = customproperty25Label;
    }

    public String getCustomproperty26Label() {
        return this.customproperty26Label;
    }

    public void setCustomproperty26Label(String customproperty26Label) {
        this.customproperty26Label = customproperty26Label;
    }

    public String getCustomproperty27Label() {
        return this.customproperty27Label;
    }

    public void setCustomproperty27Label(String customproperty27Label) {
        this.customproperty27Label = customproperty27Label;
    }

    public String getCustomproperty28Label() {
        return this.customproperty28Label;
    }

    public void setCustomproperty28Label(String customproperty28Label) {
        this.customproperty28Label = customproperty28Label;
    }

    public String getCustomproperty29Label() {
        return this.customproperty29Label;
    }

    public void setCustomproperty29Label(String customproperty29Label) {
        this.customproperty29Label = customproperty29Label;
    }

    public String getCustomproperty30Label() {
        return this.customproperty30Label;
    }

    public void setCustomproperty30Label(String customproperty30Label) {
        this.customproperty30Label = customproperty30Label;
    }
    
    public String getCustomproperty31Label() {
        return this.customproperty31Label;
    }

    public void setCustomproperty31Label(String customproperty31Label) {
        this.customproperty31Label = customproperty31Label;
    }
    
    public String getCustomproperty32Label() {
        return this.customproperty32Label;
    }

    public void setCustomproperty32Label(String customproperty32Label) {
        this.customproperty32Label = customproperty32Label;
    }
    
    public String getCustomproperty33Label() {
        return this.customproperty33Label;
    }

    public void setCustomproperty33Label(String customproperty33Label) {
        this.customproperty33Label = customproperty33Label;
    }
    
    public String getCustomproperty34Label() {
        return this.customproperty34Label;
    }

    public void setCustomproperty34Label(String customproperty34Label) {
        this.customproperty34Label = customproperty34Label;
    }
    
    public String getCustomproperty35Label() {
        return this.customproperty35Label;
    }

    public void setCustomproperty35Label(String customproperty35Label) {
        this.customproperty35Label = customproperty35Label;
    }
    
    public String getCustomproperty36Label() {
        return this.customproperty36Label;
    }

    public void setCustomproperty36Label(String customproperty36Label) {
        this.customproperty36Label = customproperty36Label;
    }
    
    public String getCustomproperty37Label() {
        return this.customproperty37Label;
    }

    public void setCustomproperty37Label(String customproperty37Label) {
        this.customproperty37Label = customproperty37Label;
    }
    
    public String getCustomproperty38Label() {
        return this.customproperty38Label;
    }

    public void setCustomproperty38Label(String customproperty38Label) {
        this.customproperty38Label = customproperty38Label;
    }
}
