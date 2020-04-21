package com.cts.wih;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import com.trainingspace.testempproj.Employee;

public class EmployeeWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee empIn = (Employee) workItem.getParameter("emp_in");
		empIn.setName("Bejjanki Anil Kumar");
		map.put("emp_out", empIn);
		manager.completeWorkItem(workItem.getId(), map);

	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub

	}

}
