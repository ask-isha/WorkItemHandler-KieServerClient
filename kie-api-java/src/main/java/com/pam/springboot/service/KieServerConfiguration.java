package com.pam.springboot.service;

import java.util.HashSet;
import java.util.Set;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

import com.trainingspace.testempproj.Employee;

public class KieServerConfiguration {

	protected String serverURL = "http://localhost:8080/kie-server/services/rest/server";
	protected String kieUser = "krisv";
	protected String password = "krisv";

	private KieServicesConfiguration configureKieServices() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Employee.class);
		KieServicesConfiguration kieConfiguration = null;
		kieConfiguration = KieServicesFactory.newRestConfiguration(serverURL, kieUser, password);
		kieConfiguration.setMarshallingFormat(MarshallingFormat.JSON);
		kieConfiguration.setExtraJaxbClasses(set);
		return kieConfiguration;
	}

	public KieServicesClient getKieClient() {
		KieServicesClient kieServicesClient = null;
		KieServicesConfiguration configuration = configureKieServices();
		kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
		return kieServicesClient;

	}

}
