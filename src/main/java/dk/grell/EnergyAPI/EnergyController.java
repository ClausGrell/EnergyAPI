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

	private String privateAPIKEY  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlblR5cGUiOiJDdXN0b21lckFQSV9SZWZyZXNoIiwidG9rZW5pZCI6IjRiYWNjYWFlLWUxYTAtNDM1My1iM2Y2LTJmZTM0NzhiYzY4MSIsIndlYkFwcCI6WyJDdXN0b21lckFwaSIsIkN1c3RvbWVyQXBwQXBpIl0sImp0aSI6IjRiYWNjYWFlLWUxYTAtNDM1My1iM2Y2LTJmZTM0NzhiYzY4MSIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWVpZGVudGlmaWVyIjoiUElEOjkyMDgtMjAwMi0yLTg3MzMyNDk0MzMzMyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2dpdmVubmFtZSI6IkNsYXVzIEdyZWxsIiwibG9naW5UeXBlIjoiS2V5Q2FyZCIsInBpZCI6IjkyMDgtMjAwMi0yLTg3MzMyNDk0MzMzMyIsInR5cCI6IlBPQ0VTIiwidXNlcklkIjoiNTc0MTY0IiwiZXhwIjoxNjk3ODgxNDUxLCJpc3MiOiJFbmVyZ2luZXQiLCJ0b2tlbk5hbWUiOiJHcmVsbCIsImF1ZCI6IkVuZXJnaW5ldCJ9.ywXoNQFrE2yy7wxOy5UwUclzkoJgyk9VjKOeOEYmZhQ";

	
	@GetMapping("/energy/{privateAPIKEY}")
	String getDynamicUriValue(@PathVariable("privateAPIKEY") String privateAPIKEY) throws IOException, InterruptedException, JSONException, ParseException {

		String token=EnergyUtils.getToken(privateAPIKEY);
		
		JSONObject meteringJSON = EnergyUtils.requestMetering(token,"2022-10-01","2022-10-20");	
		List<MeteringPoint> meteringPointList = EnergyUtils.getMeteringPoints((JSONObject) meteringJSON);		
		EnergyUtils.storeMetering(meteringPointList);
		return meteringJSON.toString(5);
	}
}
