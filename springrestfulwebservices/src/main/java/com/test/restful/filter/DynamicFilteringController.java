package com.test.restful.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

	@GetMapping("/getBeanDynamic")
	public MappingJacksonValue retriveSomeBean() {
		DynamicBean dynaBean = new DynamicBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filterProvide = new SimpleFilterProvider().addFilter("DynamicBeanfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynaBean);
		mapping.setFilters(filterProvide);
		return mapping;
	}

	@GetMapping("/getBeanListDynamic")
	public MappingJacksonValue retriveSomeBeanList() {
		List<DynamicBean> dynaList = Arrays.asList(new DynamicBean("value1", "value2", "value3"),
				new DynamicBean("a1", "a2", "a3"), new DynamicBean("b1", "b2", "b3"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filterProvide = new SimpleFilterProvider().addFilter("DynamicBeanfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynaList);
		mapping.setFilters(filterProvide);
		return mapping;
	}
}
