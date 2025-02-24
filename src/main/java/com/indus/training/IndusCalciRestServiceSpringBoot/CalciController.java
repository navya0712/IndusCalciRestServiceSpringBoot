package com.indus.training.IndusCalciRestServiceSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.exception.CalciException;
import com.indus.training.core.impl.Calci;

@RestController
public class CalciController {
	private final Calci calciService = new Calci();
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return "Hello Navya";
	}

	@PostMapping("/add")
	@ResponseBody
	public CalciOutput add(@RequestBody CalciInput input) throws CalciException {
		return calciService.addition(input);
	}

	@PostMapping("/subtract")
	@ResponseBody
	public CalciOutput subtract(@RequestBody CalciInput input) throws CalciException {
		return calciService.subtract(input);
	}

	@PostMapping("/multiply")
	@ResponseBody
	public CalciOutput multiply(@RequestBody CalciInput input) throws CalciException {
		return calciService.multiply(input);
	}

	@PostMapping("/divide")
	@ResponseBody
	public CalciOutput divide(@RequestBody CalciInput input) throws CalciException {
		return calciService.division(input);
	}
}