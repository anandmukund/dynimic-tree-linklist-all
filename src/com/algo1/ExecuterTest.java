package com.algo1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterTest {

	ExecutorService executorService = Executors.newSingleThreadExecutor();

	static Set<Callable<String>> callables = new HashSet<Callable<String>>();
	{
		callables.add(new Callable<String>() {
	    public String call() throws Exception {
	        return "Task 1";
	    }
	});
	callables.add(new Callable<String>() {
	    public String call() throws Exception {
	        return "Task 2";
	    }
	});
	callables.add(new Callable<String>() {
	    public String call() throws Exception {
	        return "Task 3";
	    }
	});
	
	/*String result = null;
	try {
		result = executorService.invokeAny(callables);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println("result = " + result);

	executorService.shutdown();
*/
	List<Future<String>> futures = null;
	try {
		futures = executorService.invokeAll(callables);
		for(Future<String> future : futures){
			System.out.println("future.get = " + future.get());
		} 
	}
	catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}

	executorService.shutdown();
	}
	public static void main(String d[]){
		new ExecuterTest();
	}
}