package dk.grell.EnergyAPI;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class EnergyController{


	@GetMapping("/energy/{location}/{fromDate}/{toDate}")
	String requestMeterData(@PathVariable("location") String location,
							@PathVariable("fromDate") String fromDate,
							@PathVariable("toDate") String toDate) throws IOException, InterruptedException, JSONException, ParseException {

		String token=EnergyUtils.getToken(location);
		JSONObject meteringJSON = EnergyUtils.requestMetering(token,fromDate,toDate);
		List<MeteringPoint> meteringPointList = EnergyUtils.getMeteringPoints((JSONObject) meteringJSON);
		EnergyUtils.storeMetering(location,meteringPointList);
		return "ok..."; //meteringJSON.toString(5);
	}

	@GetMapping("/download/{location}")
	String requestStoredData(@PathVariable("location") String location) throws IOException, InterruptedException, JSONException, ParseException {
		return EnergyOutput.getMeteringPointsAsHtml(location);

	}


}
