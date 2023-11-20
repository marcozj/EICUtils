package com.saviynt.custom.eicutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Utils {

    public enum UserHeaders {
        username, firstname, lastname, middlename, displayname, statuskey, manager, email, departmentname, employeetype, jobdescription, 
        jobcodedesc, passwordExpired, enabled, accountExpired, password, SAVRoles, UserGroups
    }

    public enum EndPointHeaders {
        endpointname, displayName, securitysystem, description, ownerType, owner, resourceOwnerType, resourceOwner,
        enableCopyAccess, disableNewAccountRequestIfAccountExists, disableRemoveAccount, disableModifyAccount,
        allowRemoveAllRoleOnRequest, statusConfig, accessquery, userAccountCorrelationRule, accountNameRule,
        connectionconfig, taskemailtemplates, customproperty1Label, customproperty2Label, customproperty3Label,
        customproperty4Label, customproperty5Label, customproperty6Label, customproperty7Label, customproperty8Label,
        customproperty9Label, customproperty10Label, customproperty11Label, customproperty12Label, customproperty13Label, 
        customproperty14Label, customproperty15Label, customproperty16Label,customproperty17Label, customproperty18Label, 
        customproperty19Label, customproperty20Label, customproperty21Label, customproperty22Label, customproperty23Label, 
        customproperty24Label, customproperty25Label, customproperty26Label, customproperty27Label, customproperty28Label,
        customproperty29Label, customproperty30Label, customproperty31Label, customproperty32Label, customproperty33Label, 
        customproperty34Label, customproperty35Label, customproperty36Label, customproperty37Label, customproperty38Label
    }

    public enum SecuritySystemHeaders {
        systemname, displayName, hostname, port, connectionname, provisioningConnection, serviceDeskConnection, 
        externalRiskConnectionJson, provisioningcomments, accessAddWorkflow, accessRemoveWorkflow, addServiceAccountWorkflow, 
        removeServiceAccountWorkflow, proposedAccountOwnersworkflow, firefighteridWorkflow, firefighteridRequestAccessWorkflow, 
        provisioningTries, defaultSystem, manageEntity, useopenconnector, provLimitJSON, automatedProvisioning, 
        persistentData, reconApplication, instantprovision

    }

    public static List<String> getPropertyList(Properties properties, String name) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (((String) entry.getKey()).matches("^" + Pattern.quote(name) + "\\.\\d+$")) {
                result.add((String) entry.getValue());
            }
        }
        return result;
    }

    public static ArrayList<SAVUser> readUsers(String file)
            throws FileNotFoundException, IOException {
        ArrayList<SAVUser> userObjs = new ArrayList<>();
        Reader reader = new FileReader(file);
        // Iterable<CSVRecord> records =
        // CSVFormat.DEFAULT.withHeader(UserHeaders.class).parse(in);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(UserHeaders.class).setIgnoreHeaderCase(true)
                .setSkipHeaderRecord(true)
                .setTrim(true).build();
        Iterable<CSVRecord> records = format.parse(reader);

        for (CSVRecord record : records) {
            SAVUser user = new SAVUser();
            user.setUsername(record.get(UserHeaders.username));
            user.setFirstname(record.get(UserHeaders.firstname));
            user.setLastname(record.get(UserHeaders.lastname));
            user.setMiddlename(record.get(UserHeaders.middlename));
            user.setDisplayname(record.get(UserHeaders.displayname));
            user.setStatuskey(record.get(UserHeaders.statuskey));
            user.setManager(record.get(UserHeaders.manager));
            user.setDepartmentName(record.get(UserHeaders.departmentname));
            user.setEmployeeType(record.get(UserHeaders.employeetype));
            user.setJobDescription(record.get(UserHeaders.jobdescription));
            user.setJobcodeDesc(record.get(UserHeaders.jobcodedesc));
            user.setEmail(record.get(UserHeaders.email));
            user.setPasswordExpired(record.get(UserHeaders.passwordExpired));
            user.setEnabled(record.get(UserHeaders.enabled));
            user.setAccountExpire(record.get(UserHeaders.accountExpired));
            user.setPassword(record.get(UserHeaders.password));
            user.setSAVRoles(record.get(UserHeaders.SAVRoles));
            user.setUserGroups(record.get(UserHeaders.UserGroups));
            // System.out.println(user.toJSON());
            userObjs.add(user);
        }

        return userObjs;
    }

    public static ArrayList<SecuritySystem> readSecuritySystems(String file, String delimiter)
            throws FileNotFoundException, IOException {
        ArrayList<SecuritySystem> SecuritySystemObjs = new ArrayList<>();
        Reader reader = new FileReader(file);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(SecuritySystemHeaders.class).setIgnoreHeaderCase(true)
                .setSkipHeaderRecord(true).setDelimiter(delimiter)
                .setTrim(true).build();
        Iterable<CSVRecord> records = format.parse(reader);

        for (CSVRecord record : records) {
            SecuritySystem securitysystem = new SecuritySystem();
            securitysystem.setSystemname(record.get(SecuritySystemHeaders.systemname));
            securitysystem.setDisplayName(record.get(SecuritySystemHeaders.displayName));
            securitysystem.setHostname(record.get(SecuritySystemHeaders.hostname));
            securitysystem.setPort(record.get(SecuritySystemHeaders.port));
            securitysystem.setConnectionname(record.get(SecuritySystemHeaders.connectionname));
            securitysystem.setProvisioningConnection(record.get(SecuritySystemHeaders.provisioningConnection));
            securitysystem.setServiceDeskConnection(record.get(SecuritySystemHeaders.serviceDeskConnection));
            securitysystem.setExternalRiskConnectionJson(record.get(SecuritySystemHeaders.externalRiskConnectionJson));
            securitysystem.setProvisioningcomments(record.get(SecuritySystemHeaders.provisioningcomments));
            securitysystem.setAccessAddWorkflow(record.get(SecuritySystemHeaders.accessAddWorkflow));
            securitysystem.setAccessRemoveWorkflow(record.get(SecuritySystemHeaders.accessRemoveWorkflow));
            securitysystem.setAddServiceAccountWorkflow(record.get(SecuritySystemHeaders.addServiceAccountWorkflow));
            securitysystem.setRemoveServiceAccountWorkflow(record.get(SecuritySystemHeaders.removeServiceAccountWorkflow));
            securitysystem.setProposedAccountOwnersworkflow(record.get(SecuritySystemHeaders.proposedAccountOwnersworkflow));
            securitysystem.setFirefighteridWorkflow(record.get(SecuritySystemHeaders.firefighteridWorkflow));
            securitysystem.setFirefighteridRequestAccessWorkflow(record.get(SecuritySystemHeaders.firefighteridRequestAccessWorkflow));
            securitysystem.setProvisioningTries(record.get(SecuritySystemHeaders.provisioningTries));
            securitysystem.setDefaultSystem(record.get(SecuritySystemHeaders.defaultSystem));
            securitysystem.setManageEntity(record.get(SecuritySystemHeaders.manageEntity));
            securitysystem.setUseopenconnector(record.get(SecuritySystemHeaders.useopenconnector));
            securitysystem.setProvLimitJSON(record.get(SecuritySystemHeaders.provLimitJSON));
            securitysystem.setAutomatedProvisioning(record.get(SecuritySystemHeaders.automatedProvisioning));
            securitysystem.setPersistentData(record.get(SecuritySystemHeaders.persistentData));
            securitysystem.setReconApplication(record.get(SecuritySystemHeaders.reconApplication));
            securitysystem.setInstantprovision(record.get(SecuritySystemHeaders.instantprovision));
    
            //System.out.println(securitysystem.toJSON());
            SecuritySystemObjs.add(securitysystem);
        }

        return SecuritySystemObjs;
    }

    public static ArrayList<EndPoint> readEndpoints(String file, String delimiter)
            throws FileNotFoundException, IOException {
        ArrayList<EndPoint> endpointObjs = new ArrayList<>();
        Reader reader = new FileReader(file);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(EndPointHeaders.class).setIgnoreHeaderCase(true)
                .setSkipHeaderRecord(true).setDelimiter(delimiter)
                .setTrim(true).build();
        Iterable<CSVRecord> records = format.parse(reader);

        for (CSVRecord record : records) {
            EndPoint endpoint = new EndPoint();
            endpoint.setEndpointname(record.get(EndPointHeaders.endpointname));
            endpoint.setDisplayName(record.get(EndPointHeaders.displayName));
            endpoint.setSecuritysystem(record.get(EndPointHeaders.securitysystem));
            endpoint.setDescription(record.get(EndPointHeaders.description));
            endpoint.setOwnerType(record.get(EndPointHeaders.ownerType));
            endpoint.setOwner(record.get(EndPointHeaders.owner));
            endpoint.setResourceOwnerType(record.get(EndPointHeaders.resourceOwnerType));
            endpoint.setResourceOwner(record.get(EndPointHeaders.resourceOwner));
            endpoint.setEnableCopyAccess(record.get(EndPointHeaders.enableCopyAccess));
            endpoint.setDisableNewAccountRequestIfAccountExists(
                    record.get(EndPointHeaders.disableNewAccountRequestIfAccountExists));
            endpoint.setDisableRemoveAccount(record.get(EndPointHeaders.disableRemoveAccount));
            endpoint.setDisableModifyAccount(record.get(EndPointHeaders.disableModifyAccount));
            endpoint.setAllowRemoveAllRoleOnRequest(record.get(EndPointHeaders.allowRemoveAllRoleOnRequest));
            endpoint.setStatusConfig(record.get(EndPointHeaders.statusConfig));
            endpoint.setAccessquery(record.get(EndPointHeaders.accessquery));
            endpoint.setUserAccountCorrelationRule(record.get(EndPointHeaders.userAccountCorrelationRule));
            endpoint.setAccountNameRule(record.get(EndPointHeaders.accountNameRule));
            endpoint.setConnectionconfig(record.get(EndPointHeaders.connectionconfig));
            endpoint.setTaskemailtemplates(record.get(EndPointHeaders.taskemailtemplates));
            endpoint.setCustomproperty1Label(record.get(EndPointHeaders.customproperty1Label));
            endpoint.setCustomproperty2Label(record.get(EndPointHeaders.customproperty2Label));
            endpoint.setCustomproperty3Label(record.get(EndPointHeaders.customproperty3Label));
            endpoint.setCustomproperty4Label(record.get(EndPointHeaders.customproperty4Label));
            endpoint.setCustomproperty5Label(record.get(EndPointHeaders.customproperty5Label));
            endpoint.setCustomproperty6Label(record.get(EndPointHeaders.customproperty6Label));
            endpoint.setCustomproperty7Label(record.get(EndPointHeaders.customproperty7Label));
            endpoint.setCustomproperty8Label(record.get(EndPointHeaders.customproperty8Label));
            endpoint.setCustomproperty9Label(record.get(EndPointHeaders.customproperty9Label));
            endpoint.setCustomproperty10Label(record.get(EndPointHeaders.customproperty10Label));
            endpoint.setCustomproperty11Label(record.get(EndPointHeaders.customproperty11Label));
            endpoint.setCustomproperty12Label(record.get(EndPointHeaders.customproperty12Label));
            endpoint.setCustomproperty13Label(record.get(EndPointHeaders.customproperty13Label));
            endpoint.setCustomproperty14Label(record.get(EndPointHeaders.customproperty14Label));
            endpoint.setCustomproperty15Label(record.get(EndPointHeaders.customproperty15Label));
            endpoint.setCustomproperty16Label(record.get(EndPointHeaders.customproperty16Label));
            endpoint.setCustomproperty17Label(record.get(EndPointHeaders.customproperty17Label));
            endpoint.setCustomproperty18Label(record.get(EndPointHeaders.customproperty18Label));
            endpoint.setCustomproperty19Label(record.get(EndPointHeaders.customproperty19Label));
            endpoint.setCustomproperty20Label(record.get(EndPointHeaders.customproperty20Label));
            endpoint.setCustomproperty21Label(record.get(EndPointHeaders.customproperty21Label));
            endpoint.setCustomproperty22Label(record.get(EndPointHeaders.customproperty22Label));
            endpoint.setCustomproperty23Label(record.get(EndPointHeaders.customproperty23Label));
            endpoint.setCustomproperty24Label(record.get(EndPointHeaders.customproperty24Label));
            endpoint.setCustomproperty25Label(record.get(EndPointHeaders.customproperty25Label));
            endpoint.setCustomproperty26Label(record.get(EndPointHeaders.customproperty26Label));
            endpoint.setCustomproperty27Label(record.get(EndPointHeaders.customproperty27Label));
            endpoint.setCustomproperty28Label(record.get(EndPointHeaders.customproperty28Label));
            endpoint.setCustomproperty29Label(record.get(EndPointHeaders.customproperty29Label));
            endpoint.setCustomproperty30Label(record.get(EndPointHeaders.customproperty30Label));
            endpoint.setCustomproperty31Label(record.get(EndPointHeaders.customproperty31Label));
            endpoint.setCustomproperty32Label(record.get(EndPointHeaders.customproperty32Label));
            endpoint.setCustomproperty33Label(record.get(EndPointHeaders.customproperty33Label));
            endpoint.setCustomproperty34Label(record.get(EndPointHeaders.customproperty34Label));
            endpoint.setCustomproperty35Label(record.get(EndPointHeaders.customproperty35Label));
            endpoint.setCustomproperty36Label(record.get(EndPointHeaders.customproperty36Label));
            endpoint.setCustomproperty37Label(record.get(EndPointHeaders.customproperty37Label));
            endpoint.setCustomproperty38Label(record.get(EndPointHeaders.customproperty38Label));

            //System.out.println(endpoint.toJSON());
            endpointObjs.add(endpoint);
        }

        return endpointObjs;
    }

    public static String escapeMetaCharacters(String inputString) {
        final String[] metaCharacters = {"\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<",
            ">", "-", "&", "%"};

        for (String metaCharacter : metaCharacters) {
            if (inputString.contains(metaCharacter)) {
                inputString = inputString.replace(metaCharacter, "\\" + metaCharacter);
            }
        }
        return inputString;
    }

    public static void unzipFile(String zipfile, String dir) throws IOException {
        System.out.println("zip file: " + zipfile);
        System.out.println("dir: " + dir);
        File destDir = new File(dir);
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipfile))) {
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                File destFile = new File(destDir, zipEntry.getName());
                String destDirPath = destDir.getCanonicalPath();
                String destFilePath = destFile.getCanonicalPath();
                if (!destFilePath.startsWith(destDirPath + File.separator)) {
                    throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
                }

                if (zipEntry.isDirectory()) {
                    if (!destFile.isDirectory() && !destFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + destFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = destFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    try ( // write file content
                            FileOutputStream fos = new FileOutputStream(destFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        }
    }

    public static void zipDirectory(String sourcedir, String zipfile) throws IOException {
        System.out.println("sourcedir: " + sourcedir);
        System.out.println("zipfile: " + zipfile);
        try (FileOutputStream fos = new FileOutputStream(zipfile); ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            File fileToZip = new File(sourcedir);
            zipFile(fileToZip, fileToZip.getName(), zipOut);
        }
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }
}
