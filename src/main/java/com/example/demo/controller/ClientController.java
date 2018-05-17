package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public String listClient(Model model) {
		List<Client> allClients = clientService.getAllClients();
		model.addAttribute("allClients", allClients);
		return "clients";
	}
	
	@GetMapping("/clients/{id}")
	public String getClient(Model model, @PathVariable(value="id") String clientId) {
		Client client = clientService.getClientById(Long.parseLong(clientId));
		model.addAttribute("client", client);
		return "client";
	}


	@PostMapping("/clients")
	public String updateClient(Model model, @ModelAttribute("client") @Validated Client clientDto, BindingResult result, final RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			clientService.updateClient(clientDto);
		}
		else {
			redirectAttributes.addFlashAttribute("msg", "Please check form");
		}
		
		return "redirect:/clients/" + clientDto.getClientId();
	}

}


