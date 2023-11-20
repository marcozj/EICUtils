package com.saviynt.custom.eicutils;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.MessagingException;
import org.apache.http.ParseException;

/**
 *
 * @author marcozhang
 */
public class Main {

    final private static String CONFIGFILE = "eicutils.config";
    protected static Properties prop;
    protected static String Admin_User;
    protected static String Admin_Password;
    protected static String Refresh_Token;
    protected static String DataFileDir;
    protected static String TenantURL;

    public static void main(String[] args) throws Exception {
        init();

        // Prompt login user name and password if not defined
        APIHandler api = new APIHandler(TenantURL);
        Console console = System.console();
        System.out.println("Login to tenant: " + TenantURL);

        if (Refresh_Token != null && !Refresh_Token.trim().isEmpty()) {
            api.getAuthToken(Refresh_Token);
        } else {
            if (Admin_User == null || Admin_User.trim().isEmpty()) {
                Admin_User = console.readLine("Username: ");
            }
            if (Admin_Password == null || Admin_Password.trim().isEmpty()) {
                Admin_Password = new String(console.readPassword("Password: "));
            }
            api.getAuthToken(Admin_User, Admin_Password);
        }

        String choice = menu();
        switch (choice) {
            case "1" -> uploadUsersfile(api);
            case "2" -> createUsers(api);
            case "3" -> createSecuritySystem(api);
            case "4" -> createEndPoints(api);
            case "x", "X" -> {
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private static String menu() {
        String[] options = {
            " 1 - Upload users file",
            " 2 - Bulk create users",
            " 3 - Create Security Systems",
            " 4 - Create Endpoints",
            "",
            " x - Exit",
            "",};
        String selection;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("-------- Menu --------");
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Choose your option: ");
            selection = input.next();
        }
        return selection;
    }

    private static void uploadUsersfile(APIHandler api) throws IOException, MessagingException {
        System.out.println("");
        System.out.println("Upload users file ...");
        
        String file = prop.getProperty("UsersFileToUpload");
        if (file != null && !file.trim().isEmpty()) {
            file = DataFileDir + file;
            api.uploadFile("Datafiles", file);
        } else {
            throw new RuntimeException("UsersFileToUpload is not defined!");
        }
    }

    private static void createUsers(APIHandler api)
            throws FileNotFoundException, IOException, ParseException, MessagingException {
        System.out.println("");
        System.out.println("Create users ...");
        String NewUsersFile = prop.getProperty("BulkCreateUsersFile");
        if (NewUsersFile != null && !NewUsersFile.isEmpty()) {
            NewUsersFile = DataFileDir + NewUsersFile;

            ArrayList<SAVUser> newusers = Utils.readUsers(NewUsersFile);
            for (SAVUser user : newusers) {
                api.refreshHandler();
                try {
                    api.createUser(user);
                } catch (RuntimeException | MessagingException e) {
                    System.out.println(e.getMessage() + " " + user.getUsername());
                }

                // Instead of throwing exception, let it continue if the user already exists
                try {
                    api.addRemoveSAVRole(user, "add");
                } catch (RuntimeException | MessagingException e) {
                    System.out.println(e.getMessage() + " " + user.getUsername() + "|" + user.getSAVRoles());
                }
                try {
                    api.addRemoveUserGroup(user, "add");
                } catch (RuntimeException | MessagingException e) {
                    System.out.println(e.getMessage() + " " + user.getUsername() + "|" + user.getUserGroups());
                }
            }
        } else {
            System.out.println("BulkCreateUsersFile not defined. Skipping it.");
        }
    }
    
    private static void createSecuritySystem(APIHandler api)
            throws FileNotFoundException, IOException, ParseException, MessagingException {
        createSecuritySystem(api, "SecuritySystemFile");
    }

    private static void createSecuritySystem(APIHandler api, String parm)
            throws FileNotFoundException, IOException, ParseException, MessagingException {
        System.out.println("");
        System.out.println("Create security systems ...");
        String SecuritySystemFileDelimiter = prop.getProperty("SecuritySystemFileDelimiter", "|");
        String SecuritySystemFile = prop.getProperty(parm);
        if (SecuritySystemFile != null && !SecuritySystemFile.isEmpty()) {
            SecuritySystemFile = DataFileDir + SecuritySystemFile;
            ArrayList<SecuritySystem> securitysystems = Utils.readSecuritySystems(SecuritySystemFile, SecuritySystemFileDelimiter);
            for (SecuritySystem securitysystem : securitysystems) {
                api.refreshHandler();
                try {
                    api.createSecuritySystem(securitysystem);
                } catch (RuntimeException | IOException | MessagingException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println(parm + " not defined. Skipping it.");
        }
    }
    
    private static void createEndPoints(APIHandler api)
            throws FileNotFoundException, IOException, ParseException, MessagingException {
        createEndPoints(api, "EndPointFile");
    }

    private static void createEndPoints(APIHandler api, String param)
            throws FileNotFoundException, IOException, ParseException, MessagingException {
        System.out.println("");
        System.out.println("Create endpoints ...");
        String EndPointFileDelimiter = prop.getProperty("EndPointFileDelimiter", "|");
        String EndPointFile = prop.getProperty(param);
        if (EndPointFile != null && !EndPointFile.isEmpty()) {
            EndPointFile = DataFileDir + EndPointFile;
            ArrayList<EndPoint> endpoints = Utils.readEndpoints(EndPointFile, EndPointFileDelimiter);
            for (EndPoint endpoint : endpoints) {
                api.refreshHandler();
                try {
                    api.createEndpoint(endpoint);
                } catch (RuntimeException | IOException | MessagingException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println(param + " not defined. Skipping it.");
        }
    }
    
    private static void init() throws IOException {
        prop = new Properties();

        // load a properties file for reading
        prop.load(new FileInputStream(CONFIGFILE));
        TenantURL = prop.getProperty("TenantURL");
        if (TenantURL == null || TenantURL.trim().isEmpty()) {
            throw new RuntimeException("TenantURL is not defined!");
        } else {
            TenantURL = TenantURL.replaceAll("/$", "");
        }
        Admin_User = prop.getProperty("Admin_User");
        Admin_Password = prop.getProperty("Admin_Password");
        Refresh_Token = prop.getProperty("Refresh_Token");

        DataFileDir = prop.getProperty("DataFileDir");
        if (DataFileDir == null || DataFileDir.trim().isEmpty()) {
            throw new RuntimeException("DataFileDir is not defined!");
        }
    }
}
