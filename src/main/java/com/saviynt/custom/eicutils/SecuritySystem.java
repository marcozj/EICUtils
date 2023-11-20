package com.saviynt.custom.eicutils;

import org.json.JSONObject;

/**
 *
 * @author marco
 */
public class SecuritySystem {
    private String systemname;
    private String displayName;
    private String hostname;
    private String port;
    private String connectionname;
    private String provisioningConnection;
    private String serviceDeskConnection;
    private String passwordManagementConnection;
    private String externalRiskConnectionJson;
    private String provisioningcomments;
    private String policyRule;
    
    private String accessAddWorkflow;
    private String accessRemoveWorkflow;
    private String addServiceAccountWorkflow;
    private String removeServiceAccountWorkflow;
    private String proposedAccountOwnersworkflow;
    private String firefighteridWorkflow;
    private String firefighteridRequestAccessWorkflow;
    private String provisioningTries;
    private String policyRuleServiceAccount;
    
    private String defaultSystem;
    private String manageEntity;
    private String useopenconnector;
    private String provLimitJSON;
    private String automatedProvisioning;
    private String persistentData;
    private String reconApplication;
    private String instantprovision;
    
    public SecuritySystem() {
        this.defaultSystem = "false";
        this.manageEntity = "false";
        this.useopenconnector = "false";
        this.automatedProvisioning = "true";
        this.persistentData = "false";
        this.reconApplication = "true";
        this.instantprovision = "false";
    }
    
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        
        if (systemname != null && !systemname.trim().isEmpty()) {
            json.put("systemname", systemname);
        }
        
        if (displayName != null && !displayName.trim().isEmpty()) {
            json.put("displayName", displayName);
        }
        
        if (hostname != null && !hostname.trim().isEmpty()) {
            json.put("hostname", hostname);
        }
        
        if (port != null && !port.trim().isEmpty()) {
            json.put("port", port);
        }
        
        if (connectionname != null && !connectionname.trim().isEmpty()) {
            json.put("connectionname", connectionname);
        }
        
        if (provisioningConnection != null && !provisioningConnection.trim().isEmpty()) {
            json.put("provisioningConnection", provisioningConnection);
        }
        
        if (serviceDeskConnection != null && !serviceDeskConnection.trim().isEmpty()) {
            json.put("serviceDeskConnection", serviceDeskConnection);
        }
        
        if (passwordManagementConnection != null && !passwordManagementConnection.trim().isEmpty()) {
            json.put("passwordManagementConnection", passwordManagementConnection);
        }
        
        if (externalRiskConnectionJson != null && !externalRiskConnectionJson.trim().isEmpty()) {
            json.put("externalRiskConnectionJson", externalRiskConnectionJson);
        }
        
        if (provisioningcomments != null && !provisioningcomments.trim().isEmpty()) {
            json.put("provisioningcomments", provisioningcomments);
        }
        
        if (policyRule != null && !policyRule.trim().isEmpty()) {
            json.put("policyRule", policyRule);
        }
        
        if (accessAddWorkflow != null && !accessAddWorkflow.trim().isEmpty()) {
            json.put("accessAddWorkflow", accessAddWorkflow);
        }
        
        if (accessRemoveWorkflow != null && !accessRemoveWorkflow.trim().isEmpty()) {
            json.put("accessRemoveWorkflow", accessRemoveWorkflow);
        }
        
        if (addServiceAccountWorkflow != null && !addServiceAccountWorkflow.trim().isEmpty()) {
            json.put("addServiceAccountWorkflow", addServiceAccountWorkflow);
        }
        
        if (removeServiceAccountWorkflow != null && !removeServiceAccountWorkflow.trim().isEmpty()) {
            json.put("removeServiceAccountWorkflow", removeServiceAccountWorkflow);
        }
        
        if (proposedAccountOwnersworkflow != null && !proposedAccountOwnersworkflow.trim().isEmpty()) {
            json.put("proposedAccountOwnersworkflow", proposedAccountOwnersworkflow);
        }
        
        if (firefighteridWorkflow != null && !firefighteridWorkflow.trim().isEmpty()) {
            json.put("firefighteridWorkflow", firefighteridWorkflow);
        }
        
        if (firefighteridRequestAccessWorkflow != null && !firefighteridRequestAccessWorkflow.trim().isEmpty()) {
            json.put("firefighteridRequestAccessWorkflow", firefighteridRequestAccessWorkflow);
        }
        
        if (provisioningTries != null && !provisioningTries.trim().isEmpty()) {
            json.put("provisioningTries", Integer.getInteger(provisioningTries));
        }
        
        if (policyRuleServiceAccount != null && !policyRuleServiceAccount.trim().isEmpty()) {
            json.put("policyRuleServiceAccount", policyRuleServiceAccount);
        }
        
