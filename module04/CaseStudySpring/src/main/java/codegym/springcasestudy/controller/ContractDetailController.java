package codegym.springcasestudy.controller;

import codegym.springcasestudy.model.AttachService;
import codegym.springcasestudy.model.Contract;
import codegym.springcasestudy.model.ContractDetail;
import codegym.springcasestudy.service.AttachServiceService;
import codegym.springcasestudy.service.ContractDetailService;
import codegym.springcasestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private ContractService contractService;

    @ModelAttribute("contracts")
    public List<Contract> getAllContract(){
        return contractService.findAll();
    }
    @ModelAttribute("attachServices")
    public List<AttachService> getAllAttachService(){
        return attachServiceService.findAll();
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/contractDetail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView("/contractDetail/create");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("message", "New contract detail was created successful");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listContract(){
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contractDetail/list");
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @GetMapping("/delete/{contractDetailId}")
    public String deleteContractDetail(@PathVariable Long contractDetailId){
        contractService.delete(contractDetailId);
        return "redirect:/contractDetail/list";
    }
}
