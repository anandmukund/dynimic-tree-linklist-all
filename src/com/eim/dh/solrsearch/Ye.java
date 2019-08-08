package com.eim.dh.solrsearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

// How to execute the JAR
// java -jar <JAR name> <prop file path> <subject_prop_start count> <output file path> <state>

public class Ye {

	  public static void main(String[] args) throws MalformedURLException, SolrServerException, IOException {
		  
		  RequestInfo info = new RequestInfo();
		  info.setBathsAlt(2.0);
		  info.setBedsAlt(2.0);
		  info.setBldSqftAlt(1600);
		  info.setPropType("Single Family");
		  info.setValAsOfDate("2014-08-03T18:00:00Z");
		  info.setStateCd("CA");
		  info.setLat(39.635971200);
		  info.setLon(-105.078967000);
		  SolrQuery s = getsolrQuery(info);
		  	Properties prop = new Properties();
			InputStream input = null;
			 try {
					input = new FileInputStream(args[0].toString());
	
					// load a properties file
					System.out.println("Found Java Prop File at:"+args[0].toString());
					prop.load(input);
	
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

		    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    //get current date time with Date()
		    Date date_enter = new Date();
		    //System.out.println(dateFormat.format(date));
		    System.out.println("STATE = "+ (prop.getProperty("state").equals("COMMAND_LINE")? args[3] : prop.getProperty("state") ) );
		  	System.out.println("Execution Started Successfully at :"+dateFormat.format(date_enter));

		  	float miletokm=1.60934f;
		  	int search_distance=1;
		  	int max_distance=Integer.parseInt(prop.getProperty("max_distance"));
		  	int num_comps=Integer.parseInt(prop.getProperty("num_comps"));
		  
		    // Set up for the subject properties start
		    HttpSolrServer solr_subject_props = new HttpSolrServer(prop.getProperty("solr_subject_server"));
		    
		    if(Integer.parseInt(prop.getProperty("subject_logging_level"))>0)
		    	System.out.println("Solr server for subjects:" + prop.getProperty("solr_subject_server"));

		    SolrQuery query_subject_props = new SolrQuery();
		    query_subject_props.setQuery("*:*");
		    query_subject_props.setStart(Integer.parseInt(prop.getProperty("subject_prop_start"))==-1?Integer.parseInt(args[1]):Integer.parseInt(prop.getProperty("subject_prop_start")));
		    query_subject_props.set("defType", "edismax");
		    query_subject_props.set("wt", "csv");
		    
		    if (prop.getProperty("props_to_process").equals("MAX")){
		    	query_subject_props.setRows(Integer.MAX_VALUE) ;
		    }
		    else{
		    	query_subject_props.setRows(Integer.parseInt(prop.getProperty("props_to_process"))) ;
		    }

		    if (prop.getProperty("prop_id_pattern").equals("ALL")==false){
		    	query_subject_props.addFilterQuery("propertyid_i:"+prop.getProperty("prop_id_pattern"));
		    }

		    query_subject_props.addFilterQuery("state_s:"+"\""+(prop.getProperty("state").equals("COMMAND_LINE")? args[3] : prop.getProperty("state") )+"\""+"");
		    query_subject_props.set("fl","propertyid_i,latlon_p,beds_f,state_s,fips_s,bath_f,buildingarea_f,stdlandusecode_s,recordingdate_s");
		    
		    //query_subject_props.addFilterQuery("propertyid_i:27494556");
		    
		    if(Integer.parseInt(prop.getProperty("subject_logging_level"))>0)
		    	System.out.println(query_subject_props.toString());
		    QueryResponse response_subject_props = solr_subject_props.query(query_subject_props);
		    SolrDocumentList results_subject_props = response_subject_props.getResults();
		    
		    // Set up for the subject properties ends
		    
		    // Fixed set up for comp properties starts
		    HttpSolrServer solr = new HttpSolrServer(prop.getProperty("solr_server"));
		    
		    if(Integer.parseInt(prop.getProperty("comp_logging_level"))>0)
		    	System.out.println("Solr server for comps:" + prop.getProperty("solr_server"));

		    SolrQuery query = new SolrQuery();
		    query.setQuery("*:*");
		    query.setStart(0);
		    query.set("defType", "edismax");
		    query.set("wt", "csv");
		    query.setRows(num_comps) ;
		    //query.addFilterQuery("state_s:CA");
		    
		    //query.setFields("id","name"); AND query.set("fl","id,name"); are same
		    query.set("fl","propertyid_i,recordingdate_s,state_s,_dist_:geodist()");
	    
		    // Fixed set up for comp properties ends
		    
		    //System.out.println("id|latlon_p|state_s|distance");
		    BufferedWriter out = null;
		    File file = null;
		    int j=0;
			try {
		    file = new File(prop.getProperty("output_file_location").equals("CL")?args[2]+"~PROCESSING":prop.getProperty("output_file_location")+"~PROCESSING");
		    out = new BufferedWriter(new FileWriter(file, false));

		    out.write("subject_id,sub_value_as_of_dt,comp_id,comp_value_as_of_dt,state,distance");
		    out.newLine();

		    for (j = 0; j < results_subject_props.size() ; ++j) {
			    //System.out.println(results_subject_props.get(j).getFieldValue("id").toString()+"|"+results_subject_props.get(j).getFieldValue("latlon_p").toString()+"|"+results_subject_props.get(j).getFieldValue("state_s").toString());

		    	float beds_from = Float.parseFloat(results_subject_props.get(j).getFieldValue("beds_f").toString()) - 2.0f;
		    	float beds_to = Float.parseFloat(results_subject_props.get(j).getFieldValue("beds_f").toString()) + 2.0f;
		    
		    	float bath_from = Float.parseFloat(results_subject_props.get(j).getFieldValue("bath_f").toString()) - 1.0f;
		    	float bath_to = Float.parseFloat(results_subject_props.get(j).getFieldValue("bath_f").toString()) + 1.0f;

		    	float buil_area_decider;
		    	if (  500.0f > Float.parseFloat(results_subject_props.get(j).getFieldValue("buildingarea_f").toString())*0.30f){
		    		buil_area_decider = 500.0f;
		    	}
		    	else{
		    		buil_area_decider = Float.parseFloat(results_subject_props.get(j).getFieldValue("buildingarea_f").toString())*0.30f;
		    	}
		    	
		    	float buildingarea_from = Float.parseFloat(results_subject_props.get(j).getFieldValue("buildingarea_f").toString()) - buil_area_decider;
		    	float buildingarea_to = Float.parseFloat(results_subject_props.get(j).getFieldValue("buildingarea_f").toString()) + buil_area_decider;
		    	
		    	
		    	if (j%Integer.parseInt(prop.getProperty("progress_bar")) == 0 ){System.out.println("Processing :" + j);}
		    	
			    // The following settings are for fixing the box of 2 kilometer from the point pt
		    	query.setRows(num_comps) ;
			    query.set("fq","{!bbox}");
			    query.set("sfield","latlon_p");
			    query.set("pt",results_subject_props.get(j).getFieldValue("latlon_p").toString());
			    query.set("d", Float.toString(search_distance * miletokm));	
			    
			    // Following 3 settings are for spatial field, reference point, sort option
			    query.set("sfield","latlon_p");
			    query.set("pt",results_subject_props.get(j).getFieldValue("latlon_p").toString());
			    query.set("sort","geodist() asc");
			    //query.set("sort","score asc");
			    
			    query.addFilterQuery("state_s:"+"\""+results_subject_props.get(j).getFieldValue("state_s").toString()+"\""+"");
			    //query.addFilterQuery("state_s:"+results_subject_props.get(j).getFieldValue("state_s").toString()+"");
			    query.addFilterQuery("fips_s:"+results_subject_props.get(j).getFieldValue("fips_s").toString()+"");
			    query.addFilterQuery("beds_f:["+beds_from+""+" TO "+beds_to+"]");
			    query.addFilterQuery("bath_f:["+bath_from+""+" TO "+bath_to+"]");
			    query.addFilterQuery("buildingarea_f:["+buildingarea_from+""+" TO "+buildingarea_to+"]");
			    query.addFilterQuery("stdlandusecode_s:"+"\""+results_subject_props.get(j).getFieldValue("stdlandusecode_s").toString()+"\"");
			    query.addFilterQuery("recordingdate_s:[* TO "+results_subject_props.get(j).getFieldValue("recordingdate_s").toString() + "]"); // 1976-03-06T23:59:59.999Z

			    if(Integer.parseInt(prop.getProperty("comp_logging_level"))>0)
			    	System.out.println(query.toString());
			    
			    QueryResponse response = solr.query(query);
			    SolrDocumentList results = response.getResults();

			    System.out.println("Result size:"+results.size());
			    
			    int comps_remaining=0,comps_remaining2=0;

			    //Code to run the comp search based on incremental distances
			    int k=2;
			    while (results.size() < num_comps && k<=max_distance){
			    	query.set("d",Float.toString((search_distance * miletokm) + (k * miletokm)));
			    	if(Integer.parseInt(prop.getProperty("comp_logging_level"))>1)
			    		System.out.println(query.toString());
			    	response = solr.query(query);
			    	results = response.getResults();
			    	k=k+2;
			    }
			    // To decide if we need to run the secondary code to make it num_comps comps
			    if (results.size() < num_comps){
			    	comps_remaining = num_comps - results.size();
			    }

			    // Code to store the results in the file from primary run
			    for (int i = 0; i < results.size() ; ++i) {
			      //System.out.println(results.get(i));
			      if(Integer.parseInt(prop.getProperty("comp_logging_level"))>4)
			    	  System.out.println(i+","+results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
		          out.write(results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
		          out.newLine();
			    }
			    
			    // Code to search beyond the same standard use code if there are < num_comps comps as part of secondary run
			    if (comps_remaining > 0 ){
			    	String stdlandusecode_s_derived="";
			    	String stdlandusecode_s_derived2="";
			    	
/*			    	String[][] lu_group = new String[][]{
			    		  { "1999      ","1001      ","1008      ","1013      "},
			    		  { "1014      ", "1009      ","1003      ",""},
			    		  { "1002      ", "1007      ","","" },
			    		  { "1004      ", "1005      ","","" },
			    		  { "1011      ", "1012      ","1000      ","" }
			    		};
*/			    		
			    	String[][] lu_group = new String[][]{
			    		  { "Single Family","",""},
			    		  { "Townhome", "Unclassified","Condo"},
/*R#2.0 Added this one line as part of multi family comp search */		    		  
			    		  { "Multifamily", "Duplex/Triplex/Quadp","Apartment"}
			    		};		

/*R#2.0 Changed this one line as part of multi family comp search */
/*			    	for (int p=0; p < 2; p++){ */
			    		
				    for (int p=0; p < 3; p++){			    		
			    		for (int q =0;q<3;q++){
			    			if(lu_group[p][q].equals(results_subject_props.get(j).getFieldValue("stdlandusecode_s").toString())){
			    				//System.out.println("Hello"+p+":"+q+":"+lu_group[p][q]);
						    	for (int q1=0; q1 < 3; q1++){
						    		if (q1 != q){
						    		//System.out.println("Hello"+p+":"+q1+":"+lu_group[p][q1]);
						    			stdlandusecode_s_derived = stdlandusecode_s_derived + "\"" + lu_group[p][q1]+ "\" "  ;
						    		}
						    		if (p==0){
						    			stdlandusecode_s_derived2 = stdlandusecode_s_derived2 + "\"" + lu_group[1][q1]+ "\" "  ;
						    		}
/*R#2.0 Changed this one line as part of multi family comp search if not in p=2 then include everything from p=0,1*/						    		
						    		if (p==2){
						    			stdlandusecode_s_derived2 = stdlandusecode_s_derived2 + "\"" + lu_group[0][q1]+ "\" " + "\"" + lu_group[1][q1]+ "\" "  ;
						    		}
						    		//System.out.println("stdlandusecode_s:("+stdlandusecode_s_derived2+")");
						    	}
			    				break ;
			    			}
			    		}
			    	}
			    	System.out.println("stdlandusecode_s_derived:"+stdlandusecode_s_derived);

			    	// Set the params to search in use code GROUPS and then run the Query again
			    	query.setRows(comps_remaining) ;
			    	query.set("d",Float.toString(max_distance * miletokm));
			    	
			    	if (stdlandusecode_s_derived.equals("")){stdlandusecode_s_derived="0000 ";}
			    	
			    	query.removeFilterQuery("stdlandusecode_s:"+"\""+results_subject_props.get(j).getFieldValue("stdlandusecode_s").toString()+"\"");
			    	query.addFilterQuery("stdlandusecode_s:("+stdlandusecode_s_derived+")");
			    	
			    	//System.out.println("stdlandusecode_s:("+stdlandusecode_s_derived+")");
			    	
			    	if(Integer.parseInt(prop.getProperty("comp_logging_level"))>2)
			    		System.out.println(query.toString());
			    	response = solr.query(query);
			    	results = response.getResults();
			    	
			    	// Code added to write to file after stdlandusecode_s_derived comp search
				    for (int i = 0; i < results.size() ; ++i) {
				    	  if(Integer.parseInt(prop.getProperty("comp_logging_level"))>4)
				    		  System.out.println(i+","+results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
				          out.write(results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
				          out.newLine();
					    }				    	
			    	
				    comps_remaining2=comps_remaining - results.size();
				    
				    System.out.println("comps_remaining2:"+comps_remaining2);
			    	System.out.println("stdlandusecode_s_derived2:"+stdlandusecode_s_derived2);
				    
				    if (comps_remaining2 > 0 && stdlandusecode_s_derived2!=""){
				    
				    	// Code for step-3, For combining SINGLE FAMILY AND CONDO types and Multifamily
				    	query.setRows(comps_remaining2) ;
				    	query.set("d",Float.toString(max_distance * miletokm));

			    		query.removeFilterQuery("stdlandusecode_s:("+stdlandusecode_s_derived+")");
				    	query.addFilterQuery("stdlandusecode_s:("+stdlandusecode_s_derived2+")");
				    	if(Integer.parseInt(prop.getProperty("comp_logging_level"))>3)
				    		System.out.println(query.toString());
				    	response = solr.query(query);
				    	results = response.getResults();
			    	
					    for (int i = 0; i < results.size() ; ++i) {
					    	  if(Integer.parseInt(prop.getProperty("comp_logging_level"))>4)
					    		  System.out.println(i+","+results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
					          out.write(results_subject_props.get(j).getFieldValue("propertyid_i").toString()+","+results_subject_props.get(j).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("propertyid_i").toString()+","+results.get(i).getFieldValue("recordingdate_s").toString()+","+results.get(i).getFieldValue("state_s").toString()+","+Float.parseFloat(results.get(i).getFieldValue("_dist_").toString())/miletokm);
					          out.newLine();
						    }	
				    }
			    }
			    //System.out.println("break"+j);
			    out.flush();
		    }
		    out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		    File newFileName = new File(prop.getProperty("output_file_location").equals("CL")?args[2]:prop.getProperty("output_file_location"));
		    try {
		    	if (newFileName.exists()) newFileName.delete();
		    	
		    	   if (file.renameTo(newFileName)) {
		    	    System.out.println("File renamed successfull !");
		    	   } else {
		    	    System.out.println("File rename operation failed !");
		    	   }
		    } catch (Exception e) {
		    	   e.printStackTrace();
		    	  }

/*		    FileUtils.moveFile(
		    	      FileUtils.getFile(prop.getProperty("output_file_location").equals("CL")?args[2]+"~PROCESSING":prop.getProperty("output_file_location")+"~PROCESSING"), 
		    	      FileUtils.getFile(prop.getProperty("output_file_location").equals("CL")?args[2]:prop.getProperty("output_file_location")));
*/
		    
		    Date date_exit = new Date();
		    System.out.println("Exiting Successfully at:"+dateFormat.format(date_exit));
		    //long diff = date_enter.getTime() - date_exit.getTime();
		    System.out.println("Total Duration in mins:"+(date_exit.getTime() - date_enter.getTime()) / (60 * 1000) );
		    System.out.println("Total Records processed:"+ j);
		  }

	  
	  private static SolrQuery getsolrQuery(RequestInfo info) throws SolrServerException{
		    SolrQuery query = new SolrQuery();
		    double beds_from = Double.valueOf(info.getBedsAlt().toString()) - 1.0;
		    double beds_to =  Double.valueOf(info.getBedsAlt().toString()) + 1.0;
	    
		    double bath_from =  Double.valueOf(info.getBathsAlt().toString()) - 2.0;
		    double bath_to =  Double.valueOf(info.getBathsAlt().toString()) + 2.0;

		    double buil_area_decider;
	    	if (  500.0 >  Double.valueOf(info.getBldSqftAlt().toString())*0.30){
	    		buil_area_decider = 500.0f;
	    	}
	    	else{
	    		buil_area_decider =  Double.valueOf(info.getBldSqftAlt().toString())*0.30;
	    	}
	    	
	    	double buildingarea_from = Double.valueOf(info.getBldSqftAlt().toString()) - buil_area_decider;
	    	double buildingarea_to =  Double.valueOf(info.getBldSqftAlt().toString()) + buil_area_decider;
	    	
	    	
	    	
	    	query.setRows(50) ;
	    	/*query.addFilterQuery("d=" + "8.04672"+"");
		    query.addFilterQuery("add_state_abbreviation:"+info.getStateCd()+"");
		    //query.addFilterQuery("state_s:"+results_subject_props.get(j).getFieldValue("state_s").toString()+"");
		    query.addFilterQuery("property_type_text:"+info.getPropType()+"");
		    query.addFilterQuery("alt_bedroom_nbr_derived:["+beds_from+""+" TO "+beds_to+"]");
		    query.addFilterQuery("alt_bathroom_nbr_derived:["+bath_from+""+" TO "+bath_to+"]");
		    query.addFilterQuery("alt_buildingarea_sqft_derived:["+buildingarea_from+""+" TO "+buildingarea_to+"]");
		    query.addFilterQuery("ren_close_date:[* TO " + info.getValAsOfDate()+"]");
		    //query.addFilterQuery("recordingdate_s:[* TO "+results_subject_props.get(j).getFieldValue("recordingdate_s").toString() + "]"); // 1976-03-06T23:59:59.999Z
		    query.addFilterQuery("group.field="+"add_address_id"+"");
		    //query.addFilterQuery("state_s:"+results_subject_props.get(j).getFieldValue("state_s").toString()+"");
		    query.addFilterQuery("group="+"true"+"");
		    query.addFilterQuery("group.limit=" + "1"+"");
		    query.addFilterQuery("group.sort="+"ren_close_date" + " desc");
		    query.addFilterQuery("sort="+"geodist() asc" + "");
		    query.addFilterQuery("fl="+"add_address_id,ren_close_date,alt_buildingarea_sqft_derived,_dist_:geodist()"+"");
		   // query.addFilterQuery("recordingdate_s:[* TO "+results_subject_props.get(j).getFieldValue("recordingdate_s").toString() + "]"); // 1976-03-06T23:59:59.999Z
		    query.addFilterQuery("pt="+info.getLat() + "," +info.getLon() + ""); */
		    HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr/jcg");
		    QueryResponse response = solr.query(query);
		   return query;
	  }
}