        if (provLimitJSON != null && !provLimitJSON.trim().isEmpty()) {
            json.put("provLimitJSON", provLimitJSON);
        }
        
        if (defaultSystem != null && defaultSystem.equalsIgnoreCase("true")) {
            json.put("defaultSystem", defaultSystem);
        }
        
        if (manageEntity != null && manageEntity.equalsIgnoreCase("true")) {
            json.put("manageEntity", manageEntity);
        }

        if (useopenconnector != null && useopenconnector.equalsIgnoreCase("true")) {
            json.put("useopenconnector", useopenconnector);
        }
        
        if (automatedProvisioning != null && automatedProvisioning.equalsIgnoreCase("true")) {
            json.put("automatedProvisioning", automatedProvisioning);
        }
        
        if (persistentData != null && persistentData.equalsIgnoreCase("true")) {
            json.put("persistentData", persistentData);
        }
        
        if (reconApplication != null && reconApplication.equalsIgnoreCase("true")) {
            json.put("reconApplication", reconApplication);
        }
        
        if (instantprovision != null && instantprovision.equalsIgnoreCase("true")) {
            json.put("instantprovision", instantprovision);
        }

        return json;
    }
    
    public JSONObject toCreateJSON() {
        JSONObject json = new JSONObject();
        
        if (systemname != null && !systemname.trim().isEmpty()) {
            json.put("systemname", systemname);
        }
        
        if (displayName != null && !displayName.trim().isEmpty()) {
            json.put("displayName", displayName);
        }
        
        if (hostname != null && !hostname.trim().isEmpty()) {
            json.put("hostname", hostname);
        }
        
        if (port != null && !port.trim().isEmpty()) {
            json.put("port", port);
        }
        
        if (provisioningcomments != null && !provisioningcomments.trim().isEmpty()) {
            json.put("provisioningcomments", provisioningcomments);
        }
        
        if (accessAddWorkflow != null && !accessAddWorkflow.trim().isEmpty()) {
            json.put("accessAddWorkflow", accessAddWorkflow);
        }
        
        if (accessRemoveWorkflow != null && !accessRemoveWorkflow.trim().isEmpty()) {
            json.put("accessRemoveWorkflow", accessRemoveWorkflow);
        }
        
        if (addServiceAccountWorkflow != null && !addServiceAccountWorkflow.trim().isEmpty()) {
            json.put("addServiceAccountWorkflow", addServiceAccountWorkflow);
        }
        
        if (removeServiceAccountWorkflow != null && !removeServiceAccountWorkflow.trim().isEmpty()) {
            json.put("removeServiceAccountWorkflow", removeServiceAccountWorkflow);
        }
        
        if (proposedAccountOwnersworkflow != null && !proposedAccountOwnersworkflow.trim().isEmpty()) {
            json.put("proposedAccountOwnersworkflow", proposedAccountOwnersworkflow);
        }
        
        if (firefighteridWorkflow != null && !firefighteridWorkflow.trim().isEmpty()) {
            json.put("firefighteridWorkflow", firefighteridWorkflow);
        }
        
        if (firefighteridRequestAccessWorkflow != null && !firefighteridRequestAccessWorkflow.trim().isEmpty()) {
            json.put("firefighteridRequestAccessWorkflow", firefighteridRequestAccessWorkflow);
        }
        
        if (provisioningTries != null && !provisioningTries.trim().isEmpty()) {
            json.put("provisioningTries", Integer.getInteger(provisioningTries));
        }
        
        if (provLimitJSON != null && !provLimitJSON.trim().isEmpty()) {
            json.put("provLimitJSON", provLimitJSON);
        }
        
        if (defaultSystem != null && defaultSystem.equalsIgnoreCase("true")) {
            json.put("defaultSystem", defaultSystem);
        }
        
        if (manageEntity != null && manageEntity.equalsIgnoreCase("true")) {
            json.put("manageEntity", manageEntity);
        }

        if (useopenconnector != null && useopenconnector.equalsIgnoreCase("true")) {
            json.put("useopenconnector", useopenconnector);
        }
        
        if (automatedProvisioning != null && automatedProvisioning.equalsIgnoreCase("true")) {
            json.put("automatedProvisioning", automatedProvisioning);
        }
        
        if (persistentData != null && persistentData.equalsIgnoreCase("true")) {
            json.put("persistentData", persistentData);
        }
        
        if (reconApplication != null && reconApplication.equalsIgnoreCase("true")) {
            json.put("reconApplication", reconApplication);
        }
        
        if (instantprovision != null && instantprovision.equalsIgnoreCase("true")) {
            json.put("instantprovision", instantprovision);
        }

        return json;
    }
    
    public JSONObject toUpdateJSON() {
        JSONObject json = new JSONObject();
        
        if (systemname != null && !systemname.trim().isEmpty()) {
            json.put("systemname", systemname);
        }
        
        if (displayName != null && !displayName.trim().isEmpty()) {
            json.put("displayName", displayName);
        }
        
        if (hostname != null && !hostname.trim().isEmpty()) {
            json.put("hostname", hostname);
        }
        
        if (port != null && !port.trim().isEmpty()) {
            json.put("port", port);
        }
        
        if (provisioningcomments != null && !provisioningcomments.trim().isEmpty()) {
            json.put("provisioningcomments", provisioningcomments);
        }
        
        if (accessAddWorkflow != null && !accessAddWorkflow.trim().isEmpty()) {
            json.put("accessAddWorkflow", accessAddWorkflow);
        }
        
        if (accessRemoveWorkflow != null && !accessRemoveWorkflow.trim().isEmpty()) {
            json.put("accessRemoveWorkflow", accessRemoveWorkflow);
        }
        
        if (addServiceAccountWorkflow != null && !addServiceAccountWorkflow.trim().isEmpty()) {
            json.put("addServiceAccountWorkflow", addServiceAccountWorkflow);
        }
        
        if (removeServiceAccountWorkflow != null && !removeServiceAccountWorkflow.trim().isEmpty()) {
            json.put("removeServiceAccountWorkflow", removeServiceAccountWorkflow);
        }
        
        if (proposedAccountOwnersworkflow != null && !proposedAccountOwnersworkflow.trim().isEmpty()) {
            json.put("proposedAccountOwnersworkflow", proposedAccountOwnersworkflow);
        }
        
        if (firefighteridWorkflow != null && !firefighteridWorkflow.trim().isEmpty()) {
            json.put("firefighteridWorkflow", firefighteridWorkflow);
        }
        
        if (firefighteridRequestAccessWorkflow != null && !firefighteridRequestAccessWorkflow.trim().isEmpty()) {
            json.put("firefighteridRequestAccessWorkflow", firefighteridRequestAccessWorkflow);
        }
        
        if (provisioningTries != null && !provisioningTries.trim().isEmpty()) {
            json.put("provisioningTries", Integer.getInteger(provisioningTries));
        }
        
        if (provLimitJSON != null && !provLimitJSON.trim().isEmpty()) {
            json.put("provLimitJSON", provLimitJSON);
        }
        
        if (defaultSystem != null && defaultSystem.equalsIgnoreCase("true")) {
            json.put("defaultSystem", defaultSystem);
        }
        
        if (manageEntity != null && manageEntity.equalsIgnoreCase("true")) {
            json.put("manageEntity", manageEntity);
        }

        if (useopenconnector != null && useopenconnector.equalsIgnoreCase("true")) {
            json.put("useopenconnector", useopenconnector);
        }
        
        if (automatedProvisioning != null && automatedProvisioning.equalsIgnoreCase("true")) {
            json.put("automatedProvisioning", automatedProvisioning);
        }
        
        if (persistentData != null && persistentData.equalsIgnoreCase("true")) {
            json.put("persistentData", persistentData);
        }
        
        if (reconApplication != null && reconApplication.equalsIgnoreCase("true")) {
            json.put("reconApplication", reconApplication);
        }
        
        if (instantprovision != null && instantprovision.equalsIgnoreCase("true")) {
            json.put("instantprovision", instantprovision);
        }
        
        if (connectionname != null && !connectionname.trim().isEmpty()) {
            json.put("connectionname", connectionname);
        }
        
        if (provisioningConnection != null && !provisioningConnection.trim().isEmpty()) {
            json.put("provisioningConnection", provisioningConnection);
        }
        
        if (serviceDeskConnection != null && !serviceDeskConnection.trim().isEmpty()) {
            json.put("serviceDeskConnection", serviceDeskConnection);
        }
        
        if (externalRiskConnectionJson != null && !externalRiskConnectionJson.trim().isEmpty()) {
            json.put("externalRiskConnectionJson", externalRiskConnectionJson);
        }
        
        if (provLimitJSON != null && !provLimitJSON.trim().isEmpty()) {
            json.put("provLimitJSON", provLimitJSON);
        }

        return json;
    }
    
    public String getSystemname() {
        return this.systemname;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getConnectionname() {
        return this.connectionname;
    }

    public void setConnectionname(String connectionname) {
        this.connectionname = connectionname;
    }

    public String getProvisioningConnection() {
        return this.provisioningConnection;
    }

    public void setProvisioningConnection(String provisioningConnection) {
        this.provisioningConnection = provisioningConnection;
    }

    public String getServiceDeskConnection() {
        return this.serviceDeskConnection;
    }

    public void setServiceDeskConnection(String serviceDeskConnection) {
        this.serviceDeskConnection = serviceDeskConnection;
    }

    public String getPasswordManagementConnection() {
        return this.passwordManagementConnection;
    }

    public void setPasswordManagementConnection(String passwordManagementConnection) {
        this.passwordManagementConnection = passwordManagementConnection;
    }

    public String getExternalRiskConnectionJson() {
        return this.externalRiskConnectionJson;
    }

    public void setExternalRiskConnectionJson(String externalRiskConnectionJson) {
        this.externalRiskConnectionJson = externalRiskConnectionJson;
    }

    public String getProvisioningcomments() {
        return this.provisioningcomments;
    }

    public void setProvisioningcomments(String provisioningcomments) {
        this.provisioningcomments = provisioningcomments;
    }

    public String getPolicyRule() {
        return this.policyRule;
    }

    public void setPolicyRule(String policyRule) {
        this.policyRule = policyRule;
    }

    public String getAccessAddWorkflow() {
        return this.accessAddWorkflow;
    }

    public void setAccessAddWorkflow(String accessAddWorkflow) {
        this.accessAddWorkflow = accessAddWorkflow;
    }

    public String getAccessRemoveWorkflow() {
        return this.accessRemoveWorkflow;
    }

    public void setAccessRemoveWorkflow(String accessRemoveWorkflow) {
        this.accessRemoveWorkflow = accessRemoveWorkflow;
    }

    public String getAddServiceAccountWorkflow() {
        return this.addServiceAccountWorkflow;
    }

    public void setAddServiceAccountWorkflow(String addServiceAccountWorkflow) {
        this.addServiceAccountWorkflow = addServiceAccountWorkflow;
    }

    public String getRemoveServiceAccountWorkflow() {
        return this.removeServiceAccountWorkflow;
    }

    public void setRemoveServiceAccountWorkflow(String removeServiceAccountWorkflow) {
        this.removeServiceAccountWorkflow = removeServiceAccountWorkflow;
    }

    public String getProposedAccountOwnersworkflow() {
        return this.proposedAccountOwnersworkflow;
    }

    public void setProposedAccountOwnersworkflow(String proposedAccountOwnersworkflow) {
        this.proposedAccountOwnersworkflow = proposedAccountOwnersworkflow;
    }

    public String getFirefighteridWorkflow() {
        return this.firefighteridWorkflow;
    }

    public void setFirefighteridWorkflow(String firefighteridWorkflow) {
        this.firefighteridWorkflow = firefighteridWorkflow;
    }

    public String getFirefighteridRequestAccessWorkflow() {
        return this.firefighteridRequestAccessWorkflow;
    }

    public void setFirefighteridRequestAccessWorkflow(String firefighteridRequestAccessWorkflow) {
        this.firefighteridRequestAccessWorkflow = firefighteridRequestAccessWorkflow;
    }

    public String getProvisioningTries() {
        return this.provisioningTries;
    }

    public void setProvisioningTries(String provisioningTries) {
        this.provisioningTries = provisioningTries;
    }

    public String getPolicyRuleServiceAccount() {
        return this.policyRuleServiceAccount;
    }

    public void setPolicyRuleServiceAccount(String policyRuleServiceAccount) {
        this.policyRuleServiceAccount = policyRuleServiceAccount;
    }

    public String getDefaultSystem() {
        return this.defaultSystem;
    }

    public void setDefaultSystem(String defaultSystem) {
        this.defaultSystem = defaultSystem;
    }

    public String getManageEntity() {
        return this.manageEntity;
    }

    public void setManageEntity(String manageEntity) {
        this.manageEntity = manageEntity;
    }

    public String getUseopenconnector() {
        return this.useopenconnector;
    }

    public void setUseopenconnector(String useopenconnector) {
        this.useopenconnector = useopenconnector;
    }

    public String getProvLimitJSON() {
        return this.provLimitJSON;
    }

    public void setProvLimitJSON(String provLimitJSON) {
        this.provLimitJSON = provLimitJSON;
    }

    public String getAutomatedProvisioning() {
        return this.automatedProvisioning;
    }

    public void setAutomatedProvisioning(String automatedProvisioning) {
        this.automatedProvisioning = automatedProvisioning;
    }

    public String getPersistentData() {
        return this.persistentData;
    }

    public void setPersistentData(String persistentData) {
        this.persistentData = persistentData;
    }

    public String getReconApplication() {
        return this.reconApplication;
    }

    public void setReconApplication(String reconApplication) {
        this.reconApplication = reconApplication;
    }

    public String getInstantprovision() {
        return this.instantprovision;
    }

    public void setInstantprovision(String instantprovision) {
        this.instantprovision = instantprovision;
    }
}
