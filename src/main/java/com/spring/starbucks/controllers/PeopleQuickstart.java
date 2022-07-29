package com.spring.starbucks.controllers;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.PeopleServiceScopes;
import com.google.api.services.people.v1.PeopleService.People;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;
import com.spring.starbucks.beans.UserBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class PeopleQuickstart {
	private static final String APPLICATION_NAME = "starbucks clone";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	private static final String CREDENTIALS_FILE_PATH = "credential.json";
	/**
	 * Global instance of the scopes required by this quickstart. If modifying these
	 * scopes, delete your previously saved tokens/ folder.
	 */
	private static final List<String> SCOPES = Arrays.asList(PeopleServiceScopes.CONTACTS_READONLY,
			PeopleServiceScopes.USERINFO_PROFILE, PeopleServiceScopes.USER_EMAILS_READ,
			PeopleServiceScopes.USER_PHONENUMBERS_READ, PeopleServiceScopes.USER_BIRTHDAY_READ,
			PeopleServiceScopes.USER_GENDER_READ);
	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		// Load client secrets.
		InputStream in = PeopleQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}
		Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("현재 작업 경로: " + path);
		File tokenFolder = new File(path+"/"+TOKENS_DIRECTORY_PATH);
		
		if(tokenFolder.exists()) {
			System.out.println("토큰 삭제");
			tokenFolder.delete();
		}
		
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		   
		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH))).build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

	public static UserBean start(String resourceId) throws IOException, GeneralSecurityException {
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		PeopleService service = new PeopleService.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		// Request 10 connections.
			 Person people = service.people().get("people/"+resourceId)
					 .setPersonFields(
					 "birthdays,names,phoneNumbers,nicknames,genders,emailAddresses") 
					 .execute();
		if (people != null && people.size() > 0) {
			System.out.println(people.toString());
		} else {
			System.out.println("No people found.");
		}
		
		UserBean user = new UserBean();
		user.setName(people.getNames() != null ? people.getNames().get(0).getDisplayName() : "default");
		user.setId(people.getEmailAddresses()!= null ?  people.getEmailAddresses().get(0).getValue() : "default");
		user.setPhone(people.getPhoneNumbers()!= null ? people.getPhoneNumbers().get(0).getValue() : "default");
		if(people.getGenders() !=null) {
			if(people.getGenders().get(0).getValue().equals("male")) {
				user.setSex("M");
			}
			else {
				user.setSex("F");
			}
		}
		else {
			user.setSex("M");
		}
		user.setPassword("google");
		user.setYear(people.getBirthdays() != null ? people.getBirthdays().get(0).getDate().getYear() : 1);
		user.setMonth(people.getBirthdays() != null ? people.getBirthdays().get(0).getDate().getMonth()  : 1);
		user.setDay(people.getBirthdays() != null ? people.getBirthdays().get(0).getDate().getDay() : 1);
		user.setNickname(people.getNicknames() != null ? people.getNicknames().get(0).getValue() : "default");
		
		System.out.println(user.toString());
		
		return user;
	}
}