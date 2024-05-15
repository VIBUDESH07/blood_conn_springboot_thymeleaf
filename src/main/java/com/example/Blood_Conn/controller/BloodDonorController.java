package com.example.Blood_Conn.controller;

import com.example.Blood_Conn.models.BloodDonor;
import com.example.Blood_Conn.service.BloodDonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BloodDonorController {
    @Autowired
    private BloodDonorService donorService;



    @GetMapping("/")
    public String show(){
        return "login";
    }



    @GetMapping("/donors")
    public String showDonors(Model model, @Param("keyword")String keyword) {
      // or any blood group you want to search for
        List<BloodDonor> donors = donorService.getAllDonors(keyword);
        model.addAttribute("donors", donors);
        return "donorsList";
    }

    @GetMapping("/donorform")
    public String showDonorform(Model model) {
        model.addAttribute("donor", new BloodDonor());
        return "donorsform";
    }


    @PostMapping("/saveDonor")
    public String saveDonor(BloodDonor donor) {
        donorService.saveDonor(donor);
        return "redirect:/donors";

    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try{
            BloodDonor user = donorService.get(id);
            if(user==null){
                throw new ArithmeticException("Could not find a user");
            }
            model.addAttribute("donor",user);

            return "donorsform";
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Integer id, Model model){
        try{
            donorService.delete(id);
            return "redirect:/donors";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

}


