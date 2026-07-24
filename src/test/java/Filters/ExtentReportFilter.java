package Filters;

import Utility.ReportManager;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ExtentReportFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
    	
    	System.out.println("========== REQUEST ==========");
        System.out.println("URL : " + requestSpec.getURI());
        System.out.println("Method : " + requestSpec.getMethod());
        System.out.println("Headers : " + requestSpec.getHeaders());

        // Request Information
        ReportManager.info("Request URL", requestSpec.getURI());
        ReportManager.info("Method", requestSpec.getMethod());
        ReportManager.info("Headers", requestSpec.getHeaders().toString());

        if (requestSpec.getBody() != null) {
        	 System.out.println(requestSpec.getBody().toString());
            ReportManager.info("Request Body", requestSpec.getBody().toString());
        }

        // Actual API Call
        Response res = ctx.next(requestSpec, responseSpec);

        // Response Information
        System.out.println(res.getBody().toString());
        System.out.println(res.getBody().toString());
        System.out.println(res.asPrettyString());
        ReportManager.info("Status Code", String.valueOf(res.getStatusCode()));
        ReportManager.info("Response Time", res.time() + " ms");
        ReportManager.info("Response Body", res.asPrettyString());

        return res;
    }
}