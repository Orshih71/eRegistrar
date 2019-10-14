package cs425.lab8.eregistrar.controller;

import cs425.lab8.eregistrar.model.Student;
import cs425.lab8.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/eRegistrar/student/list"})
    public ModelAndView listStudents(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentsPaged(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eRegistrar/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @GetMapping(value = {"/eRegistrar/student/search"})
    public ModelAndView displayStudentSearchForm(@RequestParam(name ="studentNumber",defaultValue = "") String studentNumber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.findByStudentNumberContains(studentNumber));
        modelAndView.setViewName("student/search");
        return modelAndView;
    }

    @PostMapping(value = {"/eRegistrar/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        studentService.saveStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    @GetMapping(value = {"/eRegistrar/student/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eRegistrar/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    @GetMapping(value = {"/eRegistrar/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eRegistrar/student/list";
    }

}
