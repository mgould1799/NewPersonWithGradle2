/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 *
 * @author meagangould
 */


@Path("test")
public class ReportingResource {
    
    private ReportingService reportingService; 
    
    public ReportingResource(){
        reportingService = new ReportingService(); 
    }


    @POST
    @Consumes("text/plain")
    @Produces(TEXT_PLAIN)
    public Response generate(
          //@FormDataParam("source") String text) throws Exception
          @DefaultValue("XYZ")@QueryParam("source") String text) throws Exception
    {
        String return_text= reportingService.reverse(text);

        return Response.ok(return_text).build();
    }

    @GET
    @Consumes("text/plain")
    @Produces(TEXT_PLAIN)
    public Response generate_two(
            //@FormDataParam("source") String text) throws Exception
            @DefaultValue("XYZ")@QueryParam("source") String text) throws Exception
    {
        String return_text= reportingService.reverse(text);

        return Response.ok(return_text).build();
    }
    
    
    
    
}




//
//package org.cirdles.squid.web;
//
//import java.io.File;
//import java.io.InputStream;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DefaultValue;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
//import org.glassfish.jersey.media.multipart.FormDataParam;
//
///**
// * Created by johnzeringue on 7/27/16.
// * Adapted by James Bowring Dec 2018.
// */
//@Path("squidReporting")
//public class SquidReportingResource {
//
//    private SquidReportingService squidReportingService;
//
//    public SquidReportingResource() {
//        squidReportingService = new SquidReportingService();
//    }
//
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces("application/zip")
//    public Response generateReports(
//            @FormDataParam("prawnFile") InputStream prawnFile,
//            @FormDataParam("prawnFile") FormDataContentDisposition contentDispositionHeader,
//            @FormDataParam("taskFile") InputStream taskFile,
//            @DefaultValue("true") @FormDataParam("useSBM") boolean useSBM,
//            @DefaultValue("false") @FormDataParam("userLinFits") boolean userLinFits,
//            @DefaultValue("") @FormDataParam("refMatFilter") String refMatFilter,
//            @DefaultValue("") @FormDataParam("concRefMatFilter") String concRefMatFilter,
//            @DefaultValue("PB_204") @FormDataParam("prefIndexIso") String preferredIndexIsotopeName)
//            throws Exception {
//
//        java.nio.file.Path pathToZip = squidReportingService.generateReports(
//                contentDispositionHeader.getFileName(), 
//                prawnFile, taskFile, useSBM, userLinFits, refMatFilter, concRefMatFilter,
//                preferredIndexIsotopeName);
//        File zippedFile = pathToZip.toFile();        
//        
//        return Response
//                .ok(zippedFile)
//                .header("Content-Disposition",
//                        "attachment; filename=squid-reports.zip")
//                .build();
//    }
//
//}

