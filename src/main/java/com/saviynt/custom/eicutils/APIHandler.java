package com.saviynt.custom.eicutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APIHandler {

    public HttpClient client;
    public HttpGet httpGet;
    public HttpGetWithEntity httpGetWithEntity;
    public HttpPost httpPost;
    public HttpPut httpPut;
    private String baseURL;
    private String accessToken;
    private String bearer;

    public APIHandler(String url) {
        setBaseURL(url);
        initHandler();
        /*
        //client = HttpClients.createDefault();
        client = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        httpGet = new HttpGet();
        httpGetWithEntity = new HttpGetWithEntity();
        httpGetWithEntity.setHeader("Content-type", "application/json");
        
        httpPost = new HttpPost();
        httpPost.addHeader("User-Agent", "JavaSDK");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        httpPut = new HttpPut();
        httpPut.addHeader("User-Agent", "JavaSDK");
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
         */
    }

    public void refreshHandler() {
        initHandler();
        authorizeHandler();
    }

    public final void initHandler() {
        client = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        httpGet = new HttpGet();
        httpGetWithEntity = new HttpGetWithEntity();
        httpGetWithEntity.setHeader("Content-type", "application/json");

        httpPost = new HttpPost();
        httpPost.addHeader("User-Agent", "JavaSDK");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        httpPut = new HttpPut();
        httpPut.addHeader("User-Agent", "JavaSDK");
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
    }

    public void authorizeHandler() {
        httpGet.setHeader("Authorization", getBearer());
        httpGetWithEntity.setHeader("Authorization", getBearer());
        httpPost.setHeader("Authorization", getBearer());
        httpPut.setHeader("Authorization", getBearer());
    }

    public String getBaseURL() {
        return baseURL;
    }

    private void setBaseURL(String url) {
        this.baseURL = url;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String token) {
        this.accessToken = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String token) {
        this.bearer = "Bearer " + token;
    }

    // Authentcate user and obtain access token
    public String getAuthToken(String username, String password) throws UnsupportedEncodingException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/login";
        httpPost.setURI(URI.create(baseURL + api_endpoint));

        // Construct payload
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        StringEntity entity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(entity);

        HttpResponse response = client.execute((HttpUriRequest) httpPost);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + response.getStatusLine().getStatusCode());
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                result.append(inputLine);
            }

            JSONObject respObject = new JSONObject(result.toString());
            // System.out.println(result.toString());
            String token = (String) respObject.get("access_token");
            setAccessToken(token);
            setBearer(token);
            //httpGet.setHeader("Authorization", getBearer());
            //httpGetWithEntity.setHeader("Authorization", getBearer());
            //httpPost.setHeader("Authorization", getBearer());
            //httpPut.setHeader("Authorization", getBearer());
            System.out.println("Successfully login to " + getBaseURL());
        }

        return accessToken;
    }

    // Authentcate with refresh token
    public String getAuthToken(String refreshToken) throws UnsupportedEncodingException, IOException {
        String api_endpoint = "/ECM/oauth/access_token";
        httpPost.setURI(URI.create(baseURL + api_endpoint));
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("grant_type", "refresh_token"));
        params.add(new BasicNameValuePair("refresh_token", refreshToken));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute((HttpUriRequest) httpPost);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + response.getStatusLine().getStatusCode());
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                result.append(inputLine);
            }

            JSONObject respObject = new JSONObject(result.toString());
            // System.out.println(result.toString());
            String token = (String) respObject.get("access_token");
            setAccessToken(token);
            setBearer(token);
            //httpGet.setHeader("Authorization", getBearer());
            //httpGetWithEntity.setHeader("Authorization", getBearer());
            //httpPost.setHeader("Authorization", getBearer());
            //httpPut.setHeader("Authorization", getBearer());
            System.out.println("Successfully login using refresh token to " + getBaseURL());
        }

        return accessToken;
    }

    // Import transport package file
    public void importPackage(String fileFullPath)
            throws UnsupportedEncodingException, IOException, ParseException {
        System.out.println("Importing " + fileFullPath + " ...");
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/importTransportPackage";
        // httpPost.setURI(URI.create(baseURL + api_endpoint));

        // Form payload
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("packagetoimport", fileFullPath);
        jsonObject.put("businessjustification", "Import transport package.");

        sendJsonRequestwithResponse(api_endpoint, jsonObject);
        System.out.println("Successfully imported " + fileFullPath);
    }

    // https://docs.ocrolus.com/reference/multipartform-data-payloads
    // Construct payload for file upload
    private MimeMultipart uploadPayload(String pathLocation, String fileFullPath)
            throws IOException, MessagingException {
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(pathLocation);
        textPart.setDisposition("form-data; name=pathLocation");
        textPart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeBodyPart filePart = new MimeBodyPart();
        filePart.attachFile(new File(fileFullPath));
        filePart.setDisposition("form-data; name=file");

        MimeMultipart multipart = new MimeMultipart();
        multipart.setSubType("form-data");
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(filePart);

        return multipart;
    }

    // Upload file to EIC
    public void uploadFile(String pathLocation, String fileFullPath)
            throws IOException, MessagingException {
        System.out.println("Uploading " + fileFullPath + " ...");

        String api_endpoint = "/ECM/api/v5/uploadSchemaFile";
        MimeMultipart multipart = uploadPayload(pathLocation, fileFullPath);
        sendFormRequest(api_endpoint, multipart);

    }

    // Create user
    public void createUser(SAVUser user)
            throws UnsupportedEncodingException, IOException, ParseException, MessagingException {
        // System.out.println("Creating user ...");
        String api_endpoint = "/ECM/api/v5/createUser";

        JSONObject jsonObject = user.toJSON();
        makeJsonAPICall(api_endpoint, jsonObject);

        System.out.println("Successfully created user: " + user.getUsername());
    }

    // Construct payload for assigning SAV role
    private MimeMultipart savRolePayload(String username, String rolename, String action)
            throws IOException, MessagingException {
        MimeBodyPart usernamePart = new MimeBodyPart();
        usernamePart.setText(username);
        usernamePart.setDisposition("form-data; name=username");
        usernamePart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeBodyPart rolePart = new MimeBodyPart();
        rolePart.setText(rolename);
        rolePart.setDisposition("form-data; name=rolename");
        rolePart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeBodyPart operationPart = new MimeBodyPart();
        if (action.equalsIgnoreCase("add")) {
            operationPart.setText("1");
        } else {
            operationPart.setText("0");
        }
        operationPart.setDisposition("form-data; name=operation");
        operationPart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeMultipart multipart = new MimeMultipart();
        multipart.setSubType("form-data");
        multipart.addBodyPart(usernamePart);
        multipart.addBodyPart(rolePart);
        multipart.addBodyPart(operationPart);

        return multipart;
    }

    /**
     * @param user
     * @param action
     * @throws IOException
     * @throws MessagingException
     */
    public void addRemoveSAVRole(SAVUser user, String action)
            throws IOException, MessagingException {
        System.out.println("Adding/Removing user to/from SAV roles ...");
        String endPoint = "/ECM/api/v5/addremoveuserfromrole";
        String username = user.getUsername();
        String rolenames = user.getSAVRoles();
        // System.out.println("roles: " + rolenames);
        if (rolenames != null && !rolenames.trim().isEmpty()) {
            String[] roles = rolenames.split("\\|");
            for (String role : roles) {
                MimeMultipart multipart = savRolePayload(username, role, action);
                try {
                    sendFormRequest(endPoint, multipart);
                    System.out.println("Successfully " + action + " " + username + " to/from SAV role: " + role);
                } catch (IOException | MessagingException | RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    // Construct payload for assigning user gorup
    private MimeMultipart userGroupPayload(String username, String groupname, String action)
            throws IOException, MessagingException {
        MimeBodyPart usernamePart = new MimeBodyPart();
        usernamePart.setText(username);
        usernamePart.setDisposition("form-data; name=username");
        usernamePart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeBodyPart rolePart = new MimeBodyPart();
        rolePart.setText(groupname);
        rolePart.setDisposition("form-data; name=user_groupname");
        rolePart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeBodyPart operationPart = new MimeBodyPart();
        if (action.equalsIgnoreCase("add")) {
            operationPart.setText("0");
        } else {
            operationPart.setText("1");
        }
        operationPart.setDisposition("form-data; name=actionType");
        operationPart.addHeader("Content-Type", "text/plain; charset=utf-8");

        MimeMultipart multipart = new MimeMultipart();
        multipart.setSubType("form-data");
        multipart.addBodyPart(usernamePart);
        multipart.addBodyPart(rolePart);
        multipart.addBodyPart(operationPart);

        return multipart;
    }

    public void addRemoveUserGroup(SAVUser user, String action)
            throws IOException, MessagingException {
        System.out.println("Adding/Removing user to/from group ...");
        String api_endpoint = "/ECM/api/v5/addRemoveUserFromUserGroup";
        String username = user.getUsername();
        String groupnames = user.getUserGroups();
        // System.out.println("groups: " + groupnames);
        if (groupnames != null && !groupnames.trim().isEmpty()) {
            String[] groups = groupnames.split("\\|");
            for (String group : groups) {
                MimeMultipart multipart = userGroupPayload(username, group, action);
                try {
                    sendFormRequest(api_endpoint, multipart);
                    System.out.println("Successfully " + action + " " + username + " to/from user group: " + group);
                } catch (IOException | MessagingException | RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public String getEndPointID(String name) throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/getEndpoints";

        // Form payload
        JSONObject filter = new JSONObject();
        //filter.put("endpointname", name);
        // filter endpiontname doesn't work for v23.7, use displayName instead
        filter.put("displayName", name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("filterCriteria", filter);

        JSONObject result = makeJsonAPICall(api_endpoint, jsonObject);
        JSONArray endpoints = result.getJSONArray("endpoints");
        if (endpoints.length() != 1) {
            throw new RuntimeException("Retrieved either 0 or more than 1 endpionts for " + name + ". " + result.toString());
        }
        JSONObject endpoint = endpoints.getJSONObject(0);

        return endpoint.getString("id");
    }

    public String getConnectionID(String name)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/getConnectionDetails";

        // Form payload
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("connectionname", name);

        JSONObject result = makeJsonAPICall(api_endpoint, jsonObject);

        return String.valueOf(result.getInt("connectionkey"));
    }

    public String getEntitlementTypeID(String endpointName, String entTypeName)
            throws UnsupportedEncodingException, ParseException, IOException, URISyntaxException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/getEntitlementTypes";

        // Form payload
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("endpointname", endpointName));
        nameValuePairs.add(new BasicNameValuePair("entitlementname", entTypeName));

        JSONObject result = sendHttpGet(api_endpoint, nameValuePairs);
        JSONArray entitlementTypeDetails = result.getJSONArray("entitlementTypeDetails");
        if (entitlementTypeDetails.length() != 1) {
            throw new RuntimeException(
                    "Retrieved either 0 or more than 1 entitelmentTypeDetails for " + entTypeName + ". " + result.toString());
        }
        JSONObject ent = entitlementTypeDetails.getJSONObject(0);

        return String.valueOf(ent.getInt("entitlementTypeKey"));
    }

    public void createPasswordPolicy(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/createSavPasswordPolicy";
        makeJsonAPICall(api_endpoint, jsonfile);
        System.out.println("Successfully created password policy.");
    }

    // Create Security System
    public void createSecuritySystem(SecuritySystem securitysystem)
            throws UnsupportedEncodingException, IOException, ParseException, MessagingException {
        System.out.println("Creating securitysystem: " + securitysystem.getSystemname() + " ...");
        final String api_createsecuritysystem = "/ECM/api/v5/createSecuritySystem";
        final String api_updatesecuritysystem = "/ECM/api/v5/updateSecuritySystem";

        // Create security system first. No all attributes are supported in creation call
        JSONObject jsonObject = securitysystem.toCreateJSON();
        makeJsonAPICall(api_createsecuritysystem, jsonObject);

        refreshHandler();
        // Update security system to assign connection related attributes
        jsonObject = securitysystem.toUpdateJSON();
        makeJsonAPICall(api_updatesecuritysystem, jsonObject, "PUT");

        System.out.println("Successfully created securitysystem: " + securitysystem.getSystemname());
    }

    // Create EIC endpoint
    public void createEndpoint(EndPoint endpoint)
            throws UnsupportedEncodingException, IOException, ParseException, MessagingException {
        System.out.println("Creating endpoint: " + endpoint.getEndpointname() + " ...");
        String api_endpoint = "/ECM/api/v5/createEndpoint";

        JSONObject jsonObject = endpoint.toJSON();
        //System.out.println("Json payload: " + jsonObject.toString());
        makeJsonAPICall(api_endpoint, jsonObject);

        System.out.println("Successfully created endpoint: " + endpoint.getEndpointname());
    }

    // Create jobs
    public void createJobs(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/createUpdateTrigger";
        makeJsonAPICall(api_endpoint, jsonfile);
        System.out.println("Successfully created jobs.");
    }

    // Create and run job
    public void createJobAndRun(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/runJobTrigger";
        makeJsonAPICall(api_endpoint, jsonfile);
        System.out.println("Successfully created job and run it.");
    }

    // Delete job
    public void deleteJob(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        String api_endpoint = "/ECM/api/v5/deleteTrigger";
        makeJsonAPICall(api_endpoint, jsonfile);
        System.out.println("Successfully deleted.");
    }

    // Update organization
    public void updateOrganization(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/updateOrganization";
        makeJsonAPICall(api_endpoint, jsonfile, "PUT");
        System.out.println("Successfully updated organization.");
    }

    // Update entitlement type
    public void updateEntitlementType(String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        // Set calling endpoint
        String api_endpoint = "/ECM/api/v5/updateEntitlementType";
        makeJsonAPICall(api_endpoint, jsonfile, "PUT");
        System.out.println("Successfully updated entitlement type.");
    }

    // Generic method to send http get request
    private JSONObject sendHttpGet(String api_endpoint, List<NameValuePair> parameters)
            throws URISyntaxException, ClientProtocolException, IOException {
        // HttpGet httpGet = new HttpGet(baseURL + endPoint);
        URI uri = new URIBuilder(baseURL + api_endpoint)
                .addParameters(parameters)
                .build();
        httpGet.setURI(uri);
        // Send request
        HttpResponse response = client.execute(httpGet);

        // Throw exception if status code isn't 200
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
            throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                    + response.getStatusLine().getStatusCode());
        }
        String jsonString = EntityUtils.toString(response.getEntity());

        return new JSONObject(jsonString);
    }

    private JSONObject sendJsonRequestwithResponse(String api_endpoint, JSONObject jsonObject)
            throws UnsupportedEncodingException, IOException, ParseException {
        httpPost.setURI(URI.create(baseURL + api_endpoint));

        // Form payload
        StringEntity entity = new StringEntity(jsonObject.toString());
        //System.out.println("Json payload: " + jsonObject.toString());
        httpPost.setEntity(entity);

        // Send request
        HttpResponse response = client.execute((HttpUriRequest) httpPost);

        // Throw exception if status code isn't 200
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
            throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                    + response.getStatusLine().getStatusCode());
        }
        String respStr = EntityUtils.toString(response.getEntity());
        JSONObject jsonResp = new JSONObject(respStr);
        try {
            if (!jsonResp.get("errorCode").equals("0") && jsonResp.getInt("errorCode") != 0) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        } catch (JSONException e) {
            if (!jsonResp.get("errorcode").equals("0") && jsonResp.getInt("errorcode") != 0) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        }

        return jsonResp;
    }

    private JSONObject sendJsonPut(String api_endpoint, JSONObject jsonObject)
            throws UnsupportedEncodingException, IOException, ParseException {
        httpPut.setURI(URI.create(baseURL + api_endpoint));

        // Form payload
        StringEntity entity = new StringEntity(jsonObject.toString());
        // System.out.println("Json payload: " + jsonObject.toString());
        httpPut.setEntity(entity);

        // Send request
        HttpResponse response = client.execute((HttpUriRequest) httpPut);

        // Throw exception if status code isn't 200
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
            throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                    + response.getStatusLine().getStatusCode());
        }
        String respStr = EntityUtils.toString(response.getEntity());
        JSONObject jsonResp = new JSONObject(respStr);
        try {
            if (!jsonResp.get("errorCode").equals("0")) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        } catch (JSONException e) {
            if (jsonResp.getInt("errorcode") != 0) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        }

        return jsonResp;
    }

    // Generic method to send multipart form request
    private void sendFormRequest(String api_endpoint, MimeMultipart multipart)
            throws IOException, MessagingException {
        URL url = new URL(baseURL + api_endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", getBearer());
        connection.setRequestProperty("Content-Type",
                multipart.getContentType().replaceAll("(?ms)\\s*\r\n\\s*", " "));
        connection.setRequestMethod("POST");
        multipart.writeTo(connection.getOutputStream());

        connection.connect();

        // Throw exception if status code isn't 200
        if (connection.getResponseCode() != 200) {
            System.out.println(connection.getResponseMessage());
            BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) connection.getContent()));
            System.out.println(reader.lines().collect(Collectors.joining("\n")));
            throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
        }
        // Even with status code 200, if it returns errorCode isn't 0, throw exception.
        BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) connection.getContent()));
        String respStr = reader.lines().collect(Collectors.joining("\n"));
        // System.out.println(respStr);
        JSONObject response = new JSONObject(respStr);
        if (!response.get("errorCode").equals("0")) {
            throw new RuntimeException("API call error: " + response.toString());
        }
    }

    private JSONObject sendJsonGet(String api_endpoint, JSONObject jsonObject)
            throws UnsupportedEncodingException, IOException, ParseException {
        httpGetWithEntity.setURI(URI.create(baseURL + api_endpoint));
        // Form payload
        StringEntity entity = new StringEntity(jsonObject.toString());
        // System.out.println("Json payload: " + jsonObject.toString());
        httpGetWithEntity.setEntity(entity);

        // Send request
        HttpResponse response = client.execute((HttpUriRequest) httpGetWithEntity);
        //System.out.println("HTTP Response: " + response.toString());
        // Throw exception if status code isn't 200
        if (response.getStatusLine().getStatusCode() != 200) {
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
            throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                    + response.getStatusLine().getStatusCode());
        }
        String respStr = EntityUtils.toString(response.getEntity());
        JSONObject jsonResp = new JSONObject(respStr);
        try {
            if (!jsonResp.get("errorCode").equals("0")) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        } catch (JSONException e) {
            if (jsonResp.getInt("errorcode") != 0) {
                throw new RuntimeException("API call error: " + jsonResp.toString());
            }
        }

        return jsonResp;
    }

    public JSONObject makeJsonAPICall(String api_endpoint, JSONObject jsonObject)
            throws UnsupportedEncodingException, ParseException, IOException {
        return sendJsonRequestwithResponse(api_endpoint, jsonObject);
    }

    public JSONObject makeJsonAPICall(String api_endpoint, JSONObject jsonObject, String method)
            throws UnsupportedEncodingException, ParseException, IOException {
        if (method.equalsIgnoreCase("POST")) {
            return sendJsonRequestwithResponse(api_endpoint, jsonObject);
        } else if (method.equalsIgnoreCase("PUT")) {
            return sendJsonPut(api_endpoint, jsonObject);
        } else if (method.equalsIgnoreCase("GETWITHBODY")) {
            return sendJsonGet(api_endpoint, jsonObject);
        } else {
            throw new RuntimeException("HTTP method not defined");
        }
    }

    public JSONObject makeJsonAPICall(String api_endpoint, String jsonfile)
            throws UnsupportedEncodingException, ParseException, IOException {
        String method = "POST";
        return makeJsonAPICall(api_endpoint, jsonfile, method);
    }

    public JSONObject makeJsonAPICall(String api_endpoint, String jsonfile, String method)
            throws UnsupportedEncodingException, ParseException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(jsonfile)));
        final JSONObject json = new JSONObject(content);
        // System.out.println(json);
        if (method.equalsIgnoreCase("POST")) {
            return sendJsonRequestwithResponse(api_endpoint, json);
        } else if (method.equalsIgnoreCase("PUT")) {
            return sendJsonPut(api_endpoint, json);
        } else {
            throw new RuntimeException("HTTP method not defined");
        }
    }
    
    public void test() throws URISyntaxException, IOException {
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        HttpGet httpget = new HttpGet();
        httpget.setHeader("Authorization", getBearer());

        String api_endpoint = "/ECM/api/v5/getEntitlementTypes";
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("endpointname", "Active Directory"));
        nameValuePairs.add(new BasicNameValuePair("entitlementname", "memberOf"));

        URI uri = new URIBuilder(baseURL + api_endpoint)
                .addParameters(nameValuePairs)
                .build();
        httpget.setURI(uri);
        // Send request
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            String jsonString = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + jsonString);
            EntityUtils.consume(entity);
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
                throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                        + response.getStatusLine().getStatusCode());
            }
        } finally {
            response.close();
        }

        // Round 2
        nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("endpointname", "ServiceNow"));
        nameValuePairs.add(new BasicNameValuePair("entitlementname", "Group"));
        uri = new URIBuilder(baseURL + api_endpoint)
                .addParameters(nameValuePairs)
                .build();
        httpget.setURI(uri);
        // Send request
        response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            String jsonString = EntityUtils.toString(response.getEntity());
            System.out.println("Response: " + jsonString);
            EntityUtils.consume(entity);
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.name()));
                throw new RuntimeException("Request endpoint: " + api_endpoint + "\n" + "HTTP error code: "
                        + response.getStatusLine().getStatusCode());
            }
        } finally {
            response.close();
        }
    }

}
