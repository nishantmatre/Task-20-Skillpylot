package com.skillpilots;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*;
@Controller public class BookController {
private final BookRepo repo; public BookController(BookRepo repo){this.repo=repo;}
@GetMapping("/") public String home(){return "redirect:/books";}
@GetMapping("/books") public String list(Model m){m.addAttribute("books",repo.findAll());return "books";}
@GetMapping("/books/new") public String createForm(Model m){m.addAttribute("book",new Book());m.addAttribute("pageTitle","Add Book");return "book-form";}
@PostMapping("/books") public String save(@Valid @ModelAttribute("book") Book b,BindingResult r,Model m){if(r.hasErrors()){m.addAttribute("pageTitle","Add Book");return "book-form";}repo.save(b);return "redirect:/books";}
@GetMapping("/books/{id}/edit") public String edit(@PathVariable Long id,Model m){m.addAttribute("book",repo.findById(id).orElseThrow());m.addAttribute("pageTitle","Edit Book");return "book-form";}
@PostMapping("/books/{id}") public String update(@PathVariable Long id,@Valid @ModelAttribute("book") Book b,BindingResult r,Model m){if(r.hasErrors()){b.setId(id);m.addAttribute("pageTitle","Edit Book");return "book-form";}b.setId(id);repo.save(b);return "redirect:/books";}
@GetMapping("/books/{id}/delete") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/books";}
}