package com.algo1;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;

import javax.management.MBeanServerConnection;


public class MEMo {
	public static void main(String h[]){
	//OperatingSystemMXBean operatingSystemMXBean =  (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	try {
		System.out.println(getCpuLoad());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long total = Runtime.getRuntime().totalMemory();
	long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	System.out.println(total);
	System.out.println(used);
	}
	private static long  getCpuLoad() throws IOException {
		MBeanServerConnection mbsc = (MBeanServerConnection) ManagementFactory.getPlatformMBeanServer();
		OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
				mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
		long nanoBefore = System.nanoTime();
		long cpuBefore = ((Object) osMBean).getProcessCpuTime();
		// Call an expensive task, or sleep if you are monitoring a remote process
		long cpuAfter = ((Object) osMBean).getProcessCpuTime();
		long nanoAfter = System.nanoTime();
		long percent;
		if (nanoAfter > nanoBefore){
			percent = ((cpuAfter-cpuBefore)*100L)/(nanoAfter-nanoBefore);
		}
		else {percent = 0;}
		return percent ;
	}
}
