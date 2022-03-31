package com.irad.dar.pdf;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;

@Controller
@RequestMapping("/form")
public class PDFController {
	@Autowired
	PdfService service;

	@Autowired
	ServletContext servletContext;

	private final TemplateEngine templateEngine;

	public PDFController(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	

	@RequestMapping(path = "/pdf1View")
	public ResponseEntity<?> getPDF1View(@RequestParam String accidentId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		System.out.print("accId rx " + accidentId);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf1Entity accident = service.getreport1(accidentId);
		String fileName = accidentId.concat("_").concat("Form1").concat("_").concat("FAR").concat(".pdf");
		accident.setCurrentDate(dtf.format(now));
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf1Entry", accident);
		String orderHtml = templateEngine.process("report1", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}



	@RequestMapping(path = "/pdf2View")
	public ResponseEntity<?> getPDF2View(@RequestParam String accidentId, String name, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Pdf2Entity accident = service.getreport2(accidentId, name);
		String fileName = accidentId.concat("_").concat("Form2").concat("_").concat(name).concat(".pdf");
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf2Entry", accident);
		String orderHtml = templateEngine.process("report2", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);

	}



	@RequestMapping(path = "/pdf3View")
	public ResponseEntity<?> getPDF3View(@RequestParam String accidentId, String vehicleId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		Pdf3Entity accident = service.getreport3(accidentId, vehicleId);

		String fileName = accidentId.concat("_").concat("Form3").concat("_").concat(accident.getDriverName())
				.concat(".pdf");
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf3Entry", accident);
		String orderHtml = templateEngine.process("report3", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	

	@RequestMapping(path = "/pdf4View")
	public ResponseEntity<?> getPDF4View(@RequestParam String accidentId, String vehicleId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Pdf4Entity accident = service.getreport4(accidentId, vehicleId);
		String fileName = accidentId.concat("_").concat("Form4").concat("_").concat(accident.getOwnername())
				.concat(".pdf");

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf4Entry", accident);
		String orderHtml = templateEngine.process("report4", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}



	@RequestMapping(path = "/pdf5View")
	public ResponseEntity<?> getPDF5View(@RequestParam String accidentId, String vehicleId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Pdf5Entity accident = service.getreport5(accidentId, vehicleId);
		String fileName = accidentId.concat("_").concat("Form5").concat("_").concat("IAR").concat("_").concat(vehicleId).concat(".pdf");

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf5Entry", accident);
		String orderHtml = templateEngine.process("report5", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf6View")
	public ResponseEntity<?> getPDF6View(@RequestParam String ref_id, String accidentId, String mode, String vehicle_id,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		Pdf6Entity accident = service.getreport6(accidentId, ref_id, mode, vehicle_id);
		//String fileName = accidentId.concat("_").concat("Form6").concat("_").concat("Victim").concat(accident.getVehicle_reg_no()).concat(".pdf");
		String fileName = accidentId.concat("_").concat("Form6").concat("_").concat("Victim").concat(vehicle_id).concat("_").concat(ref_id).concat(mode).concat(".pdf");
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf6Entry", accident);
		String orderHtml = templateEngine.process("report6", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf6aView")
	public ResponseEntity<?> getMinorChildrendataView(@RequestParam String accid, String whoseChild, String user_type,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Pdf6aEntity pdf6aEntity = service.getreport6a(accid, whoseChild, user_type);
		String fileName = accid.concat("_").concat("Form6a").concat("_").concat("Child").concat(".pdf");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		pdf6aEntity.setCurrentDate(dtf.format(now));
		byte[] bytes = null;
		List<MinorChildrenDetailsEntity1> childDetails = new ArrayList<MinorChildrenDetailsEntity1>();
		List<MinorChildrenDetailsEntity1> minorChildrenDetailsEntity = service.getMinorChildrendata(whoseChild,user_type, accid);
		
		if (minorChildrenDetailsEntity.size() != 0) {
			for (int i = 0; i < minorChildrenDetailsEntity.size(); i++) {
				childDetails.add(minorChildrenDetailsEntity.get(i));
				System.out.println(minorChildrenDetailsEntity.get(i));
				MinorChildrenDetailsEntity1 temp = minorChildrenDetailsEntity.get(i);
				System.out.println(temp.getName());
				pdf6aEntity.setChildrenDetails(childDetails);
			}
		}
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf6aEntry", pdf6aEntity);
		String orderHtml = templateEngine.process("report6a", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf7View")
	public ResponseEntity<?> getPDF7View(@RequestParam String accidentId, String vehicleId, String refId, String mode,String person_id,String type_of_person,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		Pdf7Entity accident = service.getreport7(accidentId, vehicleId, refId, mode);
		String fileName = accidentId.concat("_").concat("Form7").concat("_").concat(accident.getVehRegNo()).concat(".pdf");
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf7Entry", accident);
		String orderHtml = templateEngine.process("report7", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);

	}

	@RequestMapping(path = "/pdf8View")
	public ResponseEntity<?> getPDF8View(@RequestParam String accidentId, String vehicleId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Pdf8Entity accident = service.getreport8(accidentId, vehicleId);
		String fileName = accidentId.concat("_").concat("Form8").concat("_").concat("SitePlan").concat(".pdf");
		WebContext context = new WebContext(request, response, servletContext);
		
		String img="https://gisnic.tn.nic.in/irad_new/api/api_demo94/accmedia/image.php?id=202229592390002";
		accident.setSitePlanImage(img);
		context.setVariable("pdf8Entry", accident);
		String orderHtml = templateEngine.process("report8", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}



	@RequestMapping(path = "/pdf9View")
	public ResponseEntity<?> getPDF9View(@RequestParam String accidentId, String vehicleId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		Pdf9Entity accident = service.getreport9(accidentId, vehicleId);
		String fileName = accidentId.concat("_").concat("Form9").concat("_").concat("MIR").concat(".pdf");

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf9Entry", accident);
		String orderHtml = templateEngine.process("report9", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}



	@RequestMapping(path = "/pdf10View")
	public ResponseEntity<?> getPDF10View(@RequestParam String accidentId, String vehicleRegNo,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf10Entity vehicleDetailsEntity = service.getvehicledata(accidentId, vehicleRegNo);

		String fileName = accidentId.concat("_").concat("Form10").concat("_").concat("VerificationReport").concat("_").concat(vehicleRegNo)
				.concat(".pdf");

		vehicleDetailsEntity.setCurrentDate(dtf.format(now));
		// AccidentDetails accident=service.getreport10(accidentId,vehicleRegNo);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf10Entry", vehicleDetailsEntity);
		String orderHtml = templateEngine.process("report10", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf11View")
	public ResponseEntity<?> getPDF11View(@RequestParam String accidentId, String vehicleId, String mode,
			String personId, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("hii");
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String fileName = accidentId.concat("_").concat("Form11").concat("_").concat("Insurance").concat("_").concat(vehicleId)
				.concat(".pdf");
		Pdf11Entity pdf11Entity = service.getPdf11Report(accidentId, vehicleId, mode, personId);

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf11Entry", pdf11Entity);
		String orderHtml = templateEngine.process("report11", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+fileName)
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf12View")
	public ResponseEntity<?> getPDF12View(@RequestParam String accidentId, String vehicleId, String mode,
			String personId, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf12Entity pdf12Entity = service.getPdf12Report(accidentId, vehicleId, mode, personId);
		// vehicleDetailsEntity.setCurrentDate(dtf.format(now));
		// AccidentDetails accident=service.getreport10(accidentId,vehicleRegNo);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf12Entry", pdf12Entity);
		String orderHtml = templateEngine.process("report12", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form12.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf13View")
	public ResponseEntity<?> getPDF13View(@RequestParam String accidentId, String vehicleId, String personId,String personType, HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf13Entity pdf13Entity = service.getPdf13Report(accidentId, vehicleId, personId, personType);
		// vehicleDetailsEntity.setCurrentDate(dtf.format(now));
		// AccidentDetails accident=service.getreport10(accidentId,vehicleRegNo);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf13Entry", pdf13Entity);
		String orderHtml = templateEngine.process("report13", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form13.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf14View")
	public ResponseEntity<?> getPDF14View(@RequestParam String accidentId, String vehicleId, String personId,
			String personType, HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf14Entity pdf14Entity = service.getPdf14Report(accidentId, vehicleId, personId, personType);
		// AccidentDetails accident=service.getreport10(accidentId,vehicleRegNo);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf14Entry", pdf14Entity);
		String orderHtml = templateEngine.process("report14", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form14.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf15View")
	public ResponseEntity<?> getPDF15View(@RequestParam String accidentId, String vehicleId, String personId,
			String personType, HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		Pdf15Entity pdf15Entity = service.getPdf15Report(accidentId, vehicleId, personId, personType);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf15Entry", pdf15Entity);
		String orderHtml = templateEngine.process("report15", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form15.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf16View")
	public ResponseEntity<?> getPDF16View(@RequestParam String accidentId, String vehicleId, String personId,
			String personType, HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		List<vehicleDetailsEntity> vehicleDetails = new ArrayList<vehicleDetailsEntity>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf16Entity pdf16Entity = service.getPdf16Report(accidentId, vehicleId, personId, personType);

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf16Entry", pdf16Entity);
		String orderHtml = templateEngine.process("report16", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form16.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf17View")
	public ResponseEntity<?> getPDF17View(@RequestParam String accidentId, String vehicleRegNo,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		//Pdf17Entity pdf17Entity = new Pdf17Entity();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		Pdf17Entity pdf17Entity=service.getPdf17Report(accidentId);

		
		pdf17Entity.setAccidentId(accidentId);
		pdf17Entity.setCurrentDate(dtf.format(now));

		// AccidentDetails accident=service.getreport10(accidentId,vehicleRegNo);
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf17Entry", pdf17Entity);
		String orderHtml = templateEngine.process("report17", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form17.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf18View")
	public ResponseEntity<?> getPDF18View(@RequestParam String accidentId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf18Entity pdf18Entity=service.getPdf18Report(accidentId);
		
		pdf18Entity.setAccident_id(accidentId);
		pdf18Entity.setCurrentDate(dtf.format(now));

		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf18Entry", pdf18Entity);
		String orderHtml = templateEngine.process("report18", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form18.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	@RequestMapping(path = "/pdf19View")
	public ResponseEntity<?> getPDF19View(@RequestParam String accidentId, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf19Entity pdf19Entity = new Pdf19Entity();

		pdf19Entity.setAccidentId(accidentId);
		pdf19Entity.setCurrentDate(dtf.format(now));
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf19Entry", pdf19Entity);
		String orderHtml = templateEngine.process("report19", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form19.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}
	
	@RequestMapping(path = "/pdf20View")
	public ResponseEntity<?> getPDF20View(@RequestParam String accidentId, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		Pdf20Entity pdf20Entity = service.getPdf20Report(accidentId);
		//Pdf20Entity pdf20Entity = new Pdf20Entity();

		//pdf20Entity.setAccidentId(accidentId);
		pdf20Entity.setCurrentDate(dtf.format(now));
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("pdf20Entry", pdf20Entity);
		String orderHtml = templateEngine.process("report20", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
		byte[] bytes = target.toByteArray();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=form20.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);
	}

	// @RequestMapping(value = "/cctns", method = RequestMethod.POST)
//	public ResponseEntity<String> getData(@RequestParam String id) throws Exception {
//		HttpHeaders headers = new HttpHeaders();	      
//	      // set `content-type` header
//	      headers.setContentType(MediaType.APPLICATION_JSON);
//	      // set `accept` header
//	      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//	      // request body parameters
//	      Map<String, Object> map = new HashMap<>();
//	      map.put("iradid", id);	      
//	      // build the request
//	      HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
//	      // send POST request
//	      ResponseEntity<String> response = restTemplate.postForEntity(baseURL, entity, String.class);
//	      JSONArray jsonArray = new JSONArray(response.getBody());
//	      System.out.println("Return response"+jsonArray.length());	     	    		  
//		return response;
//	
//	}
}
